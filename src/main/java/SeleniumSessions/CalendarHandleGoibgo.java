package SeleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarHandleGoibgo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(2000);
		driver.manage().window().maximize();

		driver.findElement(By.id("departureCalendar")).click();

		// driver.findElement(By.xpath("//div[text()='7']")).click();

		// SelectDate("15");

		// SelectDate("15", "div");

		selectCalendarDate("13", "October", "2021");

	}

	public static String[] getMonthYear(String monthYearVal) {
		return monthYearVal.split(" ");
	}

	public static void selectCalendarDate(String exDay, String exMonth, String exYear) {
		if (exMonth.equals("february") && Integer.parseInt(exDay) > 29) {
			System.out.println("Wrong date: " + exMonth + ":" + exDay);
			return;
		}

		String monthYearVal = driver.findElement(By.className("DayPicker-Caption")).getText();

		while (!(getMonthYear(monthYearVal)[0].equals(exMonth) && getMonthYear(monthYearVal)[1].equals(exYear))) {
			// click on next
			System.out.println(monthYearVal);
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			monthYearVal = driver.findElement(By.className("DayPicker-Caption")).getText();
		}

		SelectDate(exDay, "div");
	}

	public static void SelectDate(String day, String htmlTag) {
		driver.findElement(By.xpath("//" + htmlTag + "[text()='" + day + "']")).click();
	}
}
