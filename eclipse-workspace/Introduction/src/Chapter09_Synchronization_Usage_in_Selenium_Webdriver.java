import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Chapter09_Synchronization_Usage_in_Selenium_Webdriver {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Implicit Wait - Explicit Wait
		// Choose one of them and comment out the other to test.
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		Thread.sleep(800);
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Carrot" };

		addItems(driver, itemsNeeded);
		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		// Thread.sleep(500);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		// alternative: driver.findElement(By.xpath("
		// //button[normalize-space()='PROCEED TO CHECKOUT']")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		// Thread.sleep(6000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String codeAppliedMessage = driver.findElement(By.cssSelector("span.promoInfo")).getText();
		System.out.println(codeAppliedMessage);
		// driver.findElement(By.xpath("//button[normalize-space()='Place
		// Order']")).click();

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) throws InterruptedException {

		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// convert array to ArrayList for easy search
		List<String> itemsNeededList = Arrays.asList(itemsNeeded);

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			String formattedName = name.split(" ")[0];
			Thread.sleep(200);
			if (itemsNeededList.contains(formattedName)) {
				// Click on ADD TO CART
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				if (++j == itemsNeeded.length)
					break;
			}
		}
	}
}
