package runners;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;

import utilities.AbcLog;
import utilities.Log;

public class NewTest {
	private void name() {
		Log.info("tui la truong");
		Log.debug("tui la truong   dqwdqwdqdwq  ");
	}
  @Test
  public void f() {
	  DOMConfigurator.configure("D:\\eclipse-workspace\\newframework\\src\\main\\resources\\log4j.xml");
	  AbcLog aTest = new AbcLog();
	  aTest.name1();
	  Log.startTestCase("Selenium_Test_001");
	  name();
	  Log.error("tui la truong   debug");
	  Log.warn("tui la truong   debug");
	  Log.debug("tui la truong   debug");
	  Log.debug("tui la truong   dqwdqwdqdwq  ");
	  Log.fatal("tui la truong   fatal  ");
	  Log.endTestCase("Selenium_Test_001");
  }
}
