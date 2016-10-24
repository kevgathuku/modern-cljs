(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"html"}

 :dependencies '[[org.clojure/clojure "1.7.0"]
                [org.clojure/clojurescript "1.7.170"]
                [adzerk/boot-cljs "1.7.170-3"]
                [pandeiro/boot-http "0.7.3"]
                [adzerk/boot-reload "0.4.13"]
                [adzerk/boot-cljs-repl "0.3.3"]
                [com.cemerick/piggieback "0.2.1" :scope "test"]
                [weasel "0.7.0" :scope "test"]
                [org.clojure/tools.nrepl "0.2.12" :scope "test"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])


(deftask deps [] ())
