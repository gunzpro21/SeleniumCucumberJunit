package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.E_Browser;
import enums.E_EnvironmentType;

/**
 * <h1>some called it as WebDriver Factory or Browser Factory!</h1> The
 * WebDriverManager needs a driver to execute the script. Also i use
 * WebDriverManager, we can automatically download the driver’s binary files
 * (.exe files) for Web Automation.
 * 
 * @author Phan
 * @since 2018 Oct 30th
 */
public class WebDriverManager {
	private WebDriver driver;
	private static E_Browser driverType;
	private static E_EnvironmentType environmentType;
	// "webdriver.chrome.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		driver.manage().window().maximize();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case BROWSERSTACK:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		//
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
			break;
		case IE:
			driver = new InternetExplorerDriver();
			break;
		}

		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);// check 2 times or not
		return driver;
	}

	public void closeDriver() {
		driver.quit();
	}
}
