package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptCrmPro {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		WebElement ForgotPWD = driver.findElement(By.xpath("//a[text()='Forgot Password?']"));

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		jsUtil.scrollIntoView(ForgotPWD);
		Thread.sleep(1000);
		jsUtil.clickElementByJS(ForgotPWD);

	}

}
