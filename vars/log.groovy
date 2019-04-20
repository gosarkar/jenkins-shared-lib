import java.text.SimpleDateFormat

@groovy.transform.Field
ln = System.getProperty('line.separator')

@groovy.transform.Field
level = logLevel.ALL

@groovy.transform.Field
generalLogFile = new File("c:/temp/${JOB_BASE_NAME}_${BUILD_NUMBER}_GENERAL.log")

@groovy.transform.Field
errorLogFile = new File("c:/temp/${JOB_BASE_NAME}_${BUILD_NUMBER}_ERROR.log")

@groovy.transform.Field
dateTimeFormat = "MMMM dd, yyyy HH:mm:ss a"

@groovy.transform.Field
isFirstTime = true

def setLevel(requestedLevel){
    echo "received level = $requestedLevel"
    level = requestedLevel 
}

def canBeLogged(requestedLevel){
    echo "received level = $requestedLevel"
    echo "level set = $level"
    level <= requestedLevel ? true : false 
}

def getCurrentDateTime(){
    currentDate = new Date()
    SimpleDateFormat sdf = new SimpleDateFormat(dateTimeFormat);
    return sdf.format(currentDate)
}

def isErrorMessage(requestedLevel){
    return logLevel.ERROR == requestedLevel
}

def logMessage(message, requestedLevel){
    if(!canBeLogged(requestedLevel)){
        echo "Cannot be logged"
        return
    } 
    formattedMessage = getFormattedMessage(message, requestedLevel)
    logMessage(formattedMessage)
}

def logMessage(message, stageName, requestedLevel){
    if(!canBeLogged(requestedLevel)){
        echo "Cannot be logged"
        return
    } 
    formattedMessage = getFormattedMessage(message, stageName, requestedLevel)
    logMessage(formattedMessage)
}

def logMessage(message){
    echo "$formattedMessage"
    if(isFirstTime){
        generalLogFile.write('')
        errorLogFile.write('')
        isFirstTime = false    
    }
    generalLogFile << "$formattedMessage $ln"
    if(isErrorMessage(requestedLevel)){
        errorLogFile << "$formattedMessage $ln"
    }
}

def debug(message){
    echo "debug: $message"
    logMessage(message, logLevel.DEBUG)
}

def debug(message, stageName){
    echo "debug: $message"
    logMessage(message, stageName, logLevel.DEBUG)
}

def info(message){
    echo "info: $message"
    logMessage(message, logLevel.INFO) 
}

def info(message, stageName){
    echo "info: $message"
    logMessage(message, stageName, logLevel.INFO) 
}

def warn(message){
    echo "warn: $message"
    logMessage(message, logLevel.WARN) 
}

def warn(message, stageName){
    echo "warn: $message"
    logMessage(message, stageName, logLevel.WARN) 
}

def error(message){
    echo "error: $message"
    logMessage(message, logLevel.ERROR) 
}

def error(message, stageName){
    echo "error: $message"
    logMessage(message, stageName, logLevel.ERROR) 
}

def getFormattedMessage(message, level){
    echo "getFormattedMessage: $message $level"
    return "${getCurrentDateTime()} - $JOB_NAME - Build No - $BUILD_NUMBER $ln${logLevel.getLevelName(level)}: $message" 
}

def getFormattedMessage(message, stageName, level){
    echo "getFormattedMessage: $message $level"
    return "${getCurrentDateTime()} - $JOB_NAME - Build No - $BUILD_NUMBER - Stage $stageName $ln${logLevel.getLevelName(level)}: $message" 
}



