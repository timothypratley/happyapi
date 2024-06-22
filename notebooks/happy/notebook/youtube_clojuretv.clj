(ns happy.notebook.youtube-clojuretv
  (:require [clojure.string :as str]
            [scicloj.kindly.v4.kind :as kind]
            [happygapi.youtube :as youtube]))

;; # ClojureTV video views analysis

;; [Clojure/Conj 2024](https://2024.clojure-conj.org/) is coming soon.
;; As people prepare their talk proposals, it may be interesting to consider what talks have been popular in the past?
;; In this article we will gather view statistics from the YouTube API and try to answer some questions:

;; * What is the distribution of views?
;; * What are the most viewed talks?
;; * What are the most liked talks?
;; * Which talks have a high like per view ratio?
;; * Which talks have been most commented upon?

;; ## Dataset

;; We want to get all the videos posted on ClojureTV.
;; The way to do this is to look at the "uploads" playlist.
;; First we need to find the channel that ClojureTV videos are published on.

(defonce channels
         (youtube/channels-list "contentDetails,statistics" {:forUsername "ClojureTV"}))

(def uploads-playlist-id
  (-> channels first :contentDetails :relatedPlaylists :uploads))

(defonce playlist
         (youtube/playlistItems-list "contentDetails,id" {:playlistId uploads-playlist-id}))

;; The playlist contains videoIds which we can use to access video view/like statistics.

(def video-ids
  (mapv (comp :videoId :contentDetails) playlist))

;; Video details can be requested in batches of at most 50 due to the maximum item count per response page.

(defonce videos-raw
         (vec (mapcat (fn [batch]
                        (youtube/videos-list "snippet,contentDetails,statistics" {:id (str/join "," batch)}))
                      (partition-all 50 video-ids))))

;; Let's check how many videos we got

(count videos-raw)

;; And what the data looks like

(first videos-raw)

;; Statistics were interpreted as strings instead of numbers, so we'll need to fix that.

(def videos
  (mapv (fn [video]
          (update video :statistics update-vals parse-long))
        videos-raw))

;; ## Distribution of views

;; The first place to start getting a feel for a dataset is often plotting any relevant distributions.
;; In this case it makes sense to investigate the distribution of view counts per video.

(kind/vega-lite
  {:title "ClojureTV views per video"
   :data  {:values videos}
   :layer [{:mark     {:type "point" :tooltip true}
            :encoding {:x       {:field "statistics.viewCount" :type "ordinal" :title "video" :axis {:labels false} :sort "-y"}
                       :y       {:field "statistics.viewCount" :type "quantitative" :title "views"}
                       :tooltip {:field "snippet.title"}}}
           {:mark     {:type "rule" :color "red"}
            :encoding {:y {:field "statistics.viewCount" :type "quantitative" :aggregate "max"}}}]})

;; Just a few videos get a huge amount of views.
;; This is a fairly common Pareto style distribution.
;; We'll be able to understand it better on a log scale.

(kind/vega-lite
  {:title "ClojureTV log scale view quartiles"
   :data  {:values videos}
   :layer [{:mark     {:type "point" :tooltip true}
            :encoding {:x       {:field "statistics.viewCount" :type "ordinal" :title "video" :axis {:labels false} :sort "-y"}
                       :y       {:field "statistics.viewCount" :type "quantitative" :title "views" :scale {:type "log"}}
                       :tooltip {:field "snippet.title"}}}
           {:mark     {:type "rule" :color "red"}
            :encoding {:y {:field "statistics.viewCount" :aggregate "q1"}}}
           {:mark     {:type "rule" :color "red"}
            :encoding {:y {:field "statistics.viewCount" :aggregate "median"}}}
           {:mark     {:type "rule" :color "red"}
            :encoding {:y {:field "statistics.viewCount" :aggregate "q3"}}}]})

;; Now we can more clearly see that most ClojureTV videos get around 4.5k views, with 50% ranging from 2.5k views to 10k views.

(def view-icon
  [:svg {:xmlns "http://www.w3.org/2000/svg" :width "1.13em" :height "1em" :viewBox "0 0 576 512"}
   [:path {:fill "currentColor" :d "M288 144a110.94 110.94 0 0 0-31.24 5a55.4 55.4 0 0 1 7.24 27a56 56 0 0 1-56 56a55.4 55.4 0 0 1-27-7.24A111.71 111.71 0 1 0 288 144m284.52 97.4C518.29 135.59 410.93 64 288 64S57.68 135.64 3.48 241.41a32.35 32.35 0 0 0 0 29.19C57.71 376.41 165.07 448 288 448s230.32-71.64 284.52-177.41a32.35 32.35 0 0 0 0-29.19M288 400c-98.65 0-189.09-55-237.93-144C98.91 167 189.34 112 288 112s189.09 55 237.93 144C477.1 345 386.66 400 288 400"}]])

(def like-icon
  [:svg {:xmlns "http://www.w3.org/2000/svg" :width "1em" :height "1em" :viewBox "0 0 512 512"}
   [:path {:fill "currentColor" :d "M466.27 286.69C475.04 271.84 480 256 480 236.85c0-44.015-37.218-85.58-85.82-85.58H357.7c4.92-12.81 8.85-28.13 8.85-46.54C366.55 31.936 328.86 0 271.28 0c-61.607 0-58.093 94.933-71.76 108.6c-22.747 22.747-49.615 66.447-68.76 83.4H32c-17.673 0-32 14.327-32 32v240c0 17.673 14.327 32 32 32h64c14.893 0 27.408-10.174 30.978-23.95c44.509 1.001 75.06 39.94 177.802 39.94c7.22 0 15.22.01 22.22.01c77.117 0 111.986-39.423 112.94-95.33c13.319-18.425 20.299-43.122 17.34-66.99c9.854-18.452 13.664-40.343 8.99-62.99m-61.75 53.83c12.56 21.13 1.26 49.41-13.94 57.57c7.7 48.78-17.608 65.9-53.12 65.9h-37.82c-71.639 0-118.029-37.82-171.64-37.82V240h10.92c28.36 0 67.98-70.89 94.54-97.46c28.36-28.36 18.91-75.63 37.82-94.54c47.27 0 47.27 32.98 47.27 56.73c0 39.17-28.36 56.72-28.36 94.54h103.99c21.11 0 37.73 18.91 37.82 37.82c.09 18.9-12.82 37.81-22.27 37.81c13.489 14.555 16.371 45.236-5.21 65.62M88 432c0 13.255-10.745 24-24 24s-24-10.745-24-24s10.745-24 24-24s24 10.745 24 24"}]])

(def comment-icon
  [:svg {:xmlns "http://www.w3.org/2000/svg" :width "1em" :height "1em" :viewBox "0 0 512 512"}
   [:path {:fill "currentColor" :d "M256 32C114.6 32 0 125.1 0 240c0 47.6 19.9 91.2 52.9 126.3C38 405.7 7 439.1 6.5 439.5c-6.6 7-8.4 17.2-4.6 26S14.4 480 24 480c61.5 0 110-25.7 139.1-46.3C192 442.8 223.2 448 256 448c141.4 0 256-93.1 256-208S397.4 32 256 32m0 368c-26.7 0-53.1-4.1-78.4-12.1l-22.7-7.2l-19.5 13.8c-14.3 10.1-33.9 21.4-57.5 29c7.3-12.1 14.4-25.7 19.9-40.2l10.6-28.1l-20.6-21.8C69.7 314.1 48 282.2 48 240c0-88.2 93.3-160 208-160s208 71.8 208 160s-93.3 160-208 160"}]])

(defn video-summary [{:keys                                                            [id]
                      {:keys [viewCount likeCount commentCount]}                       :statistics
                      {:keys [title description] {{:keys [url]} :default} :thumbnails} :snippet}]
  (kind/hiccup
    [:div {:style {:display             "grid"
                   :gap                 15
                   :grid-template-areas ["'t t t t t t'
                                          'i i i d d d'
                                          's s s d d d'"]}}
     [:div {:style {:grid-area "t"}} [:strong title]]
     [:div {:style {:grid-area "i"}} [:a {:href (str "https://youtube.com/watch?v=" id) :target "_blank"}
                                      [:img {:src url}]]]
     [:div {:style {:grid-area "d"}} description]
     [:div {:style {:grid-area  "s"
                    :text-align "right"}}
      [:div viewCount " " view-icon]
      [:div likeCount " " like-icon]
      [:div commentCount " " comment-icon]]]))

(defn video-table [videos]
  (kind/hiccup
    [:table
     [:thead [:tr [:th "Rank"] [:th "Title"] [:th "Views"] [:th "Likes"] [:th "Comments"] [:th "Video"]]]
     (into [:tbody]
           (map-indexed
             (fn [idx {:keys                                                [id]
                       {:keys [viewCount likeCount commentCount]}           :statistics
                       {:keys [title] {{:keys [url]} :default} :thumbnails} :snippet}]
               [:tr
                [:td (inc idx)]
                [:td title]
                [:td viewCount]
                [:td likeCount]
                [:td commentCount]
                [:td [:a {:href (str "https://youtube.com/watch?v=" id) :target "_blank"}
                      [:img {:src url :height 50}]]]])
             videos))]))

;; ### Most viewed

(video-summary (last (sort-by (comp :viewCount :statistics) videos)))

;; The first thing that jumps out at us is that one talk received about 300k views.
;; It is the famous [Hammock Driven Development](https://www.youtube.com/watch?v=f84n5oFoZBc) talk by Rich Hickey.
;; I speculate that this talk is especially popular because it tackles broad topics of programming methodologies,
;; problem-solving, and thinking.
;; My favourite part is [when he jokes about the Agile sprint, sprint, sprint approach](https://www.youtube.com/watch?v=zPT-DuG0UjU).
;; His talk provides a refreshing contrast to the Agile formula for success.
;; If I were to try to categorize this talk I might be tempted toward the label "lifehacks",
;; but that severely undersells it.
;; This talk works so well because it shows us who Rich is.
;; We are pulled in by the beliefs, practices, and lifestyle of the person.
;; I hope we see more talks at Conj that go outside the box of Clojure.

;; ### Top 20 most viewed

(video-table (take 20 (reverse (sort-by (comp :viewCount :statistics) videos))))

;; Many of the most viewed Clojure talks were keynotes delivered by heavy hitters Rich Hickey, Brian Goetz, and Guy Steele.
;; More interesting is that one talk sticks out as very different.
;; "Every Clojure Talk Ever - Alex Engelberg and Derek Slager" comes in at #7,
;; and is the complete opposite of the serious and impressive topics surrounding it.
;; I remember listening to this talk, and it hit close to home for me, leaving me with mixed feelings.
;; It helped me to stop taking myself so seriously.
;; My humor has since improved and I now enjoy the spirit in which the talk was delivered.
;; Clearly Clojurists enjoyed the chance to laugh a little and reflect.
;; There aren't many Clojure talks that lean this heavily into comedy.
;; I hope we see a few more presenters take on the challenge to make the audience laugh.

;; ### Most liked

;; Likes are not available on all videos (for example the most viewed video has private likes).
;; The owner of the channel can see all likes (and dislikes), but we the public don't.

(count (filter (comp :likeCount :statistics) videos))

;; Only about half the talks have likes visible, so we might be missing some well liked videos.

(video-summary (last (sort-by (comp :likeCount :statistics) videos)))

;; "Every Clojure Talk Ever" comes in at #1 liked,
;; supporting the notion that people enjoy talks that go outside the box and embrace comedy.

;; ### Top 20 most liked

(video-table (take 20 (reverse (sort-by (comp :likeCount :statistics) videos))))

;; There is a lot of overlap between viewed and liked.
;; At #5 "Code goes in, Art comes out - Tyler Hobbs" is another talk that goes outside the box to show beautiful art works.

;; ### Most discussed

(video-summary (last (sort-by (comp :commentCount :statistics) videos)))

;; "Maybe Not" is a talk I had to watch 3 times to digest.
;; Type theory is the ultimate CompSci topic that people have strong thoughts on,
;; so there is more comment chatter on this talk.
;; This talk is very much "in the box"; about technology, computation theory, and the space Clojure occupies in Type theory.
;; This is a good reminder of the engaging nature of Clojure technology oriented deep dives.

;; ### Top 20 most discussed

(video-table (take 20 (reverse (sort-by (comp :commentCount :statistics) videos))))

;; The first not Rich Hickey talk on this list is "Bruce Hauman - Developing ClojureScript With Figwheel",
;; a fun and engaging talk that presents the wonderful powers of automatic code loading for interactive development.

;; ### Hidden gems

;; Talks that have a high like:view ratio may indicate they have interesting content.
;; Again, this only works for the 50% of videos that have likes visible.

(defn like-ratio [{{:keys [likeCount viewCount]} :statistics}]
  (when likeCount
    (/ likeCount viewCount)))

(video-summary (last (sort-by like-ratio videos)))

;; I hadn't seen the Clojure 1.11 chat before, and watching it through, I'm glad I discovered it.
;; It's quite different from the talks, as it is more of an informal but deep dive into implementation changes in Clojure.
;; The core team discuss several issues in all their gory technical detail.
;; Alex, if you read this, I hope that seeing the high like ratio encourages you to keep posting these updates.

(video-table (take 20 (reverse (sort-by like-ratio videos))))

;; There are many talks on this list that I remember enjoying, which makes me think this can be a helpful metric.
;; This list turned up some talks that I hadn't watched before;
;; I enjoyed watching "From Lazy Lisper to Confident Clojurist - Alexander Oloo" for the first time,
;; and appreciated his conclusions about building communities and choosing problems you care about.

;; I was overjoyed to see "How to transfer Clojure goodness to other languages" by Elango Cheran and Timothy Pratley came in at #8 by this metric.

;; ### Other ideas

;; We've used some obvious metrics to gain some insights into previous talks on ClojureTV.
;; I think there are deeper analysis that could be performed perhaps using automated feature detection.
;; It might also be cool to see how this compares to "Strange Loop" videos.
;; If you are interested in diving deeper with this dataset, or perhaps trying the same investigation for your favorite channel,
;; the good news is that you can adapt this notebook from the sourcecode.

;; ## Accessing YouTube data with HappyGAPI

;; I created HappyGAPI about 4 years ago because I wanted to update spreadsheets automatically.
;; At the time there weren't many (any?) good alternatives for using OAuth2 and consequently GAPI from Clojure.
;; It made my life easier.
;; But... I made a few design mistakes which left the implementation rigid.
;; Recently I spent some time addressing those to make a new more flexible thing called HappyAPI.

;; The main goals of HappyAPI are:

;; 1. Untangle the OAuth2 client as a library usable in other APIs (not just Google)
;; 2. Pluggable with other http clients and json encoder/decoders
;; 3. Easier to use
;;   * Better organization; one namespace per api, and required arguments as function parameters
;;   * Don't require users to call `(auth!)`
;;   * Automate multiple page result retrieval
;;   * Better docstrings

;; I'm happy to say that the new design seems to work well.
;; But these are breaking changes.
;; As a result I intend to release a newly named version of HappyGAPI that depends on HappyAPI as a library.
;; What should I call it? Perhaps `io.github.timothypratley/happyapi` and `io.github.timothypratley/happygapi2`?

;; I've put alpha jars on Clojars.
;; I'd like to get some feedback on the new design, and try to avoid future breaking changes.
;; Please let me know what you think.
;; If you have the time, a review of the code at https://github.com/timothypratley/happyapi would be very helpful!


;; ## Conclusion

;; We explored the popularity of ClojureTV YouTube videos.
;; Grabbing data from Google APIs is easier now thanks to HappyGAPI2.
