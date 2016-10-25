(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"public"}

 :dependencies '[[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.170"]
                 [adzerk/boot-cljs "1.7.228-2"]
                 [pandeiro/boot-http "0.7.3"]
                 [adzerk/boot-reload "0.4.13"]
                 [adzerk/boot-cljs-repl "0.3.3"]
                 [com.cemerick/piggieback "0.2.1" :scope "test"]
                 [weasel "0.7.0" :scope "test"]
                 [org.clojars.magomimmo/domina "2.0.0-SNAPSHOT"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(deftask deps [] ())

;; define dev task as composition of subtasks
(deftask dev
         "Launch Immediate Feedback Development Environment"
         []
         (comp
          (serve :dir "target" :port 8080)
          (watch)
          (reload)
          (cljs-repl) ;; before cljs task
          (cljs)
          (target :dir #{"target"})))
