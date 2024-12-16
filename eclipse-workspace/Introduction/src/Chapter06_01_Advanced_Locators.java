import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

// Chapter 5
public class Chapter06_01_Advanced_Locators {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);

		// implicit wait - if no wait, Selenium is so fast and can't locate error
		// message cuz it haven't load, yet.
		// max timeout should be 5 seconds
		// This line waits for 2 seconds if sth does not show up. After 5 seconds it
		// crashes.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		String errorMessage = driver.findElement(By.cssSelector("p.error")).getText();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(errorMessage);
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000); // pause the code for 1 second
		
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John Dick");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("johndick@hotmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("johndick@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0(312) 741 29 56");
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		String secondErrorMessage = driver.findElement(By.cssSelector("form p")).getText();
		System.out.println(secondErrorMessage);

		// xPath: //div[@class="forgot-pwd-btn-conainer"]
		// xPath: //button[contains(@class, 'login')]
		// xPath: //div[contains(@class,"forgot")]/button[1]
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("anil");
		driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");
		
		Thread.sleep(1000);
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();

		// xPath: //button[class='submit signInBtn']
		// xPath: //button[contains(@class,'submit')] w/ regex
		driver.findElement(By.className("signInBtn")).click();

		// driver.close(); //only current window
		// driver.quit(); // close all associated tabs
		// Difference between quit and close is a good interview question!

	}
}
