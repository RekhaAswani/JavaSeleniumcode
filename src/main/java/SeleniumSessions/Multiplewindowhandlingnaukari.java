package SeleniumSessions;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Multiplewindowhandlingnaukari {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		Set<String> handles = driver.getWindowHandles();
		List<String> handlesList = new ArrayList<String>(handles);

		String parentwindowId = handlesList.get(0);
		String childwindowId = handlesList.get(1);
		driver.switchTo().window(childwindowId);
		Thread.sleep(1000);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		String childwindowId1 = handlesList.get(2);
		Thread.sleep(1000);
		driver.switchTo().window(childwindowId1);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		String childwindowId2 = handlesList.get(3);
		Thread.sleep(1000);
		driver.switchTo().window(childwindowId2);
		System.out.println(driver.getCurrentUrl());
		driver.close();
		
		driver.switchTo().window(parentwindowId);
		System.out.println(driver.getCurrentUrl());
		driver.close();

	}

}
