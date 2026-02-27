package listeners;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ListenerLogic.class)
public class ListenerTestCase extends ListenerLogic {
	
	@Test
	public void searchProduct() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");

		WebElement search = driver.findElement(By.xpath("//input[@id ='twotabsearchtextbox']"));
		search.sendKeys("shoes");					
		search.sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "Amazon.in : shoe");
}
}