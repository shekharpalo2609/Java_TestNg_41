//5. Search camera->click on 15th camera
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_05 extends LaunchQuit {

	@Test
	public void select15thCamera() {

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("camera");
		search.sendKeys(Keys.ENTER);
		
		WebElement select15thCamera = driver.findElement(By.xpath("(//div[@data-cy='title-recipe'])[15]"));
		select15thCamera.click();
		
		
		
		
	}
}