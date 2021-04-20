package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.init_driver("chrome");
		br.lunchUrl("https://demo.opencart.com/index.php?route=account/login");
		By emailId = By.id("input-email");
		By password = By.id("input-password");
		By registerLink = By.linkText("Register");
		By FirstName = By.name("firstname");
		By LastName = By.xpath("//input[@type='text' and @id='input-lastname']");
		By Telephone = By.name("telephone");
		By Password = By.xpath("//input[@type='password' and @id='input-password']");
		By ConfirmPassword = By.xpath("//input[@id='input-confirm']");
		By Subscriber = By.xpath("//input[@name='newsletter' and @value='1']");
		By PrivacyPolicy = By.xpath("//input[@name='agree' ]");
		By Continue = By.xpath("//input[@type='submit' ]");

		// radio button x path
		// (//label[@class='radio-inline'])[position()=1]/input
		// (//label[@class='radio-inline'])[position()=2]/input
		//label[normalize-space()='No']
		//label[normalize-space()='Yes']
		

		// By Register = By.xpath("//a[text()='Register']");

		// a[text()='Register']"); //need to correct code

		// By Register = By.linkText(Register);

		List<WebElement> Elements = driver.findElements(By.xpath("//a[text()='Register']"));
		// List<WebElement>allControls=driver.findElements(By.xpath("//ul[@class='credentials_list']/li"));
		// WebElement
		// Register=driver.findElements(By.xpath("//a[text()='Register']")).get(2);

		ElementUtil eleutil = new ElementUtil(driver);
		eleutil.doclick(registerLink);
		eleutil.doSendKeys(FirstName, "Rekha");
		eleutil.doSendKeys(LastName, "Aswani");
		eleutil.doSendKeys(emailId, "rekha.aswani1@gmail.com");
		eleutil.doSendKeys(Telephone, "9923404365");
		eleutil.doSendKeys(Password, "reetuaswani@2020");
		eleutil.doSendKeys(ConfirmPassword, "reetuaswani@2020");
		eleutil.doclick(Subscriber);
		eleutil.doclick(PrivacyPolicy);
		eleutil.doclick(Continue);

		// eleutil.doclick(Register);

		System.out.println(br.getPageTitle());
		Thread.sleep(2000);
		br.closeBrowser();

	}

}
