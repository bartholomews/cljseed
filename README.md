[![NPM](https://nodei.co/npm/generator-cljseed.png)](https://npmjs.org/package/generator-cljseed)

# generator-cljseed

A Yeoman starter seed for Clojure + ClojureScript stack
- [ring](https://github.com/ring-clojure/ring) 
- [compojure](https://github.com/weavejester/compojure)
- [reagent](https://github.com/reagent-project/reagent)
- [figwheel](https://github.com/bhauman/lein-figwheel) 
- [heroku](https://github.com/heroku/lein-heroku)

#### Prerequisites:

+ [Yeoman](https://yeoman.io/):  
`npm i -g yo`

+ [Leiningen](https://leiningen.org/):  
e.g. `brew install leiningen` on OS X,
look up the [wiki](https://github.com/technomancy/leiningen/wiki/Packaging) for other options

+ [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli):  
e.g. `brew install heroku/brew/heroku`

Run 
```
npm i generator-cljseed
yo cljseed
```

Inside your newly generated project, you can run for example:
+ *lein figwheel* (to start the client with live reload)
+ *lein ring server* (to start the server)
+ *lein cooper* (to start both client and server in the same window)
+ *lein package*  (to build a jar)
+ *heroku create my-project && lein heroku deploy*  
(to deploy to heroku, also you override the default region you can use the *region* flag, e.g. *heroku create --region eu my-project*)
