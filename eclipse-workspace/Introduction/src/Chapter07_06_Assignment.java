
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

// Assignment in section 
public class Chapter07_06_Assignment {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.manage().window().maximize();

		Thread.sleep(500);
		String first_checkbox_selector = "input[id='checkBoxOption1']";
		String all_checkboxes_selector = "input[type='checkbox']";
		String id_selector = "checkBoxOption1";
		// 1- Check
		// driver.findElement(By.cssSelector(first_checkbox_selector)).click();
		driver.findElement(By.id(id_selector)).click();
		Thread.sleep(500);

		// 2- Verify
		System.out.println("is checkbox selected? (1):"
				+ driver.findElement(By.cssSelector(first_checkbox_selector)).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector(first_checkbox_selector)).isSelected());

		// 3- Uncheck
		driver.findElement(By.cssSelector(first_checkbox_selector)).click();
		Thread.sleep(500);

		// 4- Verify
		System.out.println("is checkbox selected? (2):"
				+ driver.findElement(By.cssSelector(first_checkbox_selector)).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector(first_checkbox_selector)).isSelected());

		// 5- Count the number of the checkboxes
		System.out.println(driver.findElements(By.cssSelector(all_checkboxes_selector)).size());

		Thread.sleep(1000);

		System.out.println("End of the code");
	}
}
