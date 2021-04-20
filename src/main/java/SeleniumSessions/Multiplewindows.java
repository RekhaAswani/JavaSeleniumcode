package SeleniumSessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiplewindows {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); // parent
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click(); 
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId= it.next();
		System.out.println("parent window id: " +parentWindowId);
		String childWindowId1= it.next();
		System.out.println("child window id: " +childWindowId1);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.switchTo().window(parentWindowId);  
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click(); 
		Thread.sleep(5000);
		//String childWindowId2= it.next();
		//System.out.println("child window 2 id: " +childWindowId2);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.switchTo().window(parentWindowId);  
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click(); 
		//String childWindowId3= it.next();
		//System.out.println("child window 3 id: " +childWindowId3);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.switchTo().window(parentWindowId); 
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click(); 
		//String childWindowId4= it.next();
		//System.out.println("child window 4 id: " +childWindowId4);

	}

}
