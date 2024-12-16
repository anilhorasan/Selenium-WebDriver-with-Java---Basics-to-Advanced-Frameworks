import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Chapter07_05_Checkboxes {
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

		Thread.sleep(5000);

		String checkbox_selector2 = "body div[id='react-root'] div[id='main-container'] div[class='css-1dbjc4n "
				+ "r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu'] div[class='css-1dbjc4n r-14lw9ot'] "
				+ "div[class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-11ict49 r-8uuktl "
				+ "r-136ojw6'] div[class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim'] "
				+ "div[class='css-1dbjc4n'] div[class='css-1dbjc4n'] div[class='css-1dbjc4n "
				+ "r-1d09ksm r-1inuy60 r-m611by'] div[class='css-1dbjc4n'] "
				+ "div[class='css-1dbjc4n r-18u37iz r-1w6e6rj'] div:nth-child(2) "
				+ "div:nth-child(1) div:nth-child(1) div:nth-child(1) svg circle";

		String checkbox_selector = "body > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) "
				+ "> div:nth-child(1) > div:nth-child(3) > div:nth-child(2) > div:nth-child(6) "
				+ "> div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) "
				+ "> div:nth-child(2) > div:nth-child(1) > div:nth-child(1)";

		String checkbox_selector_xpath = "//body[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/div[6]"
				+ "/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]";

		Assert.assertFalse(driver.findElement(By.cssSelector(checkbox_selector)).isSelected());
		// Assert.assertFalse(true);
		// System.out.println("is checkbox selected? (1):" +
		// driver.findElement(By.cssSelector(checkbox_selector)).isSelected());
		Thread.sleep(2000);
		driver.findElement(By.xpath(checkbox_selector_xpath)).click();
		Thread.sleep(2000);
		// It clicks on the webpage but isSelected seems to be false... Could not
		// understand the reason.
		System.out.println(
				"is 2nd checkbox selected? (2):" + driver.findElement(By.xpath(checkbox_selector_xpath)).isSelected());
		// Assert.assertTrue(driver.findElement(By.cssSelector(checkbox_selector)).isSelected());

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		Thread.sleep(1000);

		System.out.println("End of the code");
	}
}
