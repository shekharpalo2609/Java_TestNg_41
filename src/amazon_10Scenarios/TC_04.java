//4. Search mobile cover->Include Out of Stock checkbox
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_04 extends LaunchQuit {

	@Test
	public void selectMobileCover() {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("mobile cover");
		search.sendKeys(Keys.ENTER);
		
		WebElement	getIn2Days = driver.findElement(By.xpath("//span[.='Include Out of Stock']")); 
		getIn2Days.click();
	}
}
