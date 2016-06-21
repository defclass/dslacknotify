# dslacknotify

A Clojure library to send msg to slack by webhooks.

## Usage

dslacknotify use clj-http (or aleph) as http client, make sure add clj-http (or aleph) dependencies.
eg:
```
[clj-http "2.1.0"]
```

Add dslacknotify dependence:

[![Clojars Project](https://img.shields.io/clojars/v/dslacknotify.svg)](https://clojars.org/dslacknotify)

Examples:

```clojure
(require '[dslacknotify.core :as s]
         '[clj-http.client :as c])

(->> (s/notify {:webhook   "https://hooks.slack.com/services/xxxx"
              :text      "test dslacknotify"
              :notifiers ["someone" "another.one"]})
     
     s/wrap-request
     (apply c/post))

;; => 
;{:status 200,
; :headers {"X-Cache" "Miss from cloudfront",
;           "Server" "Apache",
;           "Via" "1.1 825012b9f282cade1a5dd52e10f7694b.cloudfront.net (CloudFront)",
;           "Content-Type" "text/html",
;           "Access-Control-Allow-Origin" "*",
;           "X-Frame-Options" "SAMEORIGIN",
;           "Strict-Transport-Security" "max-age=31536000; includeSubDomains; preload",
;           "Connection" "close",
;           "Transfer-Encoding" "chunked",
;           "Date" "Tue, 21 Jun 2016 07:11:15 GMT",
;           "Vary" "Accept-Encoding",
;           "Content-Security-Policy" "referrer no-referrer;",
;           "X-Amz-Cf-Id" "6WudRHmK2vCxSKnc94tF14KL9iIlrtrn3OJCIJ840RSieivRhL060w=="},
; :body "ok",
; :request-time 1980,
; :trace-redirects ...
; :orig-content-encoding "gzip",
; :content-type :text/html,
; :content-type-params {}}


```

## License

Copyright © 2016 Michael Wong

Distributed under the Eclipse Public License .
