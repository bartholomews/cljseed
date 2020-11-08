[![NPM](https://nodei.co/npm/generator-cljseed.png)](https://npmjs.org/package/generator-cljseed)   
[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](https://github.com/bartholomews/generator-cljseed/blob/master/LICENSE)

# generator-cljseed

**This project is not maintained, you are better off using a lein template, see** https://clj-templates.com

---------------------------

A Yeoman starter seed for Clojure + ClojureScript stack
- [figwheel-main](https://figwheel.org/) 
- [reagent](https://github.com/reagent-project/reagent)
- [ring](https://github.com/ring-clojure/ring) 
- [compojure](https://github.com/weavejester/compojure)
- [heroku](https://github.com/heroku/lein-heroku)

#### Prerequisites:

+ [Yeoman](https://yeoman.io/):  
`npm i -g yo`

+ [Leiningen](https://leiningen.org/):  
e.g. `brew install leiningen` on OS X,
look up the [wiki](https://github.com/technomancy/leiningen/wiki/Packaging) for other options

+ [Heroku CLI](https://devcenter.heroku.com/articles/heroku-cli):  
e.g. `brew install heroku/brew/heroku`

Not strictly required, but you can also use:
+ [Clojure CLI](https://clojure.org/guides/getting_started#_clojure_installer_and_cli_tools)

#### Install:
```
npm i -g generator-cljseed
```

#### Run:
```
yo cljseed
```

Inside your newly generated project, you can run commands such as:
+ **lein fig:dev** (to start a ClojureScript REPL with live reload)
+ **lein fig:test** (to run tests)
+ **lein package**  (to build a jar)
+ **heroku create your-project-name && lein heroku deploy** 
  - before deploying to heroku, you can override the default region with **heroku create --region eu my-project**  
  - if you get "*Name [your-project-name] is already taken*", make sure to replace your Heroku
project name also in **project.clj** under **:heroku {:app-name** field, otherwise the deployment will fail.
