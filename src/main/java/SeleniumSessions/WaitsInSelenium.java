package SeleniumSessions;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitsInSelenium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// static wait --> Thread.sleep-10
		// dynamic wait--> timeout is dynamic
		// a. implicit wait
		// b. Explicit wait
		// b.1 WebDriverwait
		// b.2 FluentWait
		// WebDriverWait extends Fluent wait
		// implementing Wait Interface

		// implicitly wait
		// is global wait // only for web elements // not applicable for non web element
		// FE/FEs by default imp wait will be applied
		// it will be applied after driver initialization
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://classic.crmpro.com/index.html");
		// login Page
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		// Home page 5
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		// nullify
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

		// login page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// We should not use implicitly wait
		
	}

}
