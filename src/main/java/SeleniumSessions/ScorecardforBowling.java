package SeleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScorecardforBowling {
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(
				"https://www.espncricinfo.com/series/south-africa-women-tour-of-india-2020-21-1253264/india-women-vs-south-africa-women-2nd-t20i-1253273/full-scorecard");

		List<String> Scorecard = getPlayerScoreCard("Arundhati Reddy");
		System.out.println(Scorecard);
	}

	// a[contains(text(),'Arundhati Reddy')]//parent::td/following-sibling::td

	public static List<String> getPlayerScoreCard(String playerName) {

		List<String> scoreValueList = new ArrayList<String>();
		List<WebElement> scorecard = driver
				.findElements(By.xpath("//a[contains(text(),'" + playerName + "')]//parent::td/following-sibling::td"));
		for (int i = 0; i < scorecard.size(); i++) {
			String score = scorecard.get(i).getText();
			// System.out.print(score + " ");
			if (!score.isEmpty()) {
				scoreValueList.add(score);
			}

		}
		return scoreValueList;

	}

}
