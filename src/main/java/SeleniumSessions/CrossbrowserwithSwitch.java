package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossbrowserwithSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = null;

		String browser = "chrome";
		
		switch (browser) {
		case "chrome": 
			System.setProperty("webdriver.chrome.driver","C:\\Iguru\\I guru\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			break;
		case "firefox": 
			System.setProperty("webdriver.gecko.driver","C:\\Iguru\\I guru\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();;
			
			break;
			
		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
			break;
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

	}

}
