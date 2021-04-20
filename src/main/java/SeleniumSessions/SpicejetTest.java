package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpicejetTest {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.spicejet.com/");

		doActionMoveToElement(By.id("ctl00_HyperLinkLogin"));
		Thread.sleep(2000);
		doActionMoveToElement(By.linkText("SpiceClub Members"));
		Thread.sleep(2000);
		doActionMoveToElementAndClick(By.linkText("Member Login"));

	}

	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}

	public static void doActionMoveToElement(By locator) {
		Actions act = new Actions(driver);
		act.moveToElement(getElement(locator)).perform();
	}

	public static void doActionMoveToElementAndClick(By locator) {
		doActionMoveToElement(locator);
		getElement(locator).click();
	}

}
