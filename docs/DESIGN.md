# HappyAPI Design

An Oauth2 library for Clojure.

## Context

Calling an API is often a study in incidental complexity

> Oh, what a tangled web we weave.
> 
> -- Sir Walter Scott

![](https://svgsilh.com/svg/311050.svg)

Making a request is easy - [`clj-http`](https://github.com/dakrone/clj-http).
But there is a lot to think about:

* Authentication and authorization
* Specification
  * What resources are available and what parameters can be passed?
  * How do I navigate the specification? (Online docs? Class hierarchy? REPL?)
* Request validation
* Response comprehension
* Paging
* Handling failures and retries
* Rate maximization keeping under a limit
* Concurrency

Despite this, web APIs are often described as easy.
Companies like to pretend it's easy and users like to imagine that it's easy.
Few people talk about the hard parts.
This situation often ends with frustration and failure.

### Google APIs

* Very wide. Everything from consumer cloud (docs, videos, email, ...) to professional cloud services (OCR, translate, databases, servers, ...)
* 285 apis. (Think of a grid of 17x17 dots)
* Lots of good stuff
* Competitive pricing
* Well defined, regular, documented
* Underused it seems
* The Java API is over specific [death by specificity](https://www.youtube.com/watch?v=aSEQfqNYNAc) but worse
* Authentication model is necessarily complex

### Amazon APIs

* Widely used by companies and startups
* Typically low level services

### Other APIs

* Often have unmaintained wrappers

## Guiding Principles

* Small, simple components that form a complete solution.
* Invite customization.

## The Hard Parts

### Auth

* Basic username/password.
  Easy for users.
  Secure, **except** that it encourages users to store a plain text file containing credentials, which is risky.
  If those credentials are stolen,
  your account is compromised until password reset.
  Not widely offered/used. Not an option for GAPI.
* API key. Easy and common, but often lacks fine-grained permissions.
  Github tokens can be limited in certain ways. For GAPI, the token is only useful for public APIs.
  It won't give you access to your data.
  Popular because it's really just basic auth, but with the ability to create multiple tokens.
  Keys should really go in the header, query parameters are secure but can appear in server logs as plain text.
  It depends on the provider whether you can do this, Google uses a query parameter for example.
* OAuth2 tokens. Enables 3rd party applications to be permitted access to user data on a per-user and per-scope basis.
  Necessary for many Google APIs. Requires you to have an "app".
  Probably confusing to users who don't want to make an "app", just want their data.
  "Apps" have a secret token which is used to get access tokens.
  End users are redirected to Google to sign in and grant access, 
  then redirected back to the "app" with the access token. Access tokens are end user specific and expire.
  Needs Google side configuration and a local http listening process.
  By the way, secrets often get saved in plain text files!
  Apps can be spoofed with secrets, so don't store them in plain text for a real app.
  By the way, tokens are often saved in plain text files!
  At least they expire, but pretty risky if you ask me.
  For GAPI you can create service accounts, which don't require interactive login (not really much different from tokens huh).

## The Solution: HappyGAPI

A library!
Generated code from the webservice description document (A big JSON file).
Oauth2 authentication.

Why do we need a new library?
Existing libraries don't exist for Google APIs, and are not flexible enough to work with multiple providers.

### Specifications at hand: Generate code

* Docstrings
* Symbol resolution
* Exploration, autocomplete
* Parameter validation

Makes consuming the API a pleasure!
I can use my IDE features like "help" and "autocomplete" to quickly make requests with confidence that I got them right.

There is value in having everything be data, and we can have both.

### Maintenance

Automatically releasing schema changes would be nice to do in the future.

### Batteries included

#### Auth

Oauth2

Credential lookup (looks for secret.json etc... is there a way to encourage encrypting credentials?)

#### Paging

#### Rate maximization

There's already a good throttling library (but does it allow rate maximization)?

#### Error Handling and Retries

There's a retry library, is it enough?

Exceptions vs Errors. I strongly encourage using Exceptions.
Doing so frees us to expect data as the return value, rather than a response that requires interpretation.

#### Response comprehension

1. Specification in documentation.
2. Throw errors.
3. Unwrap items.
4. Conjoin pages.

## Design Decisions

### Namespace Organization

Originally I chose to follow the api organization as closely as possible,
but upon reflection changed it to better collect resources:

`happygapi.youtube.videos/list$`
vs `happygapi.youtube/videos-list`
vs `happygapi.youtube/videos$list`

1. The methods often overlap core functions like `list`, `get` etc.
2. Less requires are necessary when working with an API (YouTube has multiple resources).
3. Easier to search for functionality with autocomplete

### Mutability

I originally chose to pass auth to every call, the proper functional choice.
But upon reflection I changed it such that authentication happens as a side effect.
This is more convenient, and if users don't want it they can assemble the middleware differently.

### Oauth2

HappyAPI is now primarily an Oauth2 library, the code generation is in another project (happyapi.google).

### Default Scopes

Previously there were default scopes, but now there are no default scopes.

### Typed Clojure annotations? Malli?

These seem like they would be helpful (future work).

### Should the required parameters be positional args?

Yes, that's how most other function works.
Generated code uses positional args, but everything gets routed through a `request` function that takes a big map.
So if you prefer that style, you can use that instead.

### Should record the GAPI version when publishing

Future work.

## Ideas

* Maybe API functions should create request maps? Yes that's what they do now
* API calls aren't functions. Yes, but it's convenient to pretend they are
* Actually clj-http solves many of these things, we just need some good defaults and a way to customize
* Keep generated code in separate projects to avoid spam diffs
* Control flow: Exceptions are actually good for distinguishing results and failures
* Recommend exceptions
  * Reason I avoided them in the past is info swallowing, but informative exceptions solve that
  * They are good because we want the data, not the response representation
* Pluggable dependencies sound great, but be careful.
  We'd like our dependencies to be stable, adding a dependency shouldn't change which implementation is used.

### Notes

https://github.com/drone29a/clj-oauth
https://github.com/sharetribe/aws-sig4

Question: how to control arg checking (if at all?), maybe leave that up to users?
Maybe follow Malli convention (or spec)
Idea:

```clojure
(defn strict! []
  (alter-var-root #'api-request
    (fn [_prev]
      (wrap-check-args-or-something??))))
```

We need a schema explorer experience - is this another case of summarize?

Major providers are inconsistent.
Providing config for urls is useful, users just need to add their id/secret.

## Future work

Make it ClojureScript compatible.

Requests more scopes than are really necessary :( I think you just need *any* of the scopes? not all?

Numbers should probably be coerced to numbers based on the json schema for responses.

Can we provide secure options for secret and token storage?
