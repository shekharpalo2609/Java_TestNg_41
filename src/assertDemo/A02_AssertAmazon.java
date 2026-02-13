/*In amazon.com, search shoe, click on 1st shoe and assert with the following:
Whether there are 2 tabs present
Buy now button is present in current tab
Add to cart is present in current tab*/

package assertDemo;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class A02_AssertAmazon {

	@Test
	public void testAssert() {

		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		WebElement search = driver.findElement(By.xpath("//input[@id = 'twotabsearchtextbox']"));
		search.sendKeys("shoes");
		search.sendKeys(Keys.ENTER);

		WebElement firstShoe = driver.findElement(By.xpath("(//div[@role=\"listitem\"])[1]//a[@aria-hidden='true']"));
		firstShoe.click();

		Set<String> set = driver.getWindowHandles();
		int windowCount = set.size();
		
		//Whether there are 2 tabs present
		Assert.assertEquals(windowCount, 2);
		
		Iterator<String> parentChildId = set.iterator();
		@SuppressWarnings("unused")
		String parentId = parentChildId.next();
		String childId = parentChildId.next();		
		
		driver.switchTo().window(childId);
		
		WebElement buyNow = driver.findElement(By.xpath("//input[@title='Buy Now']"));
		
		//Buy now button is present in current tab
		Assert.assertEquals(true, buyNow.isDisplayed(),"Buy now button is not displaying!");
		
		
		//Add to cart is present in current tab
		WebElement addToCart = driver.findElement(By.xpath("//input[@id='add-to-cart-button']"));
		Assert.assertEquals(true, addToCart.isDisplayed(),"Add to cart button is not displaying!");
	}

}
