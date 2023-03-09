package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * <h1>DegreeFinderResultPage!</h1> The DegreeFinderResultPage place all locator
 * and function for Degree Finder Result Page bar navigation menu and footer.
 * that display almost all pages.
 * 
 * @author Phan
 * @since 2023 Feb 20th
 */
public class DegreeFinderResultPage extends BasePage {
	public DegreeFinderResultPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, pageTimeOut), this);
	}

	@FindBy(css = "div[id='data-filter-content']> div >div> .dgf-item-filter-label")
	private WebElement firstResultFilter;

	@FindBy(css = "div[id='dgf-list-section-id']>app-list-result .degree-name.hide-for-small-only")
	private List<WebElement> lstDegreesOnGrid;

	@FindBy(css = "div[id='dgf-list-section-id']>app-list-result p[class='university']")
	private List<WebElement> lstUniversitiesOnGrid;

	@FindBy(css = "div[id='dgf-list-section-id']>app-list-result p[class='location']")
	private List<WebElement> lstCountriesOnGrid;

	@FindBy(css = ".dgf-search >input")
	private WebElement txtSearch;

	public void sendKeystxtSearch(CharSequence... keysToSend) {
		sendKeysVisibilityElement(driver, txtSearch, keysToSend);
	}

	public String getTextlstDegreesOnGrid(int position) {
		return getTextVisibleElement(driver, lstDegreesOnGrid.get(position));
	}

	public String getTextlstUniversitiesOnGrid(int position) {
		return getTextVisibleElement(driver, lstUniversitiesOnGrid.get(position));
	}

	public String getTextlstCountriesOnGrid(int position) {
		return getTextVisibleElement(driver, lstCountriesOnGrid.get(position));
	}

	public String getTextfirstResultFilter() {
		return getTextVisibleElement(driver, firstResultFilter);
	}

}
