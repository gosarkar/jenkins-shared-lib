package rbs.group1;

def sayHello(name) {
  checkout changelog: false, poll: false, scm: [$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/gosarkar/pipelinescript.git']]]
  println 'Hello '+name
  
}

def sonarAnalysis(sonarScannerHome){
    echo 'Sonar analysis ..'
    echo "build no = ${BUILD_NUMBER}"  
  echo "sonarscanner home = ${sonarScannerHome}"
  //bat sonarScannerHome+'/bin/sonar-scanner -Dsonar.projectname=ELibrary-pipeline -Dsonar.projectKey=ELibrary-pipeline -Dsonar.projectVersion=${BUILD_NUMBER} -Dsonar.sources=src -Dsonar.language=java -Dsonar.java.binaries=target'
}
