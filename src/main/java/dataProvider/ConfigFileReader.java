package dataProvider;


import enums.E_Browser;
import enums.E_EnvironmentType;
import enums.E_URL_Environment;
/**
* The ConfigFileReader read all specific data from properties file which use for other class. 

* @author  Phan
* @since   2018 Oct 29th
*/

public class ConfigFileReader {
	PropertyReader prTestData;
	PropertyReader prurl;
	PropertyReader prWaitTime;
	
	public ConfigFileReader(){
		prTestData =  new PropertyReader("src/main/resources/properties/testdata.properties");
		prurl =  new PropertyReader("src/main/resources/properties/url.properties");
		prWaitTime =  new PropertyReader("src/main/resources/properties/waitTime.properties");
	}
	
	public String getApplicationUrl(E_URL_Environment My_eURL) {
		String url;
		switch (My_eURL) {
		case DEV:
			url = prurl.readProperty("dev.environment.url");
			break;
		case TEST:
			url = prurl.readProperty("test.environment.url");
			break;
		case STAGE:
			url = prurl.readProperty("stage.environment.url");
			break;
		case PRODUCTION:
			url = prurl.readProperty("production.environment.url");
			break;
		case PRODUCTION2:
			url = prurl.readProperty("production.environment.secondary.url");
			break;
		default:
			url = prurl.readProperty("stage.environment.url");
			break;
		}
		if(url != null) 
			return url;
		else throw new RuntimeException("url not specified in the properties file.");
	}
	public E_URL_Environment getTypeofURL() {
		String typeofURL =  prTestData.readProperty("typeofURL");
		if(typeofURL != null) 
			return  E_URL_Environment.valueOf(typeofURL);
		else 
			throw new RuntimeException("E_URL_Environment not specified in the properties file.");		
	}
	public int getImplicitlyWait() {		
		String implicitlyWait =  prWaitTime.readProperty("implicitlyWait");
		if(implicitlyWait != null) 
			return  Integer.parseInt(implicitlyWait);
		else 
			throw new RuntimeException("implicitlyWait not specified in the properties file.");		
	}
	
	public int getExplicitlyWait() {		
		String explicitlyWait =  prWaitTime.readProperty("explicitlyWait");
		if(explicitlyWait != null) 
			return  Integer.parseInt(explicitlyWait);
		else 
			throw new RuntimeException("explicitlyWait not specified in the properties file.");		
	}
	
	public int getFluentWait() {		
		String fluentWait =  prWaitTime.readProperty("fluentWait");
		if(fluentWait != null) 
			return  Integer.parseInt(fluentWait);
		else 
			throw new RuntimeException("fluentWait not specified in the properties file.");		
	}
	
	public int getPollingTimeForFluentWait() {		
		String pollingTime =  prWaitTime.readProperty("pollingTime");
		if(pollingTime != null) 
			return  Integer.parseInt(pollingTime);
		else 
			throw new RuntimeException("pollingTime not specified in the properties file.");		
	}
	
	public String getUsername() {		
		String userName =  prTestData.readProperty("production.admin.username");
		if(userName != null) 
			return  userName;
		else 
			throw new RuntimeException("Username not specified in the properties file.");		
	}
	public String getPassword() {		
		String password =  prTestData.readProperty("production.admin.password");
		if(password != null) 
			return  password;
		else 
			throw new RuntimeException("Password not specified in the properties file.");		
	}
	public String getBrowserstackUsername() {		
		String browserstackUsername =  prTestData.readProperty("browserstackUsername");
		if(browserstackUsername != null) 
			return  browserstackUsername;
		else 
			throw new RuntimeException("browserstackUsername not specified in the properties file.");		
	}
	public String getBrowserstackAccesskey() {		
		String browserstackAccesskey =  prTestData.readProperty("browserstackAccesskey");
		if(browserstackAccesskey != null) 
			return  browserstackAccesskey;
		else 
			throw new RuntimeException("browserstackAccesskey not specified in the properties file.");		
	}
	
	public String getLocalTesting() {		
		String localTesting =  prTestData.readProperty("localTesting");
		if(localTesting != null) 
			return  localTesting;
		else 
			throw new RuntimeException("localTesting not specified in the properties file.");		
	}
	
	public String getOS() {		
		String os =  prTestData.readProperty("os");
		if(os != null) 
			return  os;
		else 
			throw new RuntimeException("os not specified in the properties file.");		
	}
	
	public String getOs_version() {		
		String os_version =  prTestData.readProperty("os_version");
		if(os_version != null) 
			return  os_version;
		else 
			throw new RuntimeException("os_version not specified in the properties file.");		
	}
	
	public String get_browser_BS() {		
		String browser_BS =  prTestData.readProperty("browser_BS");
		if(browser_BS != null) 
			return  browser_BS;
		else 
			throw new RuntimeException("browser_BS not specified in the properties file.");		
	}
	
	public String get_browser_version() {		
		String browser_version =  prTestData.readProperty("browser_version");
		if(browser_version != null) 
			return  browser_version;
		else 
			throw new RuntimeException("browser_version not specified in the properties file.");		
	}
	
	public String get_browserstack_selenium_version() {		
		String selenium_version =  prTestData.readProperty("browserstack.selenium_version");
		if(selenium_version != null) 
			return  selenium_version;
		else 
			throw new RuntimeException("selenium_version not specified in the properties file.");		
	}
	
	public E_Browser getBrowser() {
		String browserName = prTestData.readProperty("browser");
		
		if(browserName == null || browserName.equals("chrome"))
			return E_Browser.CHROME;
		else if(browserName.equalsIgnoreCase("firefox")) 
			return E_Browser.FIREFOX;
		else if(browserName.equals("iexplorer")) 
				return E_Browser.IE;
			 else 
				throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}
	
	public E_EnvironmentType getEnvironment() {
		String environmentName =  prTestData.readProperty("environment");
		if(environmentName == null || environmentName.equalsIgnoreCase("local")) 
			return E_EnvironmentType.LOCAL;
		else 
			if(environmentName.equalsIgnoreCase("browserstack"))
				return E_EnvironmentType.BROWSERSTACK;
			else 
				throw new RuntimeException("Environment Type Key value in testdata.properties is not matched : " + environmentName);
	}
	
}
