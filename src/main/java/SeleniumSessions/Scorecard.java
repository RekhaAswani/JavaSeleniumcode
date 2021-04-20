package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scorecard {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/south-africa-women-tour-of-india-2020-21-1253264/india-women-vs-south-africa-women-2nd-t20i-1253273/full-scorecard");

		System.out.println(getWicketTakerName("Jemimah Rodrigues"));
		System.out.println(getWicketTakerName("Shafali Verma"));
		List<String> scoreList = getPlayerScoreCard("Shafali Verma");
		System.out.println(scoreList);

	}

	// a[contains(text(),'Shafali Verma')]//parent::td/following-sibling::td

	public static String getWicketTakerName(String playerName) {
		String xpath = "//a[contains(text(),'" + playerName + "')]//parent::td/following-sibling::td/span";
		return driver.findElement(By.xpath(xpath)).getText();

	}

	public static List<String> getPlayerScoreCard(String playerName) {
		List<String> scoreValueList = new ArrayList<String>();
		List<WebElement> scorecard = driver
				.findElements(By.xpath("//a[contains(text(),'" + playerName + "')]//parent::td/following-sibling::td"));

		for (int i = 1; i < scorecard.size(); i++) {
			String score = scorecard.get(i).getText();
			//System.out.print(score + " ");
			if (!score.isEmpty()) {
				scoreValueList.add(score);
			}

		}
		return scoreValueList;
	}

}
