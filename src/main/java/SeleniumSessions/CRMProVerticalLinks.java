package SeleniumSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CRMProVerticalLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		
		List<WebElement>listlang=driver.findElements(By.xpath("//ul[@class='list-unstyled']/li"));
		
		// can use this xpath also //ul[@class='list-unstyled']/li/a
		for(WebElement e:listlang )
		{
			System.out.println(e.getText());
			
		}

	}

}
