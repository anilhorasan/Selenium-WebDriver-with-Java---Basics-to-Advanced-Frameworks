import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Chapter09_02_Assignment {

	public static void main(String[] args) throws InterruptedException, AWTException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Implicit Wait - Explicit Wait
		// Choose one of them and comment out the other to test.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/loginpagePractise");
		driver.manage().window().maximize();

		// Enter Username
		driver.findElement(By.name("username")).sendKeys("rahulshettyacademy");

		// Enter Password
		driver.findElement(By.name("password")).sendKeys("learning");

		// Select User RadioButton
		driver.findElement(By.xpath("//label[2]//span[2]")).click();
		// rahul's solution: 
		//driver.findElement(By.cssSelector(".customradio:nth-child(2)")).click();

		// Okay to Proceed
		// Wait until this popup show up
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));
		driver.findElement(By.id("okayBtn")).click();

		// Select Consultant from Dropdown menu
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='form-control']")));
		driver.findElement(By.xpath("//select[@class='form-control']")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Consultant");
		// rahul's solution: 
		//WebElement options = driver.findElement(By.xpath("//select[@class='form-control']"));

		// Select Checkbox
		driver.findElement(By.name("terms")).click();

		// Sign in
		driver.findElement(By.name("signin")).click();

		// Add all the element dynamically!
		addAllItems(driver);

		// Select Checkout
		driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

	}

	public static void addAllItems(WebDriver driver) {
		List<WebElement> products = driver.findElements(By.xpath("//button[contains(text(),'Add')]"));
		// rahul's solution
		//List <WebElement> products = driver.findElements(By.cssSelector(".card-footer .btn-info"));
		for (WebElement p : products)
			p.click();
	}
}

//Thread.sleep(4000);
// w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains"
// + "(text(), 'şifrenizi')]")));
// handle the Java Alert
// w.until(ExpectedConditions.alertIsPresent());
// driver.switchTo().alert().accept();

// Use Robot class to handle the alert
// Robot robot = new Robot();
// robot.keyPress(KeyEvent.VK_TAB);
// robot.keyPress(KeyEvent.VK_ENTER); // Press Enter to accept the alert
