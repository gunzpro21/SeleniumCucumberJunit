package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

import managers.FileReaderManager;

public class Wait {
	static Duration timeout = Duration.ofSeconds(FileReaderManager.getInstance().getConfigReader().getExplicitlyWait());
	public static void untilJqueryIsDone(WebDriver driver){
		untilJqueryIsDone(driver, Duration.ofMillis(FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()));
	}
 
	public static void untilJqueryIsDone(WebDriver driver, Duration timeoutInSeconds){
		until(driver, (d) ->{
			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
			if (!isJqueryCallDone) System.out.println("JQuery call is in Progress");
			return isJqueryCallDone;
			}, timeoutInSeconds);
	}
	
	public static void untilPageLoadComplete(WebDriver driver) {
		untilPageLoadComplete(driver, Duration.ofMillis(FileReaderManager.getInstance().getConfigReader().getExplicitlyWait()));
	}
 
	public static void untilPageLoadComplete(WebDriver driver, Duration timeoutInSeconds){
		until(driver, (d) ->
			{
				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				if (!isPageLoaded) System.out.println("Document is loading");
				return isPageLoaded;
			}, timeoutInSeconds);
	}
	
	public static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
			until(driver, waitCondition, timeout);
	}
 
	
	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Duration timeoutInSeconds){
		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
		webDriverWait.withTimeout(timeoutInSeconds);
		try{
			webDriverWait.until(waitCondition);
		}catch (Exception e){
			System.out.println(e.getMessage());
		}          
	}
}
