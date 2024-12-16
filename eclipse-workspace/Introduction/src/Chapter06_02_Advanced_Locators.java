import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

//import io.github.bonigarcia.wdm.WebDriverManager;

// Chapter 5
public class Chapter06_02_Advanced_Locators {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		//System.setProperty("webdriver.chrome.whitelistedIps", "");
		ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64/chrome-win64/chrome.exe");
        chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/G7oogle/Chrome for Testing/User Data");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice");
		//driver.manage().window().maximize();
		Thread.sleep(1000);
		
		//Actions for double click on an element
		//I used double click (which is a topic of the upcoming chapters) in order to avoid the last written credentials. 
		
		
		String name = "anil";
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type*='pass'")).sendKeys("rahulshettyacademy");	
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.id("chkboxTwo")).click();
		// xPath: //button[class='submit signInBtn']
		// xPath: //button[contains(@class,'submit')]  w/ regex
		driver.findElement(By.className("signInBtn")).click();
		
		
		// Normally this was the code to go. But this did not work when i tried later... 
		//String message3 = driver.findElement(By.tagName("p")).getText();
		// New line of code to extract the required text:
		String message1 = driver.findElement(By.xpath("(//p[normalize-space()='You are successfully logged in.'])[1]")).getText();	
		
		System.out.println("message1: " + message1);
		Assert.assertEquals(message1, "You are successfully logged in.");
		
		String message2 = driver.findElement(By.cssSelector(".login-container h2")).getText();
		// alternatively  .login-container h2   "div[class='login-container'] h2"
		System.out.println("message2: " + message2);
		Assert.assertEquals(message2, "Hello " + name + ",");
		
		
		// For log-out... 
		// Xpath    --> //button[text()='Log Out']    //*[text()='Log Out']    
		// Using classname   --> .logout-btn 
		Thread.sleep(1100);
		driver.findElement(By.className("logout-btn")).click();
		//driver.findElement(By.xpath("//button[text()='Log Out']" )).click();	
		Thread.sleep(1100);
		driver.findElement(By.linkText("Forgot your password?")).click();

		Thread.sleep(1000);

		//driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click(); 
		//driver.findElement(By.xpath("//button[normalize-space()='Reset Login']")).click(); 
		
	
		String password = passwordExtractor(driver);
		
		driver.findElement(By.cssSelector(".go-to-login-btn")).click();
		Thread.sleep(100);
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		Thread.sleep(100);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.className("signInBtn")).click();
		Thread.sleep(1500);
		driver.findElement(By.className("logout-btn")).click();
		
		// Sibling - Child to parent traverse
		//header/div/button[1]/following-sibling::button[1]
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[3]")).getText());
		
        driver.navigate().to("http://google.com");
        // get wait for full load; but navigate does not wait to load. so be careful when using! 

        driver.navigate().back();

        driver.navigate().forward();
		
	}
	
	public static String passwordExtractor(WebDriver driver) {
		// cssSelector("form p")
		String message5 = driver.findElement(By.cssSelector(".infoMsg")).getText();
		System.out.println(message5);
		String[] parts = message5.split("'");
		System.out.println("0: " + parts[0]);
		System.out.println("1: " + parts[1]);
		System.out.println("2: " + parts[2]);
		return parts[1];
	}
}
