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
def configurator = { format, filter, line -> 
  println 'inside configurator'
  filter(line) ? format(line) :  null
}
def appender = {config, append, line -> 
    println 'inside appender'
  record = config(line)
  if (record) append(record)
}

def config = configurator.curry(dateFormatter, genericFilter)
def log = appender.curry(config, consoleAppender)


def logMessage(message){
  echo "Log message: $message"
  log('==>>>> logging....')
  file << "$message$ln"
}

