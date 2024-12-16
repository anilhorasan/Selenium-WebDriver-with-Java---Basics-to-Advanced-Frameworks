import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selintroduction {
	
	public static void main(String[] args) {
		
		// System.setProperty("webdriver.chrome.driver", "C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
        // WebDriver driver = new ChromeDriver();
        
        // System.setProperty("webdriver.gecko.driver", "C:/Users/MSI/Documents/geckodriver.exe");
        // WebDriver driver = new FirefoxDriver();
        
        System.setProperty("webdriver.edge.driver", "C:/Users/MSI/Documents/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        
        
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		//driver.close();  //only current window
		//driver.quit();  // close all associated tabs 
		//Difference between quit and close is a good interview  question! 
		
		
		
		
	}

}
