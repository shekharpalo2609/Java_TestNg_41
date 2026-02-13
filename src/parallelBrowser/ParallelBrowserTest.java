package parallelBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelBrowserTest {

	WebDriver driver;

	@Test
	@Parameters("browser")
	public void crossBrowserTesting(String browserName) throws InterruptedException {
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		
		if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		if(browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.get("https://www.google.com/") ;
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("q")).sendKeys("India");
		
		//1st method: using click()
		//driver.findElement(By.name("btnK")).click();
		
		//2nd method: using keys functionality
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}
}
