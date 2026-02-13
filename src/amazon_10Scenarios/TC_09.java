//9. Launch home page->click on todays deals->deals of the day->click on the 1st product
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_09 extends LaunchQuit {

	@Test
	public void selectBook() {
		WebElement todaysDeal = driver.findElement(By.linkText("Today's Deals"));
		todaysDeal.click();
		
		WebElement back = driver.findElement(By.xpath("(//button[@aria-hidden='true'])[1]"));
		back.click();
		
		WebElement deaoOfTheDay = driver.findElement(By.xpath("(//button[.='Deal of the Day'])"));
		deaoOfTheDay.click();
	
		
		
	}
}