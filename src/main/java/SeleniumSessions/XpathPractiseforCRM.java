package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathPractiseforCRM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		List<WebElement> listone =driver.findElements(By.xpath("//h3"));
		System.out.println(listone.size());
		
		for (WebElement e : listone) 
		{
			System.out.println(e.getText());
		}
		
		//input[contains(@id,'email')]
		//input[contains(@id,'input-email']
	}

}
