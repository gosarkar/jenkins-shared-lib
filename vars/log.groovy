@groovy.transform.Field
ln = System.getProperty('line.separator')

//@groovy.transform.Field
//level = logLevel.ALL

//@groovy.transform.Field
//generalLogFile = new File("c:/temp/log.txt")

//@groovy.transform.Field
//errorLogFile = new File("c:/temp/error.txt")

//def setLevel(level){
//    echo "received level = $level"
//    this.level = level 
//}

/*
def canBeLogged(level){
    echo "received level = $level"
    echo "level set = $this.level"
    this.level <= level ? true : false 
}
*/

/*
def logMessage(message, level){
    if(!canBeLogged(level)){
        echo "Cannot be logged"
        return
    } 
    formattedMessage = getFormattedMessage(formattedMessage, level)
    echo "$formattedMessage"
    //generalLogFile << "$message$ln"
}
*/

/*
def debug(message){
    echo "debug: $message"
    //logMessage(message, logLevel.DEBUG)
}

def info(message){
    echo "info: $message"
    //logMessage(message, logLevel.INFO) 
}

def warn(message){
    echo "warn: $message"
    //logMessage(message, logLevel.WARN) 
}

def error(message){
    echo "error: $message"
    //logMessage(message, logLevel.ERROR) 
}

def getFormattedMessage(message, level){
    echo "getFormattedMessage: $message $level"
    //return "${new Date()} - $JOB_NAME - $BUILD_NUMBER $ln${logLevel.getLevelName(level)}: $message$ln" 
    return "message"
}
*/

def test(message){
    echo "testing: $message"
    echo "debug level: ${logLevel.DEBUG}"
    //echo "debug level name ${logLevel.getLevelName(logLevel.DEBUG)}"
    echo "${new Date()} - $JOB_NAME - $BUILD_NUMBER $ln${logLevel.getLevelName(level)}: $message$ln" 
}