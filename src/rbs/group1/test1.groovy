package rbs.group1;

import java.util.logging.Logger

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

def updateSecretText(user, password, str){
    def encodedUser = user.bytes.encodeBase64().toString()
    def encodedPassword = password.bytes.encodeBase64().toString()
    //def str = readFile fileName
    println 'encoded user = '+encodedUser
    println 'encoded password = '+encodedPassword
    
    str = str.replace('USERNAME', encodedUser)
    str = str.replace('PASSWORD', encodedPassword)
    println '==>>'+str
    return str  
}

def log(){
  Logger logger = Logger.getLogger('hello')
  println 'inside log method'
  logger.info 'info message'
  logger.warning 'warning message'
  println logger
}
