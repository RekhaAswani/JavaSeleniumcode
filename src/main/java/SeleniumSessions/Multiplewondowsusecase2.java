package SeleniumSessions;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multiplewondowsusecase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/"); // parent
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click(); 
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId= it.next();
		System.out.println("parent window id: " +parentWindowId);
		String childWindowId= it.next();
		System.out.println("child window id: " +childWindowId);
		driver.switchTo().window(childWindowId);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId);
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click(); 
		
		Set<String> handles1=driver.getWindowHandles();
		Iterator<String> it1 = handles1.iterator();
		String parentWindowId1= it1.next();
		System.out.println("parent window id: " +parentWindowId1);
		String childWindowId1= it1.next();
		System.out.println("child window id: " +childWindowId1);
		driver.switchTo().window(childWindowId1);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId1);
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		Set<String> handles2=driver.getWindowHandles();
		Iterator<String> it2 = handles2.iterator();
		String parentWindowId2= it2.next();
		System.out.println("parent window id: " +parentWindowId2);
		String childWindowId2= it2.next();
		System.out.println("child window id: " +childWindowId2);
		driver.switchTo().window(childWindowId2);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId2);
		
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
		Set<String> handles3=driver.getWindowHandles();
		Iterator<String> it3 = handles3.iterator();
		String parentWindowId3= it3.next();
		System.out.println("parent window id: " +parentWindowId2);
		String childWindowId3= it3.next();
		System.out.println("child window id: " +childWindowId3);
		driver.switchTo().window(childWindowId3);
		System.out.println("child wondow url:" +driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(parentWindowId3);
		driver.close();
	}

}
