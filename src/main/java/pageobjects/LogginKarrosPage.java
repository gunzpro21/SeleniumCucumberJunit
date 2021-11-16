package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import enums.E_URL_Environment;
import managers.FileReaderManager;
import utilities.Utils;

public class LogginKarrosPage {
	WebDriver driver;

	public LogginKarrosPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,
				FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()), this);
	}

	@FindBy(css = "input[formcontrolname='username']")
	private WebElement txtUserName;

	@FindBy(css = "input[formcontrolname='password']")
	private WebElement txtPassword;

	public LogginKarrosPage navigateToLogginKarrosPage() {
		E_URL_Environment E_URL = FileReaderManager.getInstance().getConfigReader().getTypeofURL();
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(E_URL));
		return this;
	}
	
	public LogginKarrosPage login()
	{
		sendKeysTxtUserName(FileReaderManager.getInstance().getConfigReader().getUsername());
		sendKeysTxtPassword(FileReaderManager.getInstance().getConfigReader().getPassword());
		sendKeysTxtPassword(Keys.ENTER);
		return this;
	}
	public void sendKeysTxtUserName(CharSequence... keysToSend) {
		 Utils.sendKeysVisibilitElement(driver, txtUserName, keysToSend);
	}

	public void sendKeysTxtPassword(CharSequence... keysToSend) {
		Utils.sendKeysVisibilitElement(driver, txtPassword, keysToSend);
	}

}
