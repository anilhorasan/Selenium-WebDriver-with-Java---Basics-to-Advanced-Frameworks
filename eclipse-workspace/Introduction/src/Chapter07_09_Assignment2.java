
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Chapter07_09_Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
        chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
        //WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice");
		//driver.get("https://spicejet.com");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		//name
		driver.findElement(By.name("name")).sendKeys("Anil Horasan");
		Thread.sleep(500);
		
		//email
		driver.findElement(By.name("email")).sendKeys("anilhorasan@hotmail.com");
		Thread.sleep(500);
		
		//password
		driver.findElement(By.id("exampleInputPassword1")).sendKeys("SomeShittyPassword");
		Thread.sleep(500);
		
		//checkbox for Icecream Love
		driver.findElement(By.id("exampleCheck1")).click();
		Thread.sleep(500);
		
		//Gender
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select drop = new Select(dropdown);
		drop.selectByVisibleText("Male");
		
		//Gender Alternative Path
		driver.findElement(By.id("exampleFormControlSelect1")).click();
		driver.findElement(By.xpath("//option[normalize-space()='Male']")).click();
		Thread.sleep(500);
		
		//Employment Status
		driver.findElement(By.id("inlineRadio1")).click();
		Thread.sleep(500);
		
		//Date of Birth
		driver.findElement(By.name("bday")).sendKeys("01/01/1990");
		Thread.sleep(3000);
		
		//Submit
		driver.findElement(By.cssSelector("input.btn-success")).click();
		
		//Print success message
		String success_message = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
		System.out.println(success_message);
		
		System.out.println();
		
		Thread.sleep(2000L);
	}

}

