//10. Search shoe->go back go home page
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_10 extends LaunchQuit {

	@Test
	public void selectBook() {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoe");
		search.sendKeys(Keys.ENTER);	
		
		driver.navigate().back();
	}
}