package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickConcept {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement rightClickEle = driver.findElement(By.xpath("//p//span[text()='right click me']"));

		Actions act = new Actions(driver);
		act.contextClick(rightClickEle).perform();
		By rightClickOption = By.xpath("//ul[@class='context-menu-list context-menu-root']/li/span");
		selectRightClickOption(rightClickOption, "Edit");
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		System.out.println(text);
		alert.accept();

		Thread.sleep(1000);
		act.contextClick(rightClickEle).perform(); // performing right click
		selectRightClickOption(rightClickOption, "Cut"); // clicking on cut option
		Thread.sleep(1000);
		Alert alert1 = driver.switchTo().alert();
		String text1 = alert1.getText();
		System.out.println(text1);
		alert1.accept();

		act.contextClick(rightClickEle).perform(); // performing right click
		selectRightClickOption(rightClickOption, "Copy"); // clicking on cut option
		Thread.sleep(1000);
		Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		System.out.println(text2);
		alert2.accept();

		act.contextClick(rightClickEle).perform(); // performing right click
		selectRightClickOption(rightClickOption, "Paste"); // clicking on cut option
		Thread.sleep(1000);
		Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		System.out.println(text3);
		alert3.accept();

		act.contextClick(rightClickEle).perform(); // performing right click
		selectRightClickOption(rightClickOption, "Delete"); // clicking on cut option
		Thread.sleep(1000);
		Alert alert4 = driver.switchTo().alert();
		String text4 = alert4.getText();
		System.out.println(text4);
		alert4.accept();

		act.contextClick(rightClickEle).perform(); // performing right click
		selectRightClickOption(rightClickOption, "Quit"); // clicking on cut option
		Thread.sleep(1000);
		Alert alert5 = driver.switchTo().alert();
		String text5 = alert5.getText();
		System.out.println(text5);
		alert5.accept();
	}

	public static void selectRightClickOption(By locator, String value) {

		List<WebElement> optionsList = driver.findElements(locator);

		for (WebElement e : optionsList) {
			String text = e.getText();
			System.out.println(text);
			if (text.equals(value)) {
				e.click();
				break;
			}
		}
	}
}
