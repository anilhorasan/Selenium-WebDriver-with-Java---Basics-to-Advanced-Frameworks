import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chapter07_02_Selenium_WebDriver_Techniques_to_Automate_Web_Elements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
        chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        // This rahulshettyacademy website, passengerCount cannot be selected. So I used spicejet.com.
		driver.get("https://spicejet.com");
		driver.manage().window().maximize();

		Thread.sleep(2000);
		
		// old code:  
		// driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000L);
		driver.findElement(By.xpath("(//div[@class='css-1dbjc4n'])[56]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div//"
				+ "div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 "
				+ "r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n "
				+ "r-1awozwy r-18u37iz r-1wtj0ep']")).getText());
	    Thread.sleep(4000);
		
		for(int i=1; i<5; i++) {
			//i=5;
			// Old Code:
			// driver.findElement(By.id("hrefIncAdt")).click();
			driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-k8qxaj r-d9fdf6']//div[1]//div[2]//div[3]")).click();
			System.out.println(i);
		}
		
		Thread.sleep(2000L);
		System.out.println(driver.findElement(By.xpath("//div[@class='css-1dbjc4n']//div//"
				+ "div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe r-1phboty r-rs99b7 "
				+ "r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73']//div[@class='css-1dbjc4n "
				+ "r-1awozwy r-18u37iz r-1wtj0ep']")).getText());

	}

}