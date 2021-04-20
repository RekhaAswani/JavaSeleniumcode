package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Custom_Xpath_2 {
	public static WebDriver driver;

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");

		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();

		driver.switchTo().frame("mainpanel");

		driver.findElement(By.linkText("CONTACTS")).click();

		// a[text()='Devisha
		// Sharma']/parent::td/preceding-sibling::td/input[@type='checkbox']
		selectContact("Devisha Sharma");
		selectContact("kishan patel");

		System.out.println(getCompName("Devisha Sharma"));
		System.out.println(getphonenumber("Devisha Sharma"));
		System.out.println(getmobilenumner("Devisha Sharma"));
		System.out.println(getemailid("Devisha Sharma"));
		System.out.println(getContactInfo("Devisha Sharma"));
	}

	public static void selectContact(String name) {
		String path = "//a[text()='" + name + "']/parent::td/preceding-sibling::td/input[@type='checkbox']";

		driver.findElement(By.xpath(path)).click();
	}

	public static String getCompName(String name) {
		String path = "//a[text()='" + name + "']/parent::td/following-sibling::td/a";

		return driver.findElement(By.xpath(path)).getText();
	}

	public static String getphonenumber(String name) {
		String path1 = "//a[text()='" + name + "']/parent::td/following-sibling::td/span";

		return driver.findElement(By.xpath(path1)).getText();
	}

	public static String getmobilenumner(String name) {
		String path2 = "//a[text()='" + name
				+ "']/parent::td/following-sibling::td/span/parent::td/following-sibling::td/following-sibling::td/span";

		return driver.findElement(By.xpath(path2)).getText();
	}

	public static String getemailid(String name) {
		String path3 = "//a[text()='" + name
				+ "']/parent::td/following-sibling::td/span/parent::td/following-sibling::td/following-sibling::td/span/parent::td/following-sibling::td/a";

		return driver.findElement(By.xpath(path3)).getText();
	}

	/**
	 * input name return the list of all the information right side phone, mobile
	 * number,email id
	 */

	public static List<String> getContactInfo(String name) {
		String ComapanyName = getCompName(name);
		String ph = getphonenumber(name);
		String mobile = getmobilenumner(name);
		String email = getemailid(name);

		List<String> contactInfoList = new ArrayList<String>();
		contactInfoList.add(ComapanyName);
		contactInfoList.add(ph);
		contactInfoList.add(mobile);
		contactInfoList.add(email);
		return contactInfoList;

	}
}

// a[text()='Devisha Sharma']/parent::td/following-sibling::td/span
// a[text()='Devisha Sharma']/parent::td/following-sibling::td/a

// a[text()='Devisha
// Sharma']/parent::td/following-sibling::td/span/parent::td/following-sibling::td/following-sibling::td/span

// a[text()='Devisha
// Sharma']/parent::td/following-sibling::td/span/parent::td/following-sibling::td/following-sibling::td/span/parent::td/following-sibling::td/a