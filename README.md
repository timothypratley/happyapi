# HappyAPI

<img src="HappyAPI.svg" alt="HappyAPI logo" width="200" align="right"/>

A Clojure library for OAuth2.
A unified approach for interacting with web APIs instead of relying on custom clients per API.
Creates simple, handy and useful API clients.


|        | Happy                                                                   |
|--------|-------------------------------------------------------------------------|
| Simple | use and compose the parts you like                                      |
| Handy  | generates function signatures, bringing usage and documentation to hand |
| Useful | crystallized per provider for your favourite web service                |


## Features

* OAuth2
* Code generation for endpoints
* Pluggable dependencies for http and json
* Middleware for flexibly constructing your own request stack
* Sync and async

## Generated libraries

* [happyapi.google](https://github.com/timothypratley/happyapi.google)
  for calling [Google APIs](https://developers.google.com/apis-explorer); 
  gsheets, drive, bigquery, youtube, and so on.

## Rationale

Large datasets and extensive functionality are available to us through web APIs,
but calling these services is often a study in incidental complexity.
Client libraries are [over-specific](https://www.youtube.com/watch?v=aSEQfqNYNAc) ^2.
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
2. Help documentation; The function doc-strings contain a description, a link to online docs, and example inputs
3. Arity checking; Required parameters are function args
4. Informative exceptions on failure

Having the shape of requests at hand saves tedious research.

The discovery of GAPIs was inspired by [clj-gapi](https://github.com/ianbarber/clj-gapi).
See Google API discovery: https://developers.google.com/discovery/v1/getting_started

This approach should work well with other discovery documents, hopefully AWS will be added soon.

## Usage

[![Clojars Project](https://img.shields.io/clojars/v/io.github.timothypratley/happyapi.svg)](https://clojars.org/io.github.timothypratley/happyapi)
[![Clojars Project](https://img.shields.io/clojars/v/io.github.timothypratley/happyapi.google.svg)](https://clojars.org/io.github.timothypratley/happyapi.google)

**Important: You'll also need `clj-http` and `cheshire`, or one of their alternatives, see [Dependencies](#dependencies) below for more details**

### Service providers

Currently supported

* Google
* Amazon
* GitHub
* Twitter

Adding a custom provider can often be done with configuration,
if they follow common conventions.

### Service provider specific usage

For Google APIs you can use the generated wrapper from the `happyapi.google` project.

```clojure
(require '[happyapi.providers.google :as google])
(require '[happyapi.google.youtube-v3 :as youtube])
(google/api-request (youtube/channels-list "contentDetails,statistics" {:forUsername "ClojureTV"}))
```

The generated wrapper constructs a request for `happyapi.providers.google/api-request`.
You can make custom, non-generated `api-requests` directly by passing the required arguments.

```clojure
(require '[happyapi.providers.google :as google])
(google/setup! {:client_id     "XYZ"
                :client_secret (System/getenv "GOOGLE_CLIENT_SECRET")
                :deps          [:jetty :clj-http :cheshire]})
(google/api-request {:method       :get
                     :url          "https://youtube.googleapis.com/youtube/v3/channels"
                     :query-params {:part        "contentDetails,statistics"
                                    :forUsername "ClojureTV"}
                     :scopes       ["https://www.googleapis.com/auth/youtube.readonly"]})
```

**Keep your client_secret secure. Do not add it directly in your code.**
Looking it up from the environment is a common way to avoid leaking client_secret to source control.

If `setup!` has not been called,
the first call to `api-request` will attempt to configure itself.

### Configuration

When no configuration is provided,
HappyAPI tries to read configuration from the environment variable `HAPPYAPI_CONFIG`,
then from a file `happyapi.edn`, and then from a resource `happyapi.edn`.

```clojure
{:google {:deps            [:httpkit :cheshire]   ;; see happyapi.deps for alternatives
          :fns             {...}                  ;; if you prefer to provide your own dependencies
          :client_id       "MY_ID"                ;; oauth2 client_id of your app
          :client_secret   "MY_SECRET"            ;; oauth2 client_secret from your provider
          :apikey          "MY_APIKEY"            ;; only when not using oauth2
          :scopes          []                     ;; optional default scopes
          :keywordize-keys true}}                 ;; optional
```

**Keep your client_secret secure.** Add `happyapi.edn` to `.gitignore` to avoid adding it to source control.

### Redirect port

When no port is specified (for example `:redirect_uri "http://localhost/redirect"`), HappyAPI listens on the default http port 80.

Port 80 is a privileged port that requires root permissions, which may be problematic for some users.
Google and GitHub allow the `redirect_uri` port to vary.
Other providers do not.
A random port is a natural choice.
Configuring `:redirect_uri "http://localhost:0/redirect"` will listen on a random port.
This is the default used for Google and GitHub if not configured otherwise.

You can choose a port if you'd like.
If you want to listen on port 8080, configure `:redirect_uri "http://localhost:8080/redirect"`
This is the default used for Twitter if not configured otherwise.

You must update your provider settings to match either the default, or your own `redirect_uri`.
Providers require an exact match between the provider side settings and client config,
so please check this carefully if you get an error.

### Instrumentation, logging, and metrics

A common desire is to log or count every http request for telemetry.
This can be done by passing a wrapped `request` function, var, or qualified symbol in setup.
Symbols will be resolved.

```clojure
(google/setup! {:client_id     "XYZ"
                :client_secret (System/getenv "GOOGLE_CLIENT_SECRET")
                :deps          [:httpkit :cheshire]
                :fns           {:request my-wrapped-request-fn}})
```

### Custom service providers

```clojure
(require '[happyapi.setup :as setup])

(def api-request
  (setup/make-client
    {:my-provider {:client_id "MY_CLIENT_ID"
                   :client_secret (System/getenv "MY_CLIENT_SECRET")
                   :deps [:jetty :clj-http :cheshire]}}
    :my-provider))

(api-request {:method :get
              :url "https://my.provider/endpoint"
              :query-params {:foo "bar"}})
```

### Dependencies

You need HTTP and JSON dependencies.
HappyAPI avoids creating a direct dependency because there are many implementations to choose from.

* http client (clj-http, clj-http.lite, httpkit)
* json encoder/decoder (cheshire, jsonista, clojure.data.json, charred)
* A web server to receive redirects (jetty, httpkit)

To choose your dependencies,
configure `:deps [:httpkit :cheshire]`, or `:deps [:clj-http :jetty :charred]`,
or whichever combo you want to use.

There are no defaults.
If you can't decide which to use, then I suggest `[:httpkit :cheshire]`

Valid keys are `#{:cheshire :clj-http.lite :jetty :clj-http :data.json :httpkit :jsonista :charred}`

**Configuration of either `:deps` or `:fns` is required.**

If you wish, pass an explicit function, var, or qualified symbol instead:

```clojure
:fns {:request my-http-request
      :query-string 'my-ns/my-query-string
      :encode #'my-json-write
      :decode my-json-parse}
```

Or a combination of both:
```clojure
:deps [:httpkit]
:fns {:encode my-json-write
      :decode my-json-parse}
```

See `happyapi.deps` namespace for more information about dependency resolution.

#### Choose a http client

[![Clojars Project](https://img.shields.io/clojars/v/http-kit.svg)](https://clojars.org/http-kit)
[![Clojars Project](https://img.shields.io/clojars/v/clj-http.svg)](https://clojars.org/clj-http)
[![Clojars Project](https://img.shields.io/clojars/v/org.clj-commons/clj-http-lite.svg)](https://clojars.org/org.clj-commons/clj-http-lite)

#### Choose a web server

[![Clojars Project](https://img.shields.io/clojars/v/http-kit.svg)](https://clojars.org/http-kit)
[![Clojars Project](https://img.shields.io/clojars/v/ring.svg)](https://clojars.org/ring)
[![Clojars Project](https://img.shields.io/clojars/v/ring/ring-jetty-adapter.svg)](https://clojars.org/ring/ring-jetty-adapter)

#### Choose a json encoder/decoder

[![Clojars Project](https://img.shields.io/clojars/v/cheshire.svg)](https://clojars.org/cheshire)
[![Clojars Project](https://img.shields.io/clojars/v/com.cnuernber/charred.svg)](https://clojars.org/com.cnuernber/charred)
[![Clojars Project](https://img.shields.io/clojars/v/metosin/jsonista.svg)](https://clojars.org/metosin/jsonista)
[org.clojure/data.json](https://github.com/clojure/data.json)

### Authorization

To participate in OAuth2 you need to fetch and store tokens.

To create an app in the Google Console,
follow [Setting up OAuth 2.0](https://support.google.com/googleapi/answer/6158849?hl=en).

When setting up the app credentials, add http://localhost:PORT/redirect to the authorized redirect URIs,
and add yourself as a test user.

PORT may be omitted for port 80.
Listening on port 80 may not be possible for users that do not have root permissions.
If you specify port 0, a random port will be used.
The only known provider that supports random ports is Google.
The default `redirect_uri` for Google specifies port 0 for random port selection.

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

### Credentials and token storage

`happyapi.oauth2-credentials` stores tokens on disk in the `tokens` directory.

**You should .gitignore the `tokens` directory to prevent them being stored in source control.**

If you want to use HappyAPI in a web app, you should instead store and fetch tokens from your database.

The `happyapi.oauth2.capture-redirect` namespace implements a listener to capture a code when the user is redirected from the oauth2 provider.
Web applications should instead define a route to capture the code.

To override credential management, configure `fns`:

```
{:fns {:read-credentials   credentials/read-credentials
       :update-credentials capture-redirect/update-credentials
       :save-credentials   credentials/save-credentials}}
```

Values should be either a fully qualified symbol, a var, or function.

### Keywordization

While keywordization is common practise in Clojure,
it can be problematic when receiving arbitrary data because not all keys make valid keywords.
HappyAPI follows the convention of JSON defaults to use string keys instead of keywords.

You can pass `keywordize-keys true` as configuration if you prefer keyword keys.
You can also pass `keywordize-keys (true|false)` to individual requests.

My recommendation is to avoid keywordization.
When you run into a non-keywordizable key it can be a real headache.

### Pagination

HappyAPI retrieves all pages and join the results together.
It also unwraps extraneous keys like `data` and `items`.
It returns data, not responses.

### Retries

HappyAPI leaves retries up to the consuming application. See the [`again`](https://github.com/liwp/again) library.

### Composing middleware

HappyAPI is highly configurable.
If you require further customization,
you can construct a stack of middleware using the `happyapi.oauth2.client` namespace for authentication,
and `happyapi.oauth2.middleware` for useful miscellaneous conveniences.

## Generating wrappers

See `dev` directory for `happyapi.gen` namespaces.

## Third Party Apps

If you are implementing your own web service, you may find these useful:

[Blog: What color is your auth?](https://www.kpassa.me/posts/happyapi-temporal/)

[Youtube: What color is your auth?](https://www.youtube.com/watch?v=mmOh5fYkX7Q)

## Contributing

Issues, pull requests, and suggestions are welcome.

If you are looking for things to improve, see also [docs/DESIGN.md#future-work](docs/DESIGN.md#future-work)


## Testing

To run the tests you need to download `secret.json` from the Google console and convert it to a `happyapi.edn` file.

```
clojure -M:dev:test
```

## Building

The api namespaces can be generated by running `happyapi.gen.google.lion/-main`

```
clojure -M:dev
```

Preparing a jar file

```
clojure -T:build build/jar
```

## Deploying

```
clojure -T:build build/jar
```

Revert the tag change to pom.xml so there are no unstaged git changes

```
clojure -T:build build/tag
```

```
env CLOJARS_USERNAME=username CLOJARS_PASSWORD=clojars-token clojure -T:build build/deploy
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
