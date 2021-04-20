package SeleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Rekha
 *
 */
public class ElementUtil {

	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	public void doclick(By locator) {
		getElement(locator).click();
	}

	public List<String> getElementstextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		{
			List<WebElement> eleList = getElements(locator);
			for (WebElement e : eleList) {
				if (!e.getText().isEmpty()) {
					eleTextList.add(e.getText());
				}
			}
			return eleTextList;
		}

	}

	/************************************
	 * drop down util
	 ************************************/

	public void doSelectDropDownByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	public void doSelectDropDownValueByVisibleText(By locator, String visibletext) {
		Select select = new Select(getElement(locator));
		select.selectByVisibleText(visibletext);
	}

	public void doSelectDropDownByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
	}

	/**
	 * 
	 * @param Select
	 *            from drop down using select class
	 * @param value
	 */

	public void doSelectDropDownValue(By locator, String value) {

		Select select = new Select(getElement(locator));
		List<WebElement> optionList = select.getOptions();
		System.out.println(optionList.size());
		for (WebElement e : optionList) {
			String text = e.getText();
			// System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}

		}
	}

	/**
	 * 
	 * @param select
	 *            dropdown without select class
	 * @param value
	 */

	public void doSelectDropdownValueWithoutSelect(By locator, String value) {
		List<WebElement> list = getElements(locator);
		for (WebElement e : list) {
			if (e.getText().equals(value)) {
				e.click();
				break;
			}
		}
	}

	public String switchToWindowAndGetTitle(String windowId) {
		driver.switchTo().window(windowId);
		String title = driver.getTitle();
		return title;
	}

	/**
	 * 
	 * @Action class utility
	 */

	public void doActionMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}

	public void doActionMoveToElementAndClick(By locator) {
		doActionMoveToElement(locator);
		getElement(locator).click();
	}

	public void doActionssendkeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public void doActionsclick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).click().perform();
	}

	// ******************************************Wait*****************************
	// Utils**************************************
	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible
	 */
	public WebElement waitForElementPresent(By locator, int timeOut) {

		WebDriverWait wait = new WebDriverWait(driver, timeOut);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public Alert waitForAlertPresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String getAlertText(int timeOut) {
		return waitForAlertPresent(timeOut).getText();
	}

	public void acceptAlert(int timeOut) {
		waitForAlertPresent(timeOut).accept();
	}

	public void dismissAlert(int timeOut) {
		waitForAlertPresent(timeOut).dismiss();

	}
	
	public String waitForTitle(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	public String waitForTitleContains(int timeOut, String title) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	public String waitForTitle(int timeOut, String title, int intervalTime) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut, intervalTime);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}

	public boolean waitForUrl(int timeOut, String url) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));
	}
	
	
	
	public WebElement waitForElementWithFluentWait(By locator, int timeout, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	public Alert waitForAlertWithFluentWait(int timeout, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoAlertPresentException.class);

		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public WebDriver waitForFrameWithFluentWait(String frameLocator, int timeout, long pollingTime) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchFrameException.class);

		return wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	
	/**
	 * streams
	 * 
	 */
	public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

	}
	
	public void printElementsText(By locator, int timeOut) {		
		waitForVisibilityOfElements(locator, timeOut)
			.stream()
				.forEach(ele -> System.out.println(ele.getText()));
	}
	
	public void printListElements(List<String> eleList) {
		eleList.forEach(ele -> System.out.println(ele));
	}
	
	public List<String> getElementsListWithText(By locator, int timeOut, String filterVal) {
		return waitForVisibilityOfElements(locator, timeOut)
			.stream()
				.filter(ele -> ele.getText().contains(filterVal))
					.map(ele -> ele.getText())
						.collect(Collectors.toList());
	}
	
	public List<WebElement> getElementsList(By locator, int timeOut, String filterVal) {
		return waitForVisibilityOfElements(locator, timeOut)
			.stream()
				.filter(ele -> ele.getText().contains(filterVal))
						.collect(Collectors.toList());
	}
	

	public WebElement waitForElementVisibleWithElement(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
	}


}
