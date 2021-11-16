package utilities;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Log4jRealCase {
	//TODO apply log 4j
	private static WebDriver driver;
	private static Logger log12 = Logger.getLogger(Log4jRealCase.class.getName());
	public static void main(String[] args) {
		DOMConfigurator.configure("D:\\eclipse-workspace\\newframework\\src\\test\\resources\\com\\log4j.xml");
		// Create a new instance of the Firefox driver
		System.setProperty("webdriver.gecko.driver", "D:\\Storage-software\\geckodriver.exe");
		driver = new FirefoxDriver();
		Constants.logFile.info("New driver instantiated");
		// Put a Implicit wait, this means that any search for elements on the page
		// could take the time the implicit wait is set for before throwing exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Constants.logFile.info("Implicit wait applied on the driver for 10 seconds");
		// Launch the Online Store Website
		driver.navigate().to("https://dont-starve-game.fandom.com/vi/wiki/Console");
		Constants.logFile.info("Web application launched");
		
		log12.info("31231231");
		Constants.logFile.trace("This is the trace log - DEBUG");
		Constants.logFile.debug("This is debug log - DEBUG");
		Constants.logFile.info("This is info log - DEBUG");
		Constants.logFile.warn("This is Warn log - DEBUG");
		Constants.logFile.error("This is error log - DEBUG");
		Constants.logFile.fatal("This is Fatal log - DEBUG");

		// Close the driver
		driver.close();
		Constants.logFile.info("Browser closed");
	}
}
