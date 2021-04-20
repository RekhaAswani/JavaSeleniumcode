package MyTests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenCartAccountPageTest extends BaseTest {

	@Test(priority = 1)
	public void demoCartTitleTest() {
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		Assert.assertEquals(driver.getTitle(), "Account Login");
	}

	@Test(priority = 2)
	public void VerifyMyAccountTest() {

		driver.findElement(By.name("email")).sendKeys("rekha.aswani@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Acc$1234");
		driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='My Account']")).isDisplayed());
	}

	@Test(priority = 3)

	public void verifyTitleOnAccountPage() {
		Assert.assertEquals(driver.getTitle(), "My Account");
	}
}
