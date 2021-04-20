package SeleniumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitConcept {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// WebDriverWait(c)---> Fluent wait(c)--Wait(I) Unit(M)

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		By username = By.name("username");

		waitForElementWithFluentWait(username, 10, 1).sendKeys("batchautomation");

	}

	public static WebElement waitForElementWithFluentWait(By locator, int timeout, int pollingTime) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

	}
}
