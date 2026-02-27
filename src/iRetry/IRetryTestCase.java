package iRetry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IRetryTestCase {

	WebDriver driver;
	@Test(retryAnalyzer = iRetry.IRetryLogic.class) 
	public void searchProduct() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");

		WebElement search = driver.findElement(By.xpath("//input[@id ='twotabsearchtextboxu']"));
		search.sendKeys("shoes");
		search.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : shoes");
	}
}
