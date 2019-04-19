@groovy.transform.Field
INFO=1

@groovy.transform.Field
WARN=2

ERROR=3

@groovy.transform.Field
ln = System.getProperty('line.separator')

@groovy.transform.Field
file = new File("C:/temp/log.txt")

def logMessage(message){
  echo "Log message: $message"
  file << "$message$ln"
}
