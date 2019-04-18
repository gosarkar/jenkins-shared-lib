package rb.group1;

@Grab('log4j:log4j:1.2.17')

import org.apache.log4j.*
import groovy.util.logging.*


    
    def execute() {
        println 'inside execute'
        Logger log = Logger.getInstance(getClass())
        def fileAppender = new FileAppender(new TTCCLayout(), 'c:/temp/myscript.log')    
        log.addAppender(fileAppender);
        // Need to set log level as described here: 
        // http://groovy.329449.n5.nabble.com/log4j-annotation-not-working-td4368806.html
        log.level = Level.DEBUG
        // add an appender to log to file
        //log.addAppender(new FileAppender(new TTCCLayout(), 'myscript.log'));

        // this will NOT print/write as the loglevel is info
        log.debug 'Execute HelloWorld.'
        // this will print
        log.info 'Simple sample to show log field is injected.'
        println log
        fileAppender = null
    }
    
    def sayHello(){
        println 'Hello'
    }


