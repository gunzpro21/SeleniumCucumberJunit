package pageobjects;

import java.text.DateFormatSymbols;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import managers.FileReaderManager;
import models.Student;
import utilities.Utils;

public class StudentPage {
	WebDriver driver;
	int timeout = FileReaderManager.getInstance().getConfigReader().getExplicitlyWait();

	public StudentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, timeout), this);
	}
	
	@FindBy(id = "districtId")
	private WebElement txtStudentIDFilter;

	@FindBy(css = "mat-row > mat-cell.mat-column-districtId")
	private WebElement lblFirstStudentID;

	@FindBy(css = "div.mat-paginator-range-label")
	private WebElement lblPaginator;

	@FindBy(css = "[aria-label='Filter']")
	private WebElement btnfilter;

	@FindBy(xpath = "//span[text()='Add Student']")
	private WebElement btnAddStudent;

	@FindBy(css = "input[formcontrolname='givenName']")
	private WebElement txtFirstName;

	@FindBy(css = "input[formcontrolname='familyName']")
	private WebElement txtLastName;

	@FindBy(css = "input[formcontrolname='dateOfBirth']")
	private WebElement txtDOB;

	@FindBy(css = "input[formcontrolname='school']")
	private WebElement txtSchool;

	@FindBy(css = "input[formcontrolname='districtId']")
	private WebElement txtStudentID;

	@FindBy(xpath = "//span[text()='Add']")
	private WebElement btnAdd;

	@FindBy(css = "svg.mat-datepicker-toggle-default-icon")
	private WebElement btnOpeningDate;
	
	@FindBy(css = "button[aria-label='Choose month and year']")
	private WebElement btnChosenMonthAndYear;
	
	public void sendKeysTxtStudentID(CharSequence... keysToSend) {
		Utils.sendKeysVisibilitElement(driver, txtStudentIDFilter, keysToSend);
	}

	public StudentPage searchStudentID(String studentID) {
		sendKeysTxtStudentID(studentID);
		Utils.clickElementToBeClickable(driver, btnfilter, timeout);
		return this;
	}

	public StudentPage clickbtnAddStudent() {
		Utils.clickElementToBeClickable(driver, btnAddStudent, timeout);
		return this;
	}

	public StudentPage sendKeysSchool(CharSequence... text) {
		Utils.sendKeysVisibilitElement(driver, txtSchool, text);
		return this;
	}

	public String getMonth(int month) {
		return new DateFormatSymbols().getMonths()[month - 1];
	}
	private WebElement findFlexibleElement(String elementLocator) {
		String tempText="td[aria-label='"+ elementLocator +"']";
		return driver.findElement(By.cssSelector(tempText));
	}
	private void selectDOB() {
		Utils.clickElementToBeClickable(driver, btnOpeningDate, timeout);
		Utils.clickElementToBeClickable(driver, btnChosenMonthAndYear, timeout);
		Utils.clickElementToBeClickable(driver, findFlexibleElement("1999"), timeout);
		Utils.clickElementToBeClickable(driver, findFlexibleElement("October 1999"), timeout);
		Utils.clickElementToBeClickable(driver, findFlexibleElement("October 11, 1999"), timeout);
	}

	public StudentPage createAStudent(Student student) {

		Utils.sendKeysVisibilitElement(driver, txtFirstName, student.getFirstName());
		Utils.sendKeysVisibilitElement(driver, txtLastName, student.getLastName());
		selectDOB();
		sendKeysSchool(student.getSchool());
		sendKeysSchool(Keys.ENTER);
		Utils.sendKeysVisibilitElement(driver, txtStudentID, student.getStudentID());
		Utils.clickElementToBeClickable(driver, btnAdd, timeout);
		return this;
	}

	public String getTextFirstStudentID() {
		if (Utils.waitTextToBePresentInElement(driver, lblPaginator, timeout, "1 – 1 of 1"))
			return Utils.getTextVisibilitElement(driver, lblFirstStudentID);
		return null;
	}

}
