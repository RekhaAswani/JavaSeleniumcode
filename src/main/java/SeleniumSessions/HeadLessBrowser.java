package SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadLessBrowser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeOptions co = new ChromeOptions();
		co.addArguments("---headless");
		
		// in case of firefox driver
		//FirefoxOptions fo = new FirefoxOptions();
		//fo.addArguments("---headless");

		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.quit();

	}

}
