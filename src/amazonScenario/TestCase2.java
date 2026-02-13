//Login -> searching -> click on 1st product -> add to wish list -> add to cart -> logout
package amazonScenario;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestCase2 extends LaunchAndQuit {

	@SuppressWarnings("unused")
	@Test
	public void addToCart() throws InterruptedException {
		// searching
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoes");
		search.sendKeys(Keys.ENTER);

		// add to wishlist
		WebElement selectProduct = driver.findElement(By.xpath("(//div[@class='s-image-padding']/span)[1]"));
		selectProduct.click();

		Set<String> set = driver.getWindowHandles();
		Iterator<String> parentChildID = set.iterator();
		String parentId = parentChildID.next();
		String childId = parentChildID.next();
		driver.switchTo().window(childId);
		Thread.sleep(1000);

		WebElement addToWishList = driver.findElement(By.xpath("//input[@title='Add to Wish List']"));
		addToWishList.click();
		driver.navigate().refresh();
		Thread.sleep(2000);

		// add to cart
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();
	}
}
