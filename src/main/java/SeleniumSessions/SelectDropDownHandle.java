package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownHandle {
	 static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//drop down having:Select -tag name
		//Select class from selenium
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/orangehrm-30-day-trial/");
		
		By industry = By.id("Form_submitForm_Industry");
		By country = By.id("Form_submitForm_Country");
		By State = By.id("Form_submitForm_State");
		
		
		//Select sel_indus = new Select(driver.findElement(industry));
		
		//sel_indus.selectByIndex(5);    // month drop down
		//sel_indus.selectByVisibleText("Automotive");  // most of time will use this
		//sel_indus.selectByValue("health");
		
		//Select sel_country = new Select(driver.findElement(country));
		
		//sel_country.selectByVisibleText("India");
//		doSelectDropDownByIndex(country, 5);
//		doSelectDropDownByIndex(industry, 4);
	
		doSelectDropDownValueByVisibleText(country, "India");
		doSelectDropDownByValue(industry, "media");
		Thread.sleep(7000);
		doSelectDropDownValueByVisibleText(State, "Bihar");
	}
	
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	
  public static void doSelectDropDownByIndex(By locator, int index)
  {
	  Select select = new Select(getElement(locator));
	  select.selectByIndex(index);
  }
  
  public static void doSelectDropDownValueByVisibleText(By locator, String visibletext)
  {
	  Select select = new Select(getElement(locator));
	  select.selectByVisibleText(visibletext);
  }
	
  public static void doSelectDropDownByValue(By locator, String value)
  {
	  Select select = new Select(getElement(locator));
	  select.selectByValue(value);
  }
  
}
