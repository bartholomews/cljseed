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

#### Install:
```
npm i -g generator-cljseed
```

#### Run:
```
yo cljseed
```

Inside your newly generated project, you can run commands such as:
+ **lein figwheel** (to start the client with live reload)
+ **lein ring server** (to start the server)
+ **lein cooper** (to start both client and server on the same shell)
+ **lein package**  (to build a jar)
+ **heroku create your-project-name && lein heroku deploy** 
  - before deploying to heroku, you can override the default region with **heroku create --region eu my-project**  
  - if you get "*Name [your-project-name] is already taken*", make sure to replace your Heroku
project name also in **project.clj** under **:heroku {:app-name** field, otherwise the deployment will fail.
