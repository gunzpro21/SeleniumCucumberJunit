package utilities;

import java.lang.reflect.Method;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class TestLog {
	public static void logLogger() {
	     BasicConfigurator.configure();
	     Logger Mylogger = LogManager.getLogger("DebugLogger");
	     //Setting up the log level of both loggers
	      Mylogger.setLevel(Level.DEBUG);
	      Mylogger.trace("This is the trace log - DEBUG");
	      Mylogger.debug("This is debug log - DEBUG");
	      Mylogger.info("This is info log - DEBUG");
	      Mylogger.warn("This is Warn log - DEBUG");
	      Mylogger.error("This is error log - DEBUG");
	      Mylogger.fatal("This is Fatal log - DEBUG");
	      Mylogger.setLevel(Level.WARN);
	      Mylogger.trace("This is the trace log - WARN");
	      Mylogger.debug("This is debug log - WARN");
	      Mylogger.info("This is info log - WARN");
	      Mylogger.warn("This is Warn log - WARN");
	      Mylogger.error("This is error log - WARN");
	      Mylogger.fatal("This is Fatal log - WARN");      
	      
	      Logger LoggerParent = LogManager.getLogger("LoggerParent");
	      Logger LoggerChild = LogManager.getLogger("LoggerParent.Child");
	      Logger Loggert = LogManager.getLogger(Method.class);
	      //Setting up the log level of both loggers
	      
	      LoggerParent.setLevel(Level.WARN);      
	      LoggerParent.trace("This is the trace log - PARENT");
	      LoggerParent.debug("This is debug log - PARENT");
	      LoggerParent.info("This is info log - PARENT");
	      LoggerParent.warn("This is Warn log - PARENT");
	      LoggerParent.error("This is error log - PARENT");
	      LoggerParent.fatal("This is Fatal log - PARENT");
	      LoggerChild.trace("This is the trace log - CHILD");
	      LoggerChild.debug("This is debug log - CHILD");
	      LoggerChild.info("This is info log - CHILD");
	      LoggerChild.warn("This is Warn log - CHILD");
	      LoggerChild.error("This is error log - CHILD");
	      LoggerChild.fatal("This is Fatal log - CHILD");      
	      Loggert.info("jdklsajdasj");
	}
	public static void logAppender() {
		BasicConfigurator.configure();
		Logger ourLogger = LogManager.getLogger("OurLogger");
		// create a FileAppender object and
		// associate the file name to which you want the logs
		// to be directed to.
		// You will also have to set a layout also, here
		// We have chosen a SimpleLayout
		FileAppender fileAppender = new FileAppender();
		fileAppender.setFile("logfileBasic.txt");
		fileAppender.setLayout(new SimpleLayout());

		// Add the appender to our Logger Object.
		// from now onwards all the logs will be directed
		// to file mentioned by FileAppender
		ourLogger.addAppender(fileAppender);
		fileAppender.activateOptions();

		// lets print some log 10 times
		int x = 0;
		while (x < 11) {
			ourLogger.debug("This is just a log that I want to print " + x);
			x++;
		}

	}

	public static void logManager() {
		Logger logger1 = LogManager.getLogger("Logger1");
		Logger logger2 = LogManager.getLogger("Logger2");
		Logger logger3 = LogManager.getLogger("Logger3");
		BasicConfigurator.configure();
		logger1.info("This is logger 1");
		logger2.info("This is logger 2");
		logger3.info("This is logger 3");

		Logger rootLogger = LogManager.getRootLogger();
		Logger rootOf1 = logger1.getRootLogger();

		if (rootOf1.equals(rootLogger)) {
			rootOf1.info("Both rootLogger and rootOf1 are same objects");
			rootOf1.info("The Name of the root logger is " + rootLogger.getName());
		} else {
			rootOf1.info("Both rootLogger and rootOf1 are different objects");
		}
	}

	public static void main(String[] args) {
		logLogger();
		//logAppender();
		//logManager();
	}
}
