package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPracticeSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromiumdriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.name("search_query")).sendKeys("dress");
		Thread.sleep(2000);

		// List<WebElement> suggList =
		// driver.findElements(By.xpath("//div[@class='ac_results']//ul//li"));

		By Sugg = By.xpath("//div[@class='ac_results']//ul//li");

		// for (WebElement e : suggList) {
		// String text = e.getText();
		// System.out.println(text);
		// if (text.equals("T-shirts > Faded Short Sleeve T-shirts")) {
		// e.click();
		// break;
		// }
		// }

		selectDress(Sugg, "T-shirts > Faded Short Sleeve T-shirts");
	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public static void selectDress(By locator, String value) {
		List<WebElement> suggList = getElements(locator);

		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}

}
