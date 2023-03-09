package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import enums.E_URL_Environment;
import managers.FileReaderManager;


/**
* <h1>homepage!</h1>
* The HomePage place all locator and function for homepage.

* @author  Phan
* @since   2018 Oct 29th
*/

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeOut), this);
	}
	
	public void navigateTo_HomePage() {
		E_URL_Environment E_URL = FileReaderManager.getInstance().getConfigReader().getTypeofURL();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(E_URL));
	}
}
