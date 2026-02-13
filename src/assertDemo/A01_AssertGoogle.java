//Launch Google, search India, assert whether the test case is passed or failed
package assertDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A01_AssertGoogle {

	@Test
	public void testAssert() {

		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.name("q")).sendKeys("India");

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		Assert.assertEquals(driver.getTitle(), "India - Google Search", "title mismatched!");
	}

}
