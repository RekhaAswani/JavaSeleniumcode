package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrmProCheckBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.linkText("CONTACTS")).click();
		


		//selecting all
		
	//	driver.findElements(By.xpath("//td[@class='datalistrow']//input[@type='checkbox' and @name='contact_id']"))
     //   .stream().forEach(ele -> ele.click());
		
		
		//selecting only chandru
		
		driver.findElements(By.xpath("//a[text()='Chandru Selvam']/parent::td/preceding-sibling::td/input[@type='checkbox']"))
	      .stream().forEach(ele -> ele.click());
		
		
		
	}

}
