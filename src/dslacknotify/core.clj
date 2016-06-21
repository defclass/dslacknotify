(ns dslacknotify.core
  (:require [cheshire.core :refer [generate-string]]
            [clojure.string :as str]
            [dbox.map :as m]))


(defn wrap-request [[url body]]
  [url
   {:body (generate-string body)
    :headers {:content-type :json
              :accept :json}
    :as :auto}])

(defn wrap-notifiers [entity]
  (if-let [notifiers (:notifiers entity)]
    (let [notifier-str (str (str/join " " (mapv #(str "@" %) notifiers)) "\n")]
      (-> (update-in entity [:text] (fn [x] (str notifier-str x)))
          (dissoc :notifiers)))
    entity))

(defn notify
  "{:webhook \"url\"
   :text \"this is text\"
   :notifiers [\"name1\" \"name2\"]"
  [m]
  (m/check-keys [:webhook :text] m
                :fmt ["Notify need [:webhook :text] at least."])
  (let [{:keys [webhook]} m]
    [webhook (wrap-notifiers (dissoc m :webhook))]))





