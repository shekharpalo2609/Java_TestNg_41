//1. Search mobile->click on the 1st mobile
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_02 extends LaunchQuit {

	@Test
	public void selectMobile() {
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("mobile");
		search.sendKeys(Keys.ENTER);
		
		WebElement	clickMobile = driver.findElement(By.xpath("((//div[@class='puisg-col-inner'])[2]//a)[3]")); 
		clickMobile.click();
	}
}
