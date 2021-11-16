package utilities;

import org.apache.log4j.Logger;

public class AbcLog {
	private static Logger logFile = Logger.getLogger(AbcLog.class.getName());
	public void name1() {
		logFile.info("wfewfw");
		logFile.debug("debug here");
		logFile.error("error here");
	}

}
