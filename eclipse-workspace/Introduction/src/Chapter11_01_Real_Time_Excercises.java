import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chapter11_01_Real_Time_Excercises {
	public static void main(String[] args) throws InterruptedException {
		// ESTABLISH WEBDRIVER
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Choose one of them and comment out the other to test.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// GO TO THE WEBSITE for testing
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();

		// 1. Give me the count of the links in the page?
		// Look for tag "a"
		int link_count = driver.findElements(By.tagName("a")).size();
		System.out.println(link_count);

		// 2. Get the count of the links in the footer section?
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		int footer_link_count = footerDriver.findElements(By.tagName("a")).size();
		System.out.println(footer_link_count);

		// 3. Get the count of the links in the first column of the footer section?
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		int footer_first_column_link_count = columnDriver.findElements(By.tagName("a")).size();
		System.out.println(footer_first_column_link_count);

		// 4. Click each link in the column and check if the pages are loading?
		String tabClick = Keys.chord(Keys.CONTROL, Keys.ENTER);
		List<WebElement> listOfLinks = columnDriver.findElements(By.tagName("a"));
		for (WebElement we : listOfLinks) {
			// bu olmadı: control + click yapmaya çalıştım:
			// we.keyDown(Keys.CONTROL).click();
			we.sendKeys(tabClick);
		}

		// 5. Get the title of each tab opened!
		// Handle the child window
		Set<String> windows = driver.getWindowHandles(); // [parentID, childID]
		Iterator<String> iter = windows.iterator();
		for (int i = 0; i < footer_first_column_link_count; i++) {
			driver.switchTo().window(iter.next());
			System.out.println(i + " " + driver.getTitle());
		}

		// RAHUL'S SOLUTION:
		// while(iter.hasNext()) {
		// driver.switchTo().window(iter.next());
		// System.out.println(driver.getTitle());
		// }

	}
}
