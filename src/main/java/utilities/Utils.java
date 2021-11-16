package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import managers.FileReaderManager;

public class Utils {
	/*
	 * Waits for theElement To Be visibility
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public static WebElement fluentWaitWebDriver(WebDriver driver, WebElement element1, int timeOutInSeconds,
			int pollingInSeconds) {
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(pollingInSeconds, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		WebElement element2 = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver arg0) {
				return element1;
			}
		});

		return element2;
	}

	/*
	 * Waits for theElement To Be visibility
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public static WebElement explicitWaitsElementToBeVisibility(WebDriver driver, WebElement element,
			int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
		return webElement;
	}

	/*
	 * Waits for theElement To Be invisibility
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public static Boolean explicitWaitsElementToBeInvisibility(WebDriver driver, WebElement element,
			int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean condition = wait.until(ExpectedConditions.invisibilityOf(element));
		return condition;
	}

	/*
	 * Waits for text To Be invisibility
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be visibility
	 */
	public static Boolean waitTextToBePresentInElement(WebDriver driver, WebElement element,
			int timeOutInSeconds,String text) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		Boolean condition = wait.until(ExpectedConditions.textToBePresentInElement(element, text));
		return condition;
	}
	
	/*
	 * Waits for theElement To Be Clickable
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be Clickable
	 */
	public static WebElement explicitWaitsElementToBeClickable(WebDriver driver, WebElement element,
			int timeOutInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		WebElement LinkText = wait.until(ExpectedConditions.elementToBeClickable(element));
		return LinkText;
	}

	/*
	 * click theElement To Be Clickable
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be Clickable
	 */
	public static void clickElementToBeClickable(WebDriver driver, WebElement element, int timeOutInSeconds) {
		WebElement ele = explicitWaitsElementToBeClickable(driver, element, timeOutInSeconds);
		ele.click();
	}

	/**
	 * sendkey to an element
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to see
	 */
	public static void sendKeysVisibilitElement(WebDriver driver, WebElement element,
			CharSequence... keysToSend) {
		explicitWaitsElementToBeVisibility(driver, element,	FileReaderManager.getInstance().getConfigReader().getExplicitlyWait())
		.sendKeys(keysToSend);
	}
	
	/**
	 * getText of an element
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to see
	 */
	public static String getTextVisibilitElement(WebDriver driver, WebElement element) {
		return explicitWaitsElementToBeVisibility(driver, element,
				FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()).getText();
	}
	
	/*
	 * move to an element
	 * 
	 * @param driver Current Selenium webdriver
	 * 
	 * @param WebElement element to wait
	 * 
	 * @param timeOutInSeconds Time to wait for element to be Clickable
	 */
	public static void MovetoAnElement(WebDriver driver, WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

	/**
	 * Select the option from a select box, based on the Index value
	 * 
	 * @param driver Current Selenium webdriver
	 * @param by     Selector for the element
	 * @param value  Index value for the select box
	 */
	public static void selectFromDropDownByIndex(WebElement element, int value) {
		Select select = new Select(element);
		select.selectByIndex(value);
	}

	/**
	 * Returns true if alert is present/returns false if alert is not present
	 * 
	 * @param driver Current Selenium Webdriver
	 * @return Boolean Return true/false
	 */
	public boolean isAlertPresent(WebDriver driver) {

		try {
			driver.switchTo().alert();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Returns the web element if it exist
	 * 
	 * @param driver current Selenium driver
	 * @param by     element locator
	 * @return Select Returns the select element
	 */
	public static WebElement getWebElement(WebDriver driver, By by) {

		try {
			WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(by));

			return element;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * Returns the Select web element if it exists
	 * 
	 * @param driver current Selenium driver
	 * @param by     element locator
	 * @return Select Returns the select element
	 */
	public static Select getSelectElement(WebDriver driver, By by) {

		try {
			WebElement element = (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(by));

			return new Select(element);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	/**
	 * maximize a window
	 * 
	 * @param driver current Selenium driver
	 */
	public static void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * Move mouse to an element
	 * 
	 * @param driver current Selenium driver
	 * @param by     element locator
	 */
	public static void hover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * Move mouse to an element and click
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to hover
	 * @param by     element to click
	 */

	public static void hoverAndClick(WebDriver driver, WebElement elementToHover, WebElement elementToClick) {
		Actions action = new Actions(driver);
		action.moveToElement(elementToHover).click(elementToClick).build().perform();
	}

	/**
	 * Scroll view to an element
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to see
	 */
	public static void scrollByJS(WebDriver driver, WebElement elementToSee) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", elementToSee);
	}

	/**
	 * Scroll to top
	 * 
	 * @param driver current Selenium driver
	 * @param by     element to see
	 */
	public static void scrollTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void openNewTabByRobot() {
		try {
			Robot robo = new Robot();
			robo.keyPress(KeyEvent.VK_CONTROL);
			robo.keyPress(KeyEvent.VK_T);
			robo.keyRelease(KeyEvent.VK_CONTROL);
			robo.keyRelease(KeyEvent.VK_T);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
