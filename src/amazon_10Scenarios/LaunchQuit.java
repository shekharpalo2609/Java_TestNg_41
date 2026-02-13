package amazon_10Scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class LaunchQuit {

	WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void launchAmazon(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	}

	@AfterMethod
	public void closeAmazon() throws InterruptedException {
		Thread.sleep(2000);		
		driver.quit();

	}

}
