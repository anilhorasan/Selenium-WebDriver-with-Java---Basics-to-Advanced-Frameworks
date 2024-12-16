import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter12_03_Assignment_8 {
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
		driver.get("https://rahulshettyacademy.com/AutomationPractice");
		driver.manage().window().maximize();

		String country = "india";

		WebElement inputBox = driver.findElement(By.id("autocomplete"));
		inputBox.click();
		inputBox.sendKeys(country.substring(0, 3));
		Thread.sleep(2000L);
		List<WebElement> options = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));
		// Hover over the suggestion
		Actions actions = new Actions(driver);

		for (WebElement we : options) {
			System.out.print("autosuggestion: ");
			System.out.println(we.getText());
			if (we.getText().equalsIgnoreCase("india")) {
				// click india
				actions.moveToElement(we).click().build().perform();
				break;
			}
		}

		// Retrieve the text from the input box after clicking the suggestion
		String selectedText = inputBox.getAttribute("value");
		System.out.println("Selected Text: " + selectedText);
		if (selectedText.equalsIgnoreCase(country))
			Assert.assertTrue(true);
		else
			Assert.assertFalse(true);

		// RAHUL'S SOLUTION:
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		Thread.sleep(2000);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

	}

}
