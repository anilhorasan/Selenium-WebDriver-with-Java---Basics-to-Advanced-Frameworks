import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Chapter10_04_Frames {
	public static void main(String[] args) {
		// ESTABLISH WEBDRIVER
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/MSI/Documents/chromedriver-win64-129-2/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setBinary("C:/Users/MSI/Downloads/chrome-win64 (1)/chrome-win64/chrome.exe");
		chromeOptions.addArguments("user-data-dir=C:/Users/MSI/AppData/Local/Google/Chrome for Testing/User Data");
		WebDriver driver = new ChromeDriver(chromeOptions);

		// GO TO THE WEBSITE for testing
		driver.get("https://jqueryui.com/droppable//");
		driver.manage().window().maximize();

		// COUNT THE FRAMES and print it out
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		System.out.println("# of frames in the page: " + frameCount);

		// SELECT FRAME to do operations. There two alternatives:
		// First option:
		// driver.switchTo().frame(0);
		// Second option:
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		// DRAG and DROP
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();

		// At the end, we should quit the frame:
		driver.switchTo().defaultContent();

	}

}
