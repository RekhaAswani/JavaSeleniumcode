package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleLangLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		
		List<WebElement>LangLink= driver.findElements(By.xpath("//div[@id='SIvCob']//a"));
		System.out.println(LangLink.size());
		
		for(WebElement e:LangLink)
		{
			String text=e.getText();
			System.out.println(text);
			if(text.equals("मराठी"))
			{
				e.click();
				break;
			}
			
		}
		
		
	}

}
