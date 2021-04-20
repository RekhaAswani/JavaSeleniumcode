package SeleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptConcept {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);

		JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
		//jsUtil.generateAlert("this is my JS");   // it will generate alert

	}

}
