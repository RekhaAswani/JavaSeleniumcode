package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TotalLinks {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Total links on the page
		// get the text of each link
		// html tag= <a>
		// print only those link which are not blank
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");

		//List<WebElement> linkList = driver.findElements(By.tagName("a"));
		
        By links =By.tagName("a");
        List<WebElement>linkList=getElements(links);
		System.out.println("total link: " + linkList.size());
		List<String>LinksTextList=getElementstextList(links);
		
		for(String e:LinksTextList )
		{
			System.out.println(e);
		}

//		for (int i = 0; i < linkList.size(); i++) {
//			String LinkText = linkList.get(i).getText();
//			if (!LinkText.isEmpty()) {
//				System.out.println(i + " " + LinkText);
//			}
//		}
//
//		for (WebElement e : linkList) {
//			String hrefvalue = e.getAttribute("href");
//			System.out.println(hrefvalue);
//		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static List<String> getElementstextList(By locator)
	{
	List<String>eleTextList = new ArrayList<String>();
	{
	 List<WebElement>eleList =getElements(locator)	;
	  for(WebElement e: eleList)	
	  {
		  if(!e.getText().isEmpty())
		  {
		  eleTextList.add(e.getText()); 
		  }
	  }
	 return eleTextList;
	}
	
	}
}
