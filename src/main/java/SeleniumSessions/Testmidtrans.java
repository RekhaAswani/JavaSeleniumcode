package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Testmidtrans {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.midtrans.com/");
		driver.findElement(By.xpath("//a[text()='BUY NOW']")).click();
		driver.findElement(By.xpath("//div[text()='CHECKOUT']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().frame("snap-midtrans");
		//driver.switchTo().frame(0);
		// driver.switchTo().frame(driver.findElement(By.name("popup_1616145918775")));
		// driver.switchTo().frame("main");
		// driver.switchTo().frame(2);
		// driver.switchTo().frame(driver.findElement(By.name("main")));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='button-main-content']")).click();

		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".promo-text > span:nth-child(1)")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='cardnumber']")).sendKeys("4811 1111 1111 1114");
		driver.findElement(By.cssSelector(".col-xs-7 > input:nth-child(1)")).sendKeys("12/24");
		driver.findElement(By.cssSelector(".col-xs-5 > input:nth-child(1)")).sendKeys("123");

		Thread.sleep(1000);
		WebElement PAYNOW = driver.findElement(By.xpath("//a[@class='button-main-content']"));
		PAYNOW.click();

		Thread.sleep(5000);
		// driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		// driver.switchTo().frame("acs");
		// driver.switchTo().frame(driver.findElement(By.name("acs")));

		// iframe[@src='https://api.sandbox.veritrans.co.id/v2/token/rba/redirect/481111-1114-595d9899-9477-45a7-beac-d1868fb6be62']
		// WebElement
		// Frame=driver.findElement(By.xpath("iframe[contains(@src,'https://api.sandbox.veritrans.co.id/v2/token/rba/redirect')]"));
		// driver.switchTo().frame(Frame);

		//// iframe[contains(@src,'https://api.sandbox.veritrans.co.id/v2/token/rba/redirect')]

		driver.findElement(By.xpath("//input[@id='PaRes']")).sendKeys("112233");
	}
}
