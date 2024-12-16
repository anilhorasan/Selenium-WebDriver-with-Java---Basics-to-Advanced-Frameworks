import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chapter07_03_dynamic_dropdowns {

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
		 
		driver.findElement(By.xpath("//div[@data-testid='to-testID-origin']//div[@class='css-1dbjc4n r-14lw9ot r-11u4nky r-z2wwpe "
				+ "r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-tju18j r-5njf8e r-1otgn73']")).click();
		Thread.sleep(500L);
		driver.findElement(By.xpath(" //div[contains(text(),'BLR')]")).click();
		Thread.sleep(500L);
		driver.findElement(By.xpath(" //div[contains(text(),'MAA')]")).click();
	    Thread.sleep(500);

	}

}

