package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartTest extends BaseTest{
	
	@Test(priority = 1)
	public void demoCartTitleTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}

	@Test(priority = 2)
	public void YourStoreTitleTest()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Your Store']")).isDisplayed());
	}
	
	@Test(priority = 3)
	public void VeriryLoginButton()
	{
		Assert.assertTrue(driver.findElement(By.xpath("//input[@class='btn btn-primary']")).isDisplayed());
	}
	
}

