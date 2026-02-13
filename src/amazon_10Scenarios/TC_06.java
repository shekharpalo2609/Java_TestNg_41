//6. after launch->click on electronics major tab->select brand as amazon basics
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_06 extends LaunchQuit {

	@Test
	public void selectBrand() {
		WebElement electronicsTab = driver.findElement(By.partialLinkText("Electronics"));
		electronicsTab.click();
		
		WebElement selectBrand = driver.findElement(By.xpath("(//span[.='amazon basics'])[2]"));
		selectBrand.click();
	}
}