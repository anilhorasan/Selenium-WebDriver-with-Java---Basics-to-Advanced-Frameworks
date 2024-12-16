import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chapter10_03_Assignment_4 {

	public static void main(String[] args) {
		// ESTABLISH WEBDRIVER
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);

		// GO TO THE WEBSITE for testing
		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// Click "Multiple Windows"
		driver.findElement(By.cssSelector("a[href='/windows']")).click();
		// RAHULS SOLUTION:
		// driver.findElement(By.linkText("Multiple Windows")).click();

		// Click "Click Here" to open a new window
		driver.findElement(By.cssSelector("a[href='/windows/new']")).click();
		// RAHULS SOLUTION:
		// driver.findElement(By.cssSelector("a[href*='windows']")).click();

		// Handle the child window
		Set<String> windows = driver.getWindowHandles(); // [parentID, childID]
		Iterator<String> iter = windows.iterator();
		String parentID = iter.next();

		// Switch to the child window and Capture the text and print it out.
		String child_message = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(child_message);
		// RAHULS SOLUTION:
		System.out.println(driver.findElement(By.xpath("//div/h3")).getText());

		// Turn back to parent window and grab text and print it out, too.
		driver.switchTo().window(parentID);
		String parent_message = driver.findElement(By.cssSelector("div[class='example'] h3")).getText();
		System.out.println(parent_message);
		// RAHULS SOLUTION:
		System.out.println(driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText());

	}

}
