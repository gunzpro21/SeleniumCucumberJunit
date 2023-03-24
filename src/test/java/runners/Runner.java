package runners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * <h1>run a testcase!</h1> The NavigatingLandingPageByWeb_Runner run a feature.
 * 
 * @author Truong Phan
 * @since 2023 Mar 07th
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/First_landing_page/DegreeFinder.feature", // the path of the
																									// feature files
		glue = { "stepdefinitions" }, // the path of the step definition files
		plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:" }, // to generate different types of
																					// reporting
		monochrome = true, // display the console output in a proper readable format
		strict = true, // it will check if any step is not defined in step definition file
		dryRun = false // to check the mapping is proper between feature file and step definition file
// tags = {"~@SmokeTest" }
)
public class Runner {
	private static final Logger logger = LogManager.getLogger(NewTest.class);

	@BeforeClass
	public static void setReportLocation() {
		String pattern = "dMMMyyyy_HH-mm-ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String time = simpleDateFormat.format(new Date());
		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		extentProperties.setReportPath("target/ExtentReport/GUIChecking_" + time + ".html");
		logger.info("*********************************************************************************************");
		logger.info("$$$$$$$$$$$$$$$$$$$$$           The Test Stated       		  $$$$$$$$$$$$$$$$$$$$$$$$$");
	}

	@AfterClass
	public static void setup() {
		Reporter.loadXMLConfig(new File("src/test/resources/com/extent-config.xml"));
		Reporter.setSystemInfo("User Name", "Joe Phan");
		Reporter.setSystemInfo("Application Name", "Kapplan GUI Checking");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
		logger.info("$$$$$$$$$$$$$$$$$$$$$           The Test Ended       		  $$$$$$$$$$$$$$$$$$$$$$$$$");
		logger.info("*********************************************************************************************");
	}
}
