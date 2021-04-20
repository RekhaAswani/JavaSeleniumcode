package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearch {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("testing");
		Thread.sleep(2000);

		List<WebElement> suggList = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='sbl1']//span"));

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if(text.equals("testing in software engineering"))
			{
				e.click();
				break;
			}
		}

	}

}
