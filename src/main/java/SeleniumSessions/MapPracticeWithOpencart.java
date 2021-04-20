package SeleniumSessions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MapPracticeWithOpencart {
	static WebDriver driver;

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");

		getProductMap();

	}

	public static void getProductMap() {
		By email = By.id("input-email");
		By password = By.id("input-password");
		By loginButton = By.xpath("//input[@value='Login']");
		By Typeprodsearch = By.name("search");
		By Search = By.xpath("//i[@class='fa fa-search']");
		By Macbookpro = By.xpath("//img[@title='MacBook Pro']");

		By MacBookProduct = By.xpath("//h1[text()='MacBook Pro']");

		driver.findElement(email).sendKeys("rekha.aswani@gmail.com");
		driver.findElement(password).sendKeys("Acc$1234");
		driver.findElement(loginButton).click();
		driver.findElement(Typeprodsearch).sendKeys("MacBook");
		driver.findElement(Search).click();
		driver.findElement(Macbookpro).click();

		WebElement Macproduct = driver.findElement(MacBookProduct);

		String Macproducttext = Macproduct.getText();

		List<WebElement> productdetail = driver.findElements(By.xpath("(//ul[@class='list-unstyled'])[8]/li"));

		// for(int i=0;i<productdetail.size();i++)
		// {
		// System.out.println(productdetail.get(i).getText());
		// }
		//

		Map<String, String> poductMap = new HashMap<String, String>();

		// System.out.println(productdetail.get(i).getText().split(" "));
		String[] productsarr0 = productdetail.get(0).getText().split(":");
		System.out.println(productsarr0[0] + " " + productsarr0[1]);
		String[] productsarr1 = productdetail.get(1).getText().split(":");
		System.out.println(productsarr1[0] + " " + productsarr1[1]);
		String[] productsarr2 = productdetail.get(2).getText().split(":");
		System.out.println(productsarr2[0] + " " + productsarr2[1]);
		String[] productsarr3 = productdetail.get(3).getText().split(":");
		System.out.println(productsarr3[0] + " " + productsarr3[1]);

		poductMap.put("name", Macproducttext);
		poductMap.put(productsarr0[0], productsarr0[1]);
		poductMap.put(productsarr1[0], productsarr1[1]);
		poductMap.put(productsarr2[0], productsarr2[1]);
		poductMap.put(productsarr3[0], productsarr3[1]);

		for (Map.Entry<String, String> entry : poductMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
	}

}
