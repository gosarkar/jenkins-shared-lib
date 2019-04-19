INFO=1
WARN=2
ERROR=3
ln = System.getProperty('line.separator')
def file = new File("C:/temp/log.txt")

logMessage(message){
  echo "Log message: $message"
  file << "$message$ln"
}
