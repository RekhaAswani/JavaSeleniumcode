package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsSendKeysAndClickConcept {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@type='submit']");

		// WebElement emaildEle = driver.findElement(emailId);
		// WebElement pwdEle = driver.findElement(password);
		// WebElement loginEle = driver.findElement(loginButton);

		// Actions act = new Actions(driver);
		// act.sendKeys(emaildEle, "rekha.aswani1@gmail.com").perform();
		// act.sendKeys(pwdEle, "test123").perform();
		// act.click(loginEle).perform();
		doActionssendkeys(emailId, "reetuaswani@gmail.com");
		doActionssendkeys(password, "reetuaswani@2020");
		doActionsclick(loginButton);

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionssendkeys(By locator, String value) {

		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).perform();
	}

	public static void doActionsclick(By locator) {

		Actions act = new Actions(driver);
		act.click(getElement(locator)).click().perform();
	}

}
