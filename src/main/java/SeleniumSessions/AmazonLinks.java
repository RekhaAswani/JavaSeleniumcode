package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonLinks {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.in/");
		List<WebElement> amazonlink = driver
				.findElements(By.xpath("//div[@class='navFooterVerticalRow navAccessibility']//a"));
		System.out.println(amazonlink.size());
		Thread.sleep(3000);
		for (WebElement e : amazonlink) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals("Amazon Cares")) {
				e.click();
				break;
			}

		}
	}
}
