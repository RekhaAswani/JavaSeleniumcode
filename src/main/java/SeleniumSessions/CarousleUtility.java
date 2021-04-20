package SeleniumSessions;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarousleUtility {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.noon.com/uae-en/");

		Set<String> dataset1 = getCarousleElements("Recommended For You");
		// System.out.println(dataset1);
		dataset1.stream().forEach(e -> System.out.println(e));
	}

	// String path1 = "//a[text()='" + name +
	// "']/parent::td/following-sibling::td/span";

	public static Set<String> getCarousleElements(String suggestion) {

		String xpath = "//h3[text()='" + suggestion
				+ "']/parent::div/../following-sibling::div//div[@data-qa='product-name']";

		// String xpath = "//h3[text()='Recommended For
		// You']/parent::div/../following-sibling::div//div[@data-qa='product-name']";
		// Dresses - new arrivals

		// h3[text()='Dresses - new
		// arrivals']/parent::div/../following-sibling::div//div[@data-qa='product-name']
		List<WebElement> recommList = driver.findElements(By.xpath(xpath));

		System.out.println(recommList.size());

		String next_xpath = "//h3[text()='" + suggestion
				+ "']/parent::div/../following-sibling::div//div[contains(@class,'swiper-button-next')]";

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		Set<String> dataset = new TreeSet<String>();

		while (!driver.findElement(By.xpath(next_xpath)).getAttribute("class").contains("swiper-button-disabled")) {
			for (WebElement e : recommList) {
				String text = e.getText();
				if (!text.isEmpty()) {
					dataset.add(text);
				}

			}

			driver.findElement(By.xpath(next_xpath)).click();
		}

		// dataset.stream().forEach(e -> System.out.println(e));

		return dataset;
	}
}
