package runners;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * <h1>run a testcase!</h1> The NavigatingLandingPageByWeb_Runner run a feature.
 * 
 * @author Truong Phan
 * @since 2021 Apr 25th
 */



@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Karros/Students.feature", // the	path of the feature files
	glue = {"stepdefinitions"},// the path of the step definition files
	plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/ExtentReport/ExtentReport.html"},// to generate different types of reporting
		monochrome = true, // display the console output in a proper readable format
		strict = true, // it will check if any step is not defined in step definition file
		dryRun = false // to check the mapping is proper between feature file and step def file
// tags = {"~@SmokeTest" }
)

public class Runner {
	@AfterClass
	public static void setup() {
		Reporter.loadXMLConfig(new File("src/test/resources/com/extent-config.xml"));
		// Reporter.setSystemInfo("Test User", System.getProperty("user.name"));
		Reporter.setSystemInfo("User Name", "Joe Phan");
		Reporter.setSystemInfo("Application Name", "GUI Checking");
		Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
		Reporter.setSystemInfo("Environment", "Production");
		Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	}
}
