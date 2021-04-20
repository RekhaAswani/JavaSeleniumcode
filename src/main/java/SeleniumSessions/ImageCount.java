package SeleniumSessions;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImageCount {
	static WebDriver driver;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		By image= By.tagName("img");
		
		List<String>altList=getElementAttrList(image, "alt");
		List<String>srclist=getElementAttrList(image, "src");
 
        System.out.println(altList.size());	
        System.out.println(srclist.size());	
        
//		List<WebElement> imageList = driver.findElements(By.tagName("img"));
//
//		System.out.println("total images: " + imageList.size());
//
//		for(WebElement e:imageList)
//		{
//			String altvalue=e.getAttribute("alt");
//			String srcvalue=e.getAttribute("src");
//			System.out.println(altvalue);
//			System.out.println(srcvalue);
//		}
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	
	public static List<String> getElementAttrList(By locator,String attrName)
	{
		List<String>attrList = new ArrayList<String>();
		List<WebElement> eleList=getElements(locator);
		for(WebElement e: eleList)
		{
			attrList.add(e.getAttribute(attrName));
			
		}
		return attrList;
	}

}
