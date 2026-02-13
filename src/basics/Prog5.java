package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Prog5 {

	@SuppressWarnings("unused")
	@Test
	public static void logout() throws InterruptedException {

		// login
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		WebElement email = driver.findElement(By.id("ap_email_login"));
		email.sendKeys("paloskr26@gmail.com");
		email.sendKeys(Keys.ENTER);

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Paloskr@123");
		password.sendKeys(Keys.ENTER);

		// searching
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoes");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);

		// add to wishlist
		WebElement selectProduct = driver.findElement(By.xpath("(//div[@class='s-image-padding']/span)[1]"));
		selectProduct.click();

		Set<String> set = driver.getWindowHandles();
		Iterator<String> parentChildID = set.iterator();
		String parentId = parentChildID.next();
		String childId = parentChildID.next();
		driver.switchTo().window(childId);
		Thread.sleep(1000);

		// add to wishlist
		WebElement addToWishList = driver.findElement(By.xpath("//input[@title='Add to Wish List']"));
		addToWishList.click();
		driver.navigate().refresh();
		Thread.sleep(2000);

		// add to cart
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();

		// logout
		WebElement accountsAndList = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(accountsAndList).perform();
		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath("//span[normalize-space()='Sign Out']"));
		logout.click();

	}

}
