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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter12_02_Assignment_7 {

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

		// Print the number of rows --> 11
		List<WebElement> rows = driver.findElements(By.cssSelector(".table-display tr"));
		// xpath: //table[@class='table-display']//tr
		System.out.println(rows.size());

		// Print the number of columns --> 3
		List<WebElement> columns = driver.findElements(By.cssSelector(".table-display tr th"));
		System.out.println(columns.size());

		// Print the data in the second row
		List<WebElement> values = driver.findElements(By.xpath("//table[@class='table-display']//tr[3]//td"));
		for (int i = 0; i < columns.size(); i++) {
			// System.out.print(driver.findElement(By.cssSelector("//table[@class='table-display']//tr[1]//th[i]")).getText()
			// + ": ");
			System.out.println(values.get(i).getText());

		}

		System.out.println("----------");
		//RAHUL'S SOLUTION:		
		WebElement table = driver.findElement(By.id("product"));
		System.out.println(table.findElements(By.tagName("tr")).size());
		System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());
		List<WebElement> secondrow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));
		System.out.println(secondrow.get(0).getText());
		System.out.println(secondrow.get(1).getText());
		System.out.println(secondrow.get(2).getText());

	}

}
