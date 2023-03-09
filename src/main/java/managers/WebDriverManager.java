package managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import enums.E_Browser;
import enums.E_EnvironmentType;
/**
* <h1>some called it as WebDriver Factory or Browser Factory!</h1>
* The WebDriverManager needs a driver to execute the script. Also i use WebDriverManager, we can automatically download the driver’s binary files (.exe files) for Web Automation. 

* @author  Phan
* @since   2018 Oct 30th
*/
public class WebDriverManager {
	private WebDriver driver;
	private static E_Browser driverType;
	private static E_EnvironmentType environmentType;
	//private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
 
	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}
 
	public WebDriver getDriver() {
		if(driver == null) 
			driver = createDriver();
		driver.manage().window().maximize();
		return driver;
	}
	
	private WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case BROWSERSTACK : driver = createRemoteDriver();
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
        case FIREFOX : 
        	//io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
        	 driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	//io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        	driver = new ChromeDriver();
    		break;
        case IE :
        	//io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
             driver = new InternetExplorerDriver();
    		break;
        }
 
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	
 
	public void closeDriver() {
		driver.quit();
	}
}
