//8. launch home page->dropdown->books -> search for "power of mind"->click on the 1st product
package amazon_10Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_08 extends LaunchQuit {

	@Test
	public void selectBook() {
		WebElement allDropdown = driver.findElement(By.id("searchDropdownBox"));
		Select selectBooks = new Select(allDropdown);
		selectBooks.selectByVisibleText("Books");
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("power of mind");
		search.sendKeys(Keys.ENTER);
		
		WebElement clickBook = driver.findElement(By.id("(//div[@role='listitem']/div)[1]"));
		clickBook.click();
	
		
		
	}
}