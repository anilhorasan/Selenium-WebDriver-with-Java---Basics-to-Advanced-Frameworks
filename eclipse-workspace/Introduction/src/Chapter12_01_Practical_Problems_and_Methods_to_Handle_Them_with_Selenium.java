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

public class Chapter12_01_Practical_Problems_and_Methods_to_Handle_Them_with_Selenium {
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

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
	
		List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum = 0;
		
		for(int i=0; i<values.size(); i++) {
			sum += Integer.parseInt(values.get(i).getText());
		}
		System.out.println(sum);
		
		String text = driver.findElement(By.cssSelector(".totalAmount")).getText();
		int actualSum = Integer.parseInt(text.split(":")[1].trim());
		System.out.println(actualSum);
		
		Assert.assertEquals(sum,  actualSum);
	
	}

}


