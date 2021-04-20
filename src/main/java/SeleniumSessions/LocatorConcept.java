package SeleniumSessions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorConcept {
	
	static WebDriver driver;
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://demo.opencart.com/index.php?route=account/login");
		// create a webelement+perform the action click, sendkeys ,get,text,isDisplayed)
		// 1. id:

		//1st:
		// driver.findElement(By.id("input-email")).sendKeys("rekha.aswani@gmail.com");
		// driver.findElement(By.id("input-password")).sendKeys("reetuaswani@2020");

		//2nd
		//WebElement emailid = driver.findElement(By.id("input-email"));
		//WebElement password = driver.findElement(By.id("input-password"));
		
		//emailid.sendKeys("rekha.aswani@gmail.com");
		//password.sendKeys("reetuaswani@2020");
		
		//3rd :By locators:
		
		//By emailId = By.id("input-email");
		//By password = By.id("input-password");
		
		//driver.findElement(emailId).sendKeys("rekha.aswani@gmail.com");
		//driver.findElement(password).sendKeys("reetuaswani@2020");
		
		//4th: By locators+webelement
		
//		By emailId = By.id("input-email");
//		By password = By.id("input-password");
//		
//		WebElement email_ele = driver.findElement(emailId);
//		WebElement password_ele = driver.findElement(password);
//		
//		email_ele.sendKeys("rekha.aswani@gmail.com");
//		password_ele.sendKeys("reetuaswani@2020");
//		
		///5th generic method
//		By emailId = By.id("input-email");
//        By password = By.id("input-password");
//		getElement(emailId, "rekha.aswani");
//		getElement(password, "reetuaswani@2020");
		
		//6th
		By emailId = By.id("input-email");
        By password = By.id("input-password");
        By registerLink=By.linkText("Register");
        By FirstName = By.name("firstname");
        By LastName =By.xpath("//input[@type='text' and @id='input-lastname']");
        By Email = By.xpath("//input[@type='email']");
        By Telephone =By.name("telephone");
        By Password = By.xpath("//input[@type='password' and @id='input-password']");
        By ConfirmPassword = By.xpath("//input[@id='input-confirm']");
        By Subscriber = By.xpath("//input[@name='newsletter' and @value='1']");
        By PrivacyPolicy = By.xpath("//input[@name='agree' ]");
        By Continue =By.xpath("//input[@type='submit' ]");
        
        doSendKeys(emailId, "rekha.aswani@gmail.com");
        doSendKeys(password, "reetuaswani1@2020");
        doclick(registerLink);
        doSendKeys(FirstName, "Rekha");
        doSendKeys(LastName, "Aswani");
        doSendKeys(Email, "rekha.aswani@gmail.com");
        doSendKeys(Telephone, "9923430465");
        doSendKeys(Password, "Acc$1234");
        doSendKeys(ConfirmPassword, "Acc$1234");
        doclick(Subscriber);
        doclick(PrivacyPolicy);
        doclick(Continue);
        
        		
        By header =By.tagName("h2");
        String text=dogettext(header);
        System.out.println(text);
        
        //String text = driver.findElement(By.tagName("h2")).getText();
        // System.out.println(text);
      
        //System.out.println(driver.findElement(By.linkText("Customer")).isDisplayed());
        
        // by link text only for links
       // driver.findElement(By.linkText("Register")).click();
        // using partial link test
       //  driver.findElement(By.partialLinkText("forgotten")).click();
        // xpath //a[text()='Register']
        //7th CSSselector:is not an attibute 
        
      //  driver.findElement(By.cssSelector("#input-email")).sendKeys("test@gmail.com");
        
	}
//	public static void getElement(By locator,String value)
//	{
//		driver.findElement(locator).sendKeys(value);
//	}
   
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
	public static void doSendKeys(By locator,String value)
	{
		getElement(locator).sendKeys(value);
	}
	
	public static void doclick(By locator)
	{
		getElement(locator).click();
	}

	public static String dogettext(By locator)
	{
		return getElement(locator).getText();
	}
	
	public static boolean doIsDisplayed(By locator)
	{
		return getElement(locator).isDisplayed();
	}
	
}
