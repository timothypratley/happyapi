# HappyAPI

<img src="HappyAPI.svg" alt="HappyAPI logo" width="200" align="right"/>

A Clojure library for OAuth2.
A unified approach for interacting with web APIs instead of relying on custom clients per API.
Creates simple, handy and useful API clients.


|        | Happy                                                                                                   |
|--------|---------------------------------------------------------------------------------------------------------|
| Simple | use and compose the parts you like, with a crystallized default for convenience                         |
| Handy  | generates function signatures that are explorable in your IDE, bringing usage and documentation to hand |
| Useful | a better way to call your favourite web service                                                         |


## Status

Alpha: seeking feedback.

## Features

* OAuth2
* Code generation for endpoints
* Pluggable dependencies for http and json
* Middleware for flexibly constructing your own request stack
* Sync and async

## Generated libraries

* [HappyGAPI](https://github.com/timothypratley/happygapi) for
  calling [Google APIs](https://developers.google.com/apis-explorer); gsheets, drive, bigquery, youtube, and so on.
* TODO: more

## Rationale

Large datasets and extensive functionality are available to us through web APIs,
but calling these services is often a study in incidental complexity.
Client libraries are over-specific ([death by specificity](https://www.youtube.com/watch?v=aSEQfqNYNAc) x 100).
We can do better with maps.

Many interesting webservices need OAuth2 to access them.
HappyAPI is primarily a configurable and flexible OAuth2 client.

The middleware pattern allows users flexibility to do things differently, and to reuse parts when accessing APIs from another provider.
Middleware is preferable to protocols; the key abstraction is a function that makes a request.
Other client concerns such as connection pools may be captured in a closure.

Users have choices for http and json dependencies.
Their client should respect those and use them instead of bringing in another dependency.

HappyAPI emphasizes discoverability without objects by generating code and documentation from an API discovery document.
HappyAPI generates functions (as code, not macros) for calling API endpoints,
so that your editor can help you:

1. Autocomplete; See all available resources and methods
2. Help documentation; The function doc-strings contain a description, a link to online docs, and example inputs (TODO:
   is this true?)
3. Arity checking; Required parameters are function args
4. Informative exceptions on failure

Having the shape of requests at hand saves tedious research.

The discovery of GAPIs was inspired by [clj-gapi](https://github.com/ianbarber/clj-gapi).
See Google API discovery: https://developers.google.com/discovery/v1/getting_started

This approach should work well with other discovery documents, hopefully AWS will be added soon.

## Usage


Hopefully you'll find the generated libraries like [HappyGAPI2](https://github.com/timothypratley/happygapi2) useful and won't need to use HappyAPI directly.

If you prefer to use HappyAPI directly (perhaps you don't like generated code, or no generated library exists for the service provider),
add the dependency to your project file:

[![Clojars Project](https://img.shields.io/clojars/v/io.github.timothypratley/happyapi.svg)](https://clojars.org/io.github.timothypratley/happyapi)

**Important: You'll also need `clj-http` and `cheshire`, or one of their alternatives, see [Dependencies](#dependencies) below for more details**

### Service providers

Currently supported:

* Google
* Amazon
* GitHub
* Twitter

Adding a custom provider can often be done with configuration,
if they follow common conventions.

### Service provider specific usage

```clojure
(require '[happyapi.providers.google :as google])
(google/setup! {:client_id "XYZ"
                :client_secret (System/getenv "GOOGLE_CLIENT_SECRET")
                :deps [:clj-http :cheshire]})
(google/api-request {:method       :get
                     :url          "https://youtube.googleapis.com/youtube/v3/channels"
                     :query-params {:part        "contentDetails,statistics"
                                    :forUsername "ClojureTV"}
                     :scopes       ["https://www.googleapis.com/auth/youtube.readonly"]})
```

The generated code has all the endpoint and parameter information built in and constructs a request like this through `api-request`.

If `setup!` is not called, the first call to `api-request` will attempt to configure itself by looking for an environment variable `HAPPYAPI_CONFIG`,
or a file `happyapi.edn`.
See the docstring for `happyapi.setup/make-client` for more information about configuration.

### Custom service providers

```clojure
(require '[happyapi.setup :as setup])

(def api-request
  (setup/make-client
    {:my-provider {:client_id "MY_CLIENT_ID"
                   :client_secret (System/getenv "MY_CLIENT_SECRET")}}
    :my-provider))

(api-request {:method :get
              :url "https://my.provider/endpoint"
              :query-params {:foo "bar"}})
```

HappyAPI is highly configurable.
If you require further customization,
you can also construct a stack of middleware using the `happyapi.oauth2.client` namespace for authentication,
and `happyapi.oauth2.middleware` for useful miscellaneous conveniences.

### Dependencies

You need http and json dependencies present in your project to use HappyAPI.
HappyAPI avoids creating a direct dependency because there are many implementations to choose from.

* http client (clj-http, clj-http.lite, httpkit)
* json encoder/decoder (cheshire, jsonista, clojure.data.json, charred)
* A web server to receive redirects (ring-jetty-adapter, httpkit<soon>)

To choose your dependencies, pass `:deps [:httpkit :jsonista]`, or similar, as config to `setup/make-client`.

When unconfigured, HappyAPI will default to looking for clj-http and cheshire.

See `happyapi.deps` namespace for more information about dependency resolution.

#### Choose a http client

[![Clojars Project](https://img.shields.io/clojars/v/clj-http.svg)](https://clojars.org/clj-http)
[![Clojars Project](https://img.shields.io/clojars/v/org.clj-commons/clj-http-lite.svg)](https://clojars.org/org.clj-commons/clj-http-lite)
[![Clojars Project](https://img.shields.io/clojars/v/http-kit.svg)](https://clojars.org/http-kit)

#### Choose a web server

[![Clojars Project](https://img.shields.io/clojars/v/ring.svg)](https://clojars.org/ring)

TODO: can we remove [ring](https://github.com/ring-clojure/ring) as a dependency?
TODO: allow httpkit to be used as the server

#### Choose a json encoder/decoder

[![Clojars Project](https://img.shields.io/clojars/v/cheshire.svg)](https://clojars.org/cheshire)
[![Clojars Project](https://img.shields.io/clojars/v/metosin/jsonista.svg)](https://clojars.org/metosin/jsonista)
[org.clojure/data.json](https://github.com/clojure/data.json)
[![Clojars Project](https://img.shields.io/clojars/v/com.cnuernber/charred.svg)](https://clojars.org/com.cnuernber/charred)

### Authorization

To participate in OAuth2 you need to fetch and store tokens.

To create an app in the Google Console,
follow [Setting up OAuth 2.0](https://support.google.com/googleapi/answer/6158849?hl=en).
When setting up the app credentials, add http://localhost/redirect to the authorized redirect URIs,
and add yourself as a test user.

There are two methods for obtaining a token:

* User redirects, which prompt a user to authorize your app.
  Download the `secret.json` from the [Google Console](https://console.cloud.google.com/).
  **Do not add this file to source control, keep it secured.**
  This method is suitable if you want users to grant your app access to their data.
* Service account private key (suitable for server to server).
  [Create a Service account](https://developers.google.com/identity/protocols/oauth2/service-account)
  and download a `service.json` key file.
  **Do not add this file to source control, keep it secured.**
  This method is suitable for automated jobs.

By default, HappyAPI tries to read configuration from the environment variable `HAPPYAPI_CONFIG`,
then from a file `happyapi.edn`.

### Credentials and token storage

`happyapi.oauth2-credentials` stores tokens on disk in the `tokens` directory.

**You should .gitignore the `tokens` directory to prevent them being stored in source control.**

If you want to use HappyAPI in a web app, you should instead store and fetch tokens from your database.

The `happyapi.oauth2.capture-redirect` namespace implements a listener to capture a code when the user is redirected from the oauth2 provider.
Web applications should instead define a route to capture the code.

### Retries

HappyAPI leaves retries up to the consuming application. See the [`again`](https://github.com/liwp/again) library.

## Generating new wrappers

See `dev` directory for `happyapi.gen` namespaces.

## Contributing

Issues, pull requests, and suggestions are welcome.

## Testing

To run the tests you need to download `secret.json` from the Google console and convert it to a `happyapi.edn` file.

```
clojure -M:dev:test
```

## Building

The api namespaces can be generated by running `happyapi.gen.google.lion/-main`

```
clojure -T:dev:build build/jar
```

## Deploying

```
env CLOJARS_USERNAME=username CLOJARS_PASSWORD=clojars-token clojure -T:dev:build build/deploy
```

## License

Copyright © 2020 Timothy Pratley

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
