package browserPopups;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserPopups {

	@Test
	public void test() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("exludeSwitches", Arrays.asList("disable-popup-blocking"));
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		WebElement aboutAmazon = driver.findElement(By.partialLinkText("About Amazon"));
		Point point = aboutAmazon.getLocation();
		int x = point.getX();
		int y = point.getY();
		System.out.println(x);
		System.out.println(y);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy("+x+","+y+")");
		
		
	}
}
