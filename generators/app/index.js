'use strict';
const slugify = require("underscore.string/slugify");
const underscored = require("underscore.string/underscored");

const Generator = require('yeoman-generator');

module.exports = class extends Generator {
  constructor(args, opts) {
    super(args, opts);
  }

  _setProject() {
    return {
      type: 'input',
      name: 'project-name',
      message: 'Enter your project name',
      default: 'hello-seymore'
    }
  }

  _copy(appName, from, to, opts) {
    this.fs.copy(
      this.templatePath(from),
      this.destinationPath(to), opts)
  }

  _write(from, to, opts) {
    this.fs.copyTpl(
      this.templatePath(from),
      this.destinationPath(to), opts)
  }

  srcTemplatePaths(app_name) {
    const src = `${app_name}/src`;
    const app = underscored(app_name);
    return [`${src}/clj/${app}`, `${src}/cljs/${app}`]
  }

  go() {
    this.prompt([this._setProject()]).then((answers) => {
      const app_name = answers['project-name'];
      const opts = {
        app_name: app_name,
        app_path: `${slugify(app_name)}`
      };
      const [clj, cljs] = this.srcTemplatePaths(app_name);
      this.log(answers);
      this._write('project.clj', `${app_name}/project.clj`, opts);
      this._write('assets', app_name, opts);
      this._write('src/clj', clj, opts);
      this._write('src/cljs', cljs, opts);
    });
  }
};
