package MyTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest extends BaseTest {

	@Test(priority = 1)
	public void amazonPageTitleTest() {
		driver.get("http://www.amazon.in/");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title,
				"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	}

	@Test(priority = 3)
	public void amazonLogoTest()

	{
		Assert.assertTrue(driver.findElement(By.id("nav-logo-sprites")).isDisplayed());

	}

	@Test(priority = 2)
	public void searchBarExistTest() {
		Assert.assertTrue(driver.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}

}
