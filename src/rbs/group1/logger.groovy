@Grab('log4j:log4j:1.2.17')

import org.apache.log4j.*
import groovy.util.logging.*

@Log4j
class logger{
    def execute() {
        // Need to set log level as described here: 
        // http://groovy.329449.n5.nabble.com/log4j-annotation-not-working-td4368806.html
        log.level = Level.DEBUG
        // add an appender to log to file
        //log.addAppender(new FileAppender(new TTCCLayout(), 'myscript.log'));

        // this will NOT print/write as the loglevel is info
        log.debug 'Execute HelloWorld.'
        // this will print
        log.info 'Simple sample to show log field is injected.'
    }
}

