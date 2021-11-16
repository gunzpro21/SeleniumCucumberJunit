package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.vimalselvam.cucumber.listener.Reporter;

import contextControls.Supervisor;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	Supervisor supervisor;

	public Hooks(Supervisor s_context) {
		supervisor = s_context;
	}
	public String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/target/evidences/TestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	@Before
	 public void beforeScenario(Scenario scenario) {
	     Reporter.assignAuthor("Author - Truong Phan");
	 }
	

	@After
	public void AfterSteps(Scenario scenario) throws IOException {
		// if (scenario.isFailed()) {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		try {
			File sourcePath = new File(getScreenshot(supervisor.getWebDriverManager().getDriver(), screenshotName));
			Reporter.addScreenCaptureFromPath(sourcePath.toString());
		} catch (Exception e) {
		}
		// }
		supervisor.getWebDriverManager().closeDriver();
	}
}
