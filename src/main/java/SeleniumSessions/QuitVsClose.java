package SeleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class QuitVsClose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Iguru\\I guru\\ChromeDriver\\chromedriver.exe");
	     
		 WebDriver driver = new ChromeDriver();
		 System.out.println("========browser started================");
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
	    // driver.quit();
	     
	     // in case of close
	     driver.close();  // in case of close  invalid session id 
	     String title1= driver.getTitle();  //in case of quit Session ID is null Using WebDriver after calling quit()? 
	     System.out.println(title1);

	}


}
