
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Chapter07_07_Calendar_and_Dates {

	// Method for "Is Enabled?" according to background-color:
	public static void isEnabled(String s) {
		if (s.contains("background-color")) {
			System.out.println("Enabled: " + "FALSE");
			Assert.assertTrue(true);
		} else {
			System.out.println("Enabled: " + "TRUE");
			Assert.assertTrue(false);
		}
	}

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// driver.get("https://rahulshettyacademy.com/dropdownsPractise");
		driver.get("https://spicejet.com");
		driver.manage().window().maximize();
		Thread.sleep(400);

		String cssSelector_return_date = "div[data-testid='return-date-dropdown-label-test-id']";
		String attribute1 = driver.findElement(By.cssSelector(cssSelector_return_date)).getAttribute("style");
		System.out.println("Style when DISABLED:  " + attribute1);
		// Is Enabled?:
		isEnabled(attribute1);

		// Click to round-trip button to Enable the return date calendar
		driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();
		Thread.sleep(500);

		String attribute2 = driver.findElement(By.cssSelector(cssSelector_return_date)).getAttribute("style");
		System.out.println("Style when ENABLED: " + attribute2);
		// Is Enabled?: (This will raise an error. So Comment it out before moving on
		// isEnabled(attribute2);

		// Round Trip
		// driver.findElement(By.cssSelector("div[data-testid='round-trip-radio-button']")).click();
		Thread.sleep(100);
		// or One-Way
		driver.findElement(By.cssSelector("div[data-testid='one-way-radio-button']")).click();
		Thread.sleep(100);

		// Choose From and To Destination Country
		driver.findElement(
				By.xpath("//div[@data-testid='to-testID-origin']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe "
						+ "r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73']"))
				.click();
		Thread.sleep(200L);
		driver.findElement(By.xpath(" //div[contains(text(),'BLR')]")).click();
		Thread.sleep(200L);
		driver.findElement(By.xpath(" //div[contains(text(),'MAA')]")).click();
		Thread.sleep(2000);

		// Select the highlighted date for departure
		driver.findElement(
				By.cssSelector(".css-1dbjc4n.r-1awozwy.r-16ru68a.r-y47klf." + "r-1loqt21.r-eu3ka.r-1otgn73.r-1aockid"))
				.click();
		Thread.sleep(5000);

		// Click Search Flights
		driver.findElement(By.cssSelector("div[data-testid='home-page-flight-cta']")).click();
		Thread.sleep(100);

		System.out.println();

	}

}
