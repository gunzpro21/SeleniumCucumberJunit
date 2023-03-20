package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import contextControls.Supervisor;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import runners.NewTest;

public class Hooks {
	Supervisor supervisor;
	private static final Logger logger = LogManager.getLogger(NewTest.class);

	public Hooks(Supervisor s_context) {
		supervisor = s_context;
	}

	public String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/target/evidences/TestsScreenshots/" + screenshotName
				+ dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}

	@Before
	public void beforeScenario(Scenario scenario) {
		logger.info("$$$$$$$$$$$$$$$$$$$$$           A Scenario Stated       		  $$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info("# Start test: " + scenario.getName() );
	}
	
	@After
	public void AfterSteps(Scenario scenario) throws IOException {
		// if (scenario.isFailed()) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			File sourcePath = new File(getScreenshot(supervisor.getWebDriverManager().getDriver(), screenshotName));
			Reporter.addScreenCaptureFromPath(sourcePath.toString());
		} catch (Exception e) {
			logger.error("System can not add screenshot!!" + e.getMessage());
		}
		// }
		logger.info("# End test: " + scenario.getName());
		logger.info("$$$$$$$$$$$$$$$$$$$$$           A Scenario Ended       		  $$$$$$$$$$$$$$$$$$$$$$$$$");
		supervisor.getWebDriverManager().closeDriver();
	}
}
