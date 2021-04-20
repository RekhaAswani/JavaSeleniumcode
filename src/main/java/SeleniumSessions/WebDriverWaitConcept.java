package SeleniumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// WenDriverWait -- class in selenium
		// Extends Fluent Wait class
		// until method is implemented on Fluentwait class
		// it can be applied for any webelement and non WEs (alert,url,title)

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");
		// imp wait will be applied only when you write driver.findelement
		By username = By.name("username");
		By password = By.name("password");
		By LoginButton = By.xpath("//input[@value='Login']");
		By logout = By.xpath("//a[contains(text(),'Logout ')]");

		waitForElementPresent(username, 10).sendKeys("groupautomation");

		driver.findElement(password).sendKeys("Test@12345");
		driver.findElement(LoginButton).click();

		driver.switchTo().frame("mainpanel");

		waitForElementPresent(logout, 5).click();

	}

	/**
	 * An expectation for checking that an element is present on the DOM of a page.
	 * This does not necessarily mean that the element is visible
	 */
	public static WebElement waitForElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}

	/**
	 * An Expectation for checking that an element is present on the DOM of page and
	 * visible. visibility means that the element is not displayed but also has a
	 * height and width that is greater than zero
	 * 
	 *
	 */
	public static WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

}
