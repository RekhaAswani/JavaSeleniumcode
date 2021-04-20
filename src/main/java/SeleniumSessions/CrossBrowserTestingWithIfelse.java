package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CrossBrowserTestingWithIfelse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		WebDriver driver =null;
		
		String browser="chrome";
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Iguru\\I guru\\ChromeDriver\\chromedriver.exe");
		     
			 driver = new ChromeDriver();
		}
		else if (browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Iguru\\I guru\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else if (browser.equals("safari"))
		{
			
			driver=new SafariDriver();
		}
		
		else
		{
			System.out.println("please pass correct browser");
		}
		
		String AppURL="https://www.google.com";   
	     driver.get(AppURL);
	     String title= driver.getTitle();
	     System.out.println("page title is" +title);
	     
	     if(title.equals("Google"))
	     {
	    	 System.out.println("Title is correct");
	     }
	     else
	     {
	    	 System.out.println("Title is in-correct");
	     }
	         String url =driver.getCurrentUrl();
	         System.out.println(url);
	    driver.quit();
	     
	     // in case of close
	     /*driver.close();  // in case of close  invalid session id 
	     String title1= driver.getTitle();  //in case of quit Session ID is null Using WebDriver after calling quit()? 
	     System.out.println(title1);*/
	}
	


}
