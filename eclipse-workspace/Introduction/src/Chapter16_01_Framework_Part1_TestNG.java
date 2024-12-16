import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Chapter16_01_Framework_Part1_TestNG {
	
	@Test
	public void Demo() {
		System.out.println("hello");
	}

	/*
	public static void main(String[] args) throws IOException {

		// ESTABLISH WEBDRIVER
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");

		// Start Maximized:
		chromeOptions.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(chromeOptions);

		//driver.get("https://rahulshettyacademy.com/angularpractice/");	
	}
	*/
	
}
