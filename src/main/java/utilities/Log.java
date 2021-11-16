package utilities;

import org.apache.log4j.Logger;

public class Log {
	// Initialize Log4j logs

	private static Logger logFile = Logger.getLogger(Log.class.getName());//

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String sTestCaseName) {
		logFile.info("****************************************************************************************");
		logFile.info("****************************************************************************************");
		logFile.info("$$$$$$$$$$$$$$$$$$$$$                 " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");
		logFile.info("****************************************************************************************");
		logFile.info("****************************************************************************************");
	}

	// This is to print log for the ending of the test case
	public static void endTestCase(String sTestCaseName) {
		logFile.info("XXXXXXXXXXXXXXXXXXXXXXX             " + sTestCaseName + "             XXXXXXXXXXXXXXXXXXXXXX");
		logFile.info("XXXXXXXXXXXXXXXXXXXXXXX             " + "-E---N---D-" + "             XXXXXXXXXXXXXXXXXXXXXX");
	}

	public static void info(String message) {
		logFile.info(message);
	}

	public static void warn(String message) {
		logFile.warn(message);
	}

	public static void error(String message) {
		logFile.error(message);
	}

	public static void fatal(String message) {
		logFile.fatal(message);
	}

	public static void debug(String message) {
		logFile.debug(message);
	}
}
