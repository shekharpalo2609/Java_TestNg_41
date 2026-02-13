//7. launch home page->dropdown->amazon fresh->search for mango
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_07 extends LaunchQuit {

	@Test
	public void selectMango() {
		WebElement allDropdown = driver.findElement(By.id("searchDropdownBox"));
		Select selectMango = new Select(allDropdown);
		selectMango.selectByValue("search-alias=nowstore");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("mango");
		search.sendKeys(Keys.ENTER);
	}
}