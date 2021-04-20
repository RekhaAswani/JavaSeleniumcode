package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoxlaunch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver","C:\\Iguru\\I guru\\geckodriver-v0.19.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		String title= driver.getTitle();
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
	    // driver.quit();
	     
	     // in case of close
	     driver.close();  // in case of close  invalid session id 
	     String title1= driver.getTitle();  //in case of quit Session ID is null Using WebDriver after calling quit()? 
	     System.out.println(title1);
	}

}
