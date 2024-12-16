import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter07_01_Selenium_WebDriver_Techniques_to_Automate_Web_Elements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise");

		// All the below selectors work!
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		// WebElement staticDropdown =
		// driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
		// WebElement staticDropdown =
		// driver.findElement(By.cssSelector("select[id='ctl00_mainContent_DropDownListCurrency']"));
		// WebElement staticDropdown =
		// driver.findElement(By.name("ctl00$mainContent$DropDownListCurrency"));

		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println("Selected static dropdown option 1: " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println("Selected static dropdown option 2: " + dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println("Selected static dropdown option 3: " + dropdown.getFirstSelectedOption().getText());

		Thread.sleep(1000);

	}

}
