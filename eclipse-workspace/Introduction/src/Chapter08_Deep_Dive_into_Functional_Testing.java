import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Chapter08_Deep_Dive_into_Functional_Testing {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Carrot" };
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		// convert array to ArrayList for easy search
		List<String> itemsNeededList = Arrays.asList(itemsNeeded);

		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			String formattedName = name.split(" ")[0];
			Thread.sleep(200);
			if (itemsNeededList.contains(formattedName)) {
				// Click on ADD TO CART
				driver.findElements(By.xpath("//div[@class='product-action']//button")).get(i).click();
				if (++j == itemsNeeded.length)
					break;
			}
		}

		String message = "end of the code";
		System.out.println(message);
		Thread.sleep(2000);

	}

}
