package SeleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandle_previousdate {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker")).click();
		Thread.sleep(2000);
		By calenderlist = By.xpath("//table[@class='ui-datepicker-calendar']//a");

		selectCalenderDate("13", "August", "2020");

	}

	// get month and year method
	public static String[] getMonthYear(String monthyearval) {
		return monthyearval.split(" ");
	}

	// select calender date
	public static void selectCalenderDate(String exDay, String exMonth, String exYear) {
		if (exMonth.equals("February") && Integer.parseInt(exDay) > 29) {
			System.out.println("Wrong date :" + exMonth + ":" + exDay);
			return;
		}
		String monthyearval = driver.findElement(By.className("ui-datepicker-title")).getText();
		// System.out.println(monthyearval);

		while (!(getMonthYear(monthyearval)[0].equals(exMonth) && getMonthYear(monthyearval)[1].equals(exYear))) {
			// click on the next icon
			System.out.println(monthyearval);
			driver.findElement(By.xpath("//a[@title='Prev']")).click();
			monthyearval = driver.findElement(By.className("ui-datepicker-title")).getText();
		}
		selectDate(exDay, "a");

	}

	// select by date
	public static void selectDate(String date, String htmltag) {
		driver.findElement(By.xpath("//" + htmltag + "[text()='" + date + "']")).click();
	}

	// select date by list
	public static void selectdatebyList(By locator, String date) {
		List<WebElement> datelist = driver.findElements(locator);
		System.out.println(datelist.size());
		for (WebElement e : datelist) {
			if (e.getText().equals(date)) {
				e.click();
				break;
			}
		}
	}

}
