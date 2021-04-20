package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class NavigationConcept {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		Thread.sleep(1000);
		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		driver.navigate().to("http://www.amazon.in");
		
		System.out.println(driver.getTitle());
		driver.navigate().back();
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		System.out.println(driver.getTitle());

		//another way to refresh history.go(0)
	}

}
