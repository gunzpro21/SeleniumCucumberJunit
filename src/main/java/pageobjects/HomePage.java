package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import enums.E_URL_Environment;
import managers.FileReaderManager;


/**
* <h1>homepage!</h1>
* The HomePage place all locator and function for homepage.

* @author  Phan
* @since   2018 Oct 29th
*/

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateTo_HomePage() {
		E_URL_Environment E_URL = FileReaderManager.getInstance().getConfigReader().getTypeofURL();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(E_URL));
	}
}
