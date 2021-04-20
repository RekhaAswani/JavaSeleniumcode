package SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerConcept {

	public static void main(String[] args) {
		// https://github.com/bonigarcia/webdrivermanager

		//WebDriverManager.chromedriver().setup(); for chrome
		WebDriverManager.firefoxdriver().setup();   // for chrome
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.close();
		
	}

}
