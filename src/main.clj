(ns main
  (:require [clj-http.client :as client]
            [clojure.walk :as walk]
            [clojure.string :as str]

            [camel-snake-kebab.core :as csk]
            [spotty-secrets :as secret]))

;;helpers
(defn transform-keys
  "Recursively transforms all map keys in coll with t."
  [t coll]
  (let [f (fn [[k v]] [(t k) v])]
    (walk/postwalk (fn [x] (if (map? x) (into {} (map f x)) x)) coll)))

(defn kebab [s]
  (-> (name s)
      (str/replace #"(?<!^)([A-Z][a-z]|(?<=[a-z])[A-Z])" "-")
      (str/replace #"_" "-")
      (str/lower-case)
      (keyword)))

(defn ->snake-case [k]
  (str/replace (name k) #"-" "_"))


(defn snake-map [m]
  (transform-keys kebab m))




;;Authorization code flow


(def auth-params {:client-id     secret/client-id
                  :response-type "code"
                  :redirect-uri  "https://www.google.com"
                  :scope         ["user-library-read", "playlist-modify-private"]})




(defn request-auth
  "The first step is to request authorization from the user,
 Send a GET request to the /authorize endpoint using params from above. "
  [auth-params])
(defn --main [arg]
  arg)
