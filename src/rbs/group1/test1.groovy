package rbs.group1;

def sayHello(name) {
  checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/gosarkar/pipelinescript.git']]]
  println 'Hello '+name
  
}
