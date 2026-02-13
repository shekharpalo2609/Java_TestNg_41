//3. Search mouse -> sort Get It in 2 Days->click on 1st product
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_03 extends LaunchQuit {

	@Test
	public void selectMouse() {
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("mouse");
		search.sendKeys(Keys.ENTER);
		
		WebElement	getIn2Days = driver.findElement(By.xpath("//span[.='Get It in 2 Days']")); 
		getIn2Days.click();
	}
}
