package pageobjects;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class BasePage {
	protected WebDriver driver;
	Duration timeOutElement = Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getExplicitlyWait());
	int pageTimeOut = FileReaderManager.getInstance().getConfigReader().getImplicitlyWait();
	private static final Logger logger = LogManager.getLogger(BasePage.class);

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * Waits for theElement To Be visibility
	 * 
	 * @param driver
	 * 
	 * @param driver           Current Selenium webdriver
	 * @param WebElement       element to wait
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public WebElement WaitsElementToBeVisible(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		return webElement;
	}

	/**
	 * Waits for theElement To Be invisibility
	 * 
	 * @param driver           Current Selenium webdriver
	 * @param WebElement       element to wait
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public Boolean WaitsElementToBeInvisibility(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean condition = wait.until(ExpectedConditions.invisibilityOf(element));
		return condition;
	}

	/**
	 * Waits for text To Be invisibility
	 * 
	 * @param driver           Current Selenium webdriver
	 * @param WebElement       element to wait
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public Boolean waitTextToBePresentInElement(WebDriver driver, WebElement element, Duration timeOutInSeconds,
			String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean result = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		return result;
	}

	/**
	 * Waits for theElement To Be Clickable
	 * 
	 * @param driver           Current Selenium webdriver
	 * @param WebElement       element to wait
	 * @param timeOutInSeconds Time to wait for element to be Clickable
	 */
	public WebElement WaitsElementToBeClickable(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement WaitedElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		return WaitedElement;
	}

	/**
	 * click theElement To Be Clickable
	 * 
	 * @param driver           Current Selenium webdriver
	 * @param WebElement       element to wait
	 * @param timeOutInSeconds Time to wait for element to be Clickable
	 */
	protected void clickClickableElement(WebDriver driver, WebElement element) {
		try {
			WebElement ele = WaitsElementToBeClickable(driver, element, timeOutElement);
			ele.click();
	
		} catch (Exception e) {
			logger.error("can not click element " + element.toString() + " with message: " + e.getMessage());
		}

	}

	/**
	 * Move mouse to an element and click
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to hover
	 * @param by     element to click
	 */

	public static void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(elementToHover).click(elementToClick).build().perform();
		} catch (Exception e) {
			logger.error("can not hover element: " + elementToClick.toString()+ " and click: "
					+ elementToHover.toString() + " with message: " + e.getMessage());
		}

	}

	/**
	 * send key to an element
	 * 
	 * @param driver     current Selenium driver
	 * @param WebElement element to see
	 */
	protected void sendKeysVisibilityElement(WebDriver driver, WebElement element, CharSequence... keysToSend) {
		try {
			WaitsElementToBeVisible(driver, element, timeOutElement).sendKeys(keysToSend);
		} catch (Exception e) {
			logger.error("can not send key element-" + element.toString() + " with message: " + e.getMessage());
		}
	}

	/**
	 * getText of an element
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to see
	 */
	protected String getTextVisibleElement(WebDriver driver, WebElement element) {
		
		try {
			return WaitsElementToBeVisible(driver, element, timeOutElement).getText();
		} catch (Exception e) {
			logger.error("can not get Text element -" + element.toString() + " with message: " + e.getMessage());
		}
		return null;
	}
}
