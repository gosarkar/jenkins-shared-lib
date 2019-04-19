@groovy.transform.Field
INFO=1

@groovy.transform.Field
WARN=2

ERROR=3

@groovy.transform.Field
ln = System.getProperty('line.separator')

@groovy.transform.Field
file = new File("C:/temp/log.txt")


def file = new File('c:/temp/logoutput.txt')
def dateFormatter = { line -> "${new Date()}: $line"}
def debugFilter = { line -> line.contains('debug')}
def genericFilter = { line -> true }
def consoleAppender = {line -> println line}
def fileAppender = {line -> file << "$line\n"}
def log = { format, filter, append, line -> 
  println 'inside configurator'
  record = filter(line) ? format(line) :  null
  if(record) append(line)
}


def logMessage(message){
  echo "Log message: $message"
  log(dateFormatter, genericFilter, consoleAppender, "==>>logging: $message")
  file << "$message$ln"
}

