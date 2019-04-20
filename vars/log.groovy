@groovy.transform.Field
ln = System.getProperty('line.separator')
level = logLevel.ALL
generalLogFile = new File("c:/temp/log.txt")
errorLogFile = new File("c:/temp/error.txt")

def setLevel(level){
    echo "received level = $level"
    this.level = level 
}

def canBeLogged(level){
    echo "received level = $level"
    echo "level set = $this.level"
    this.level <= level ? true : false 
}

def logMessage(message, level){
    if(!canBeLogged(level)){
        echo "Cannot be logged"
        return
    } 
    formattedMessage = getFormattedMessage(formattedMessage, level)
    echo "$formattedMessage"
    generalLogFile << "$message$ln"
}

def debug(message){
    logMessage(message, logLevel.DEBUG)
}

def info(message){
    logMessage(message, logLevel.INFO) 
}

def warn(message){
    logMessage(message, logLevel.WARN) 
}

def error(message){
    logMessage(message, logLevel.ERROR) 
}

def getFormattedMessage(message, level){
    return "${new Date()} - $JOB_NAME - $BUILD_NUMBER $ln${logLevel.getLevelName(level)}: $message$ln" 
}