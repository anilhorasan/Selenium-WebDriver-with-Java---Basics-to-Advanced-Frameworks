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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Chapter11_03_Handling_Calendar_UI_revisited {
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
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		// Click to this date: 6/15/2027
		String day = "15";
		String month = "6";
		String year = "2027";

		String[] expectedList = { month, day, year };

		// First click to the calendar UI then select year
		driver.findElement(By.className("react-date-picker__inputGroup")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span")).click();
		driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']/span")).click();

		// GET YEAR
		driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

		// GET MONTH
		// driver.findElement(By.xpath("//button["+month+"]")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.valueOf(month) - 1)
				.click();
		// driver.findElement(By.xpath("//abbr[@aria-label='June 2027']")).click();

		// GET DAY
		driver.findElement(By.xpath("//abbr[text()='" + day + "']")).click();
		// driver.findElement(By.xpath("//abbr[@aria-label='June 15, 2027']")).click();

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));
		for(WebElement we : actualList) {
			System.out.println("we: " + we.getAttribute("value"));
		}
		
		System.out.println(actualList.size());
		for (int i = 0; i < 3; i++) {
			System.out.println(actualList.get(i).getAttribute("value"));
			if (actualList.get(i).getAttribute("value").equals(expectedList[i])) {
				Assert.assertTrue(true);
			} else {
				System.out.println("Date is not correctly chosen");
				Assert.assertTrue(false);
			}
		}
		System.out.println("Date is correctly chosen");
		
		// Showing that date cannot be taken directly! 
		String date = driver.findElement(By.xpath("//div[@class='react-date-picker__inputGroup']")).getText();
		System.out.println("date: " + date);
		
		// This way you can may be take the date! 
		String date2 = driver.findElement(By.xpath("//input[@name='date']")).getAttribute("value");
		System.out.println("date 2: " + date2);
	}

}
