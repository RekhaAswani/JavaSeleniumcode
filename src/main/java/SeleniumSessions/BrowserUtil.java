package SeleniumSessions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * 
 * @author Rekha
 *
 */
public class BrowserUtil {
	WebDriver driver;

	/**
	 * 
	 * @param browserName
	 * @return This method returns the driver
	 */
	public WebDriver init_driver(String browserName)

	{
		System.out.println("browser name is :" + browserName);
		switch (browserName) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Iguru\\I guru\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Iguru\\I guru\\geckodriver-v0.19.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		case "safari":
			driver = new SafariDriver();
		default:
			System.out.println("Please enter correct browser : " + browserName);
			break;
		}

		return driver;
	}

	/*
	 * 
	 * @param url 
	 */
	public void lunchUrl(String url) {
		driver.get(url);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageUrl() {
		return driver.getCurrentUrl();
	}

	public void closeBrowser() {
		driver.close();
	}
}
