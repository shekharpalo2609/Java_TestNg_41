//1. Search shoe->click on 1st shoe	
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_01 extends LaunchQuit {

	@Test
	public void searchShoe() {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoe");
		search.sendKeys(Keys.ENTER);
	}
	
}
