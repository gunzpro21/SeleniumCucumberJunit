package contextControls;


import managers.PageObjectManager;
import managers.WebDriverManager;
import utilities.CommonUtility;

public class Supervisor {
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;
	public CommonUtility commonUtility;
	
	public Supervisor(){
		webDriverManager = new WebDriverManager();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		scenarioContext = new ScenarioContext();
		commonUtility= new CommonUtility();
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	}
	
	public CommonUtility getCommonUtilityt() {
		return commonUtility;
	}
}
