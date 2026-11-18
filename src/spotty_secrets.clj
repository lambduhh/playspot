(ns spotty-secrets)

;; Credentials come from the environment, never from source.
;; export SPOTIFY_CLIENT_ID=... SPOTIFY_CLIENT_SECRET=...
(def client-secret (System/getenv "SPOTIFY_CLIENT_SECRET"))

(def client-id (System/getenv "SPOTIFY_CLIENT_ID"))
