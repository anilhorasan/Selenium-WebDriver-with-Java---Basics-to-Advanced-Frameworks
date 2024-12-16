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

public class Chapter11_02_Assignment_5 {
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
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();

		// 1-2. Select any checkbox and grab the label
		// Look for tag "a"
		driver.findElement(By.id("checkBoxOption2")).click();
		String label = driver.findElement(By.cssSelector("label[for='benz']")).getText();
		System.out.println(label);
		// RAHUL'S SOLUTION HERE:
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();

		// 3. Select the dropdown according to the selected checkbox
		WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText(label);
		System.out.println("Selected static dropdown option: " + dropdown.getFirstSelectedOption().getText());

		// 4. Write the same label inside "Switch to Alert Example"
		driver.findElement(By.id("name")).sendKeys(label);

		// 5. Click "Alert" then verify the label in the alert. Then confirm
		driver.findElement(By.id("alertbtn")).click();
		String message = driver.switchTo().alert().getText();
		// close the alert:
		driver.switchTo().alert().accept();
		System.out.println(message);
		System.out.println("Is the label same?: " + message.contains(opt));
	}

}
