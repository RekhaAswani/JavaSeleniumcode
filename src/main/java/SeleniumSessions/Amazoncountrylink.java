package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazoncountrylink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
		List<WebElement> countrylinks=driver.findElements(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']//ul/li//a"));
		System.out.println(countrylinks.size());
		for(WebElement e:countrylinks )
		{
			String text=e.getText();
			System.out.println(text);
			if(text.equals("Singapore"));
			{
				e.click();
				break;
			}
		}
		
		
	}

}
