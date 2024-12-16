import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Chapter34_01_window_popup {

	public static void main(String[] args) throws IOException, InterruptedException {
		// set chrome driver
		System.setProperty("webdriver.chrome.driver", "C:/Users/MSI/Documents/chromedriver-win64-130/chromedriver.exe");

		// Set ChromeOptions
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Documents/chrome-win64/chrome-win64/chrome.exe"); // Custom binary v130

		// Launch driver
		ChromeDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().window().maximize();

		// set up wait and get to website for test
		String url = "https://the-internet.herokuapp.com/basic_auth";
		String windowAuthenticationURL = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		driver.get(windowAuthenticationURL);
	}
}
