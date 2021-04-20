package SeleniumSessions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDownHandle {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.findElement(By.id("justAnInputBox")).click();
		// driver.findElement(By.id("//input[@id='justAnInputBox']")).click();
		Thread.sleep(2000);
		// List<WebElement> choiceList =
		// driver.findElements(By.cssSelector(".comboTreeItemTitle"));

		By choice = By.cssSelector(".comboTreeItemTitle");

		// or span.comboTreeItemTitle

		// for (int i = 0; i < choiceList.size(); i++) {
		// String text = choiceList.get(i).getText();
		// if (text.equals("choice 3")) {
		// choiceList.get(i).click();
		// break;
		// }
		// }
		// tC1 Single selection
		// SelectChoice(choice, "choice 3");
		// SelectChoice(choice, "choice 6 2 1");
		// SelectChoice(choice, "choice 7");
		// TC2 multi selection

		// SelectChoice(choice, "choice 1", "choice 2", "choice 3");
		// SelectChoice(choice, "choice 7");

		// TC3: all selection
		SelectChoice(choice, "ALL");
		DeSelectChoice(choice, "ALL");

	}

	// public static List<WebElement> getElements(By locator) {
	// return driver.findElements(locator);
	// }
	//
	// public static void SelectChoice(By locator, String value) {
	// List<WebElement> choiceList = getElements(locator);
	// for (int i = 0; i < choiceList.size(); i++) {
	// String text = choiceList.get(i).getText();
	// if (text.equals(value)) {
	// choiceList.get(i).click();
	// }
	//
	// }
	// }
	public static void SelectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		if (!value[0].equalsIgnoreCase("all")) {
			for (int i = 0; i < choiceList.size(); i++) {
				String text = choiceList.get(i).getText();
				System.out.println(text);
				for (int j = 0; j < value.length; j++) {
					if (text.equals(value[j])) {
						choiceList.get(i).click();
						break;
					}

				}
			}
		}
		// select all the values
		else {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {

			}
		}
	}

	// deselect all the choices

	public static void DeSelectChoice(By locator, String... value) {
		List<WebElement> choiceList = driver.findElements(locator);
		if (value[0].equalsIgnoreCase("all")) {
			try {
				for (WebElement e : choiceList) {
					e.click();
				}
			} catch (Exception e) {

			}

		}
		// select all the values

	}

}