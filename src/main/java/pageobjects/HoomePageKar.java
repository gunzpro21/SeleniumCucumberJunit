package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import managers.FileReaderManager;
import utilities.Utils;

public class HoomePageKar {
	WebDriver driver;

	public HoomePageKar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,
				FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()), this);
	}

	@FindBy(css = "li[routerlink=\"/student-management/student\"]")
	private WebElement lblStudent;

	public HoomePageKar clickLblStudent() {
		Utils.clickElementToBeClickable(driver, lblStudent,
				FileReaderManager.getInstance().getConfigReader().getExplicitlyWait());
		return this;
	}

}
