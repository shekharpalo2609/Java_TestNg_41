package selenium_waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class ImplicitWait {

	@Test
	public void implicitWait() throws InterruptedException {
		// ChromeDriver driver = new ChromeDriver();
		EdgeDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		Thread.sleep(2000);

		driver.findElement(By.name("q")).sendKeys("India");

		// 1st method: using click()
		driver.findElement(By.name("btnK")).click();
	}
}