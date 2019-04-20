/* All levels */
@groovy.transform.Field
ALL=0

/* Designates debug messages  */
@groovy.transform.Field
DEBUG=1

/* Designates informational messages */
@groovy.transform.Field
INFO=2

/* Designates potentially harmful situations */
@groovy.transform.Field
WARN=3

/* Designates error events which stops the execution */
@groovy.transform.Field
ERROR=4

/* The highest possible level intended to turn off logging */
@groovy.transform.Field
OFF=5

def getLevelName(level){
    name = ""
    if(level == DEBUG) {
        name = "DEBUG"
    } 
    else if (level == INFO) {
        name = "INFO"
    }
    else if (level == WARN) {
        name = "WARN"
    }
    else if (level == ERROR) {
        name = "ERROR"
    }
    return name 
}