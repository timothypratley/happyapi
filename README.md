# HappyAPI

Creates simple, handy and useful API clients.

|        | Happy                                                                                                   |
|--------|---------------------------------------------------------------------------------------------------------|
| Simple | use and compose the parts you like, with a crystallized default for convenience                         |
| Handy  | generates function signatures that are explorable in your IDE, bringing usage and documentation to hand |
| Useful | a better way to call your favourite web service                                                         |

A unified approach for interacting with web APIs instead of relying on custom clients per API.

## Features

* OAuth2
* Code generation
* Middleware for flexibly constructing your own request stack
* Pluggable dependency detection for http and json
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

Hopefully you'll find the generated libraries like [HappyGAPI](https://github.com/timothypratley/happygapi) useful and
won't need to use HappyAPI directly.

If you prefer to use HappyAPI directly (perhaps you don't like generated code, or no generated library exists for the
service),
add the dependency to your project file:


[![Clojars Project](https://img.shields.io/clojars/v/io.github.timothypratley/happyapi.svg)](https://clojars.org/io.github.timothypratley/happyapi)


### Dependencies

A http client, web server, and json library must be available for HappyAPI to work.
You'll need one of each of these:

#### Choose a http client

[![Clojars Project](https://img.shields.io/clojars/v/clj-http.svg)](https://clojars.org/clj-http)
[![Clojars Project](https://img.shields.io/clojars/v/http-kit.svg)](https://clojars.org/http-kit)

#### Choose a web server

[![Clojars Project](https://img.shields.io/clojars/v/ring.svg)](https://clojars.org/ring)

#### Choose a json encoder/decoder

[![Clojars Project](https://img.shields.io/clojars/v/cheshire.svg)](https://clojars.org/cheshire)
[![Clojars Project](https://img.shields.io/clojars/v/metosin/jsonista.svg)](https://clojars.org/metosin/jsonista)
[org.clojure/data.json](https://github.com/clojure/data.json)

Require `happy.oauth2.client` in the code:

```clojure
(ns my.ns
  (:require [happy.oauth2.client :as client]))
```

And make requests

```clojure
(client/api-request {...})
```

### Authorization

To participate in OAuth2 you need to fetch and store tokens.

To create an app in the Google Console,
follow [Setting up OAuth 2.0](https://support.google.com/googleapi/answer/6158849?hl=en).
When setting up the app credentials, add http://localhost/redirect to the authorized redirect URIs, and add yourself as
a test user.

There are two methods for obtaining a token:

* User redirects, which prompt a user to authorize your app.
  Download the `secret.json` from the [Google Console](https://console.cloud.google.com/).
  Do not add this file to source control, keep it secured.
  This method is suitable if you want users to grant your app access to their data.
* Service account private key (suitable for server to server).
  [Create a Service account](https://developers.google.com/identity/protocols/oauth2/service-account)
  and download a `service.json` key file.
  Do not add this file to source control, keep it secured.
  This method is suitable for automated jobs.

By default, it tries to read `secret.json` or `service.json` from disk in the current directory.
You can pass in configuration map of the same shape instead.
`happy.oauth2-credentials` stores tokens on disk.
If you want to use HappyAPI in a web app, you should instead store and fetch tokens from your database.

The [`happy.oauth2.capture-redirect`](src/happy/oauth2/capture_redirect.clj)
namespace provides a listener to capture a code when the user is redirected to your site from the oauth2 provider.
If you use it, you will need to include [ring](https://github.com/ring-clojure/ring) as a dependency.
Web applications should instead define a route to capture the code.

### Retries

HappyAPI leaves retries up to the consuming application.
However, if you are doing many requests, it is likely you will want to retry failed requests,
as failures can happen for a variety of availability reasons.
See the "[again](https://github.com/liwp/again)" library.

## Generating new wrappers

See `dev` directory.

## Contributing

Issues, pull requests, and suggestions are welcome.

## Testing

To run the tests you need to download `secret.json` from the Google console.

```
clojure -M:dev:test
```

## Building

The api namespaces can be generated by running `happy.gapi.lion/-main`

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
