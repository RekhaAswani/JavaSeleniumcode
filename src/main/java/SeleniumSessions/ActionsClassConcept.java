package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsClassConcept {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// user Actions: double click,right click, click, send keys
		// drag and drop, mouse hover
		// Actions
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://mrbool.com/how-to-create-menu-with-submenu-using-css-html/26146");
		// Actions act = new Actions(driver);
		// WebElement content = driver.findElement(By.xpath("//a[@class='menulink']"));
		// act.moveToElement(content).perform();
		doActionMoveToElement(By.className("menulink"));

		Thread.sleep(3000);
		// driver.findElement(By.linkText("COURSES")).click();

		doActionMoveToElementAndClick(By.linkText("COURSES"));
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
