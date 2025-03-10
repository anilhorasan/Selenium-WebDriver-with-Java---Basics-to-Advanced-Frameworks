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

public class Chapter11_04_Assignment_6 {
	
	public static void main(String[] args) {
		// ESTABLISH WEBDRIVER
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-130/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		// Choose one of them and comment out the other to test.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// GO TO THE WEBSITE for testing
		driver.get("https://qaclickacademy.com/practice.php");
		driver.manage().window().maximize();

		// click option 2
        driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
        String opt=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
       
        // Select from dropdown
        WebElement dropdown=driver.findElement(By.id("dropdown-class-example"));
        Select s=new Select(dropdown);
        s.selectByVisibleText(opt);
        
        // Alert
        driver.findElement(By.name("enter-name")).sendKeys(opt);
        driver.findElement(By.id("alertbtn")).click();
	    String text=  driver.switchTo().alert().getText();
	    if(text.contains(opt))
	    	System.out.println("Alert message success");
	    else
	    	System.out.println("Something wrong with execution");

	}
}
