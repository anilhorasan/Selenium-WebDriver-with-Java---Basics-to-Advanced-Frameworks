import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chapter07_04_Autosuggestive_Dropdowns {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");

		driver.manage().window().maximize();

		Thread.sleep(1000);

		driver.findElement(By.id("autosuggest")).click();
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(1000L);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		int i = 1;
		for (WebElement we : options) {
			System.out.print("autosuggestion " + i++ + ": ");
			System.out.println(we.getText());
			if (we.getText().equalsIgnoreCase("india")) {
				we.click();
				break;
			}
		}

		// Or directly choose the second suggestion which is also known to be India
		// driver.findElement(By.xpath("//ul[@id='ui-id-1']//li[2]")).click();

		Thread.sleep(1000L);
		driver.findElement(By.id("autosuggest")).sendKeys(Keys.ENTER);

		Thread.sleep(1000L);

		System.out.println("End of the code");
	}
}
