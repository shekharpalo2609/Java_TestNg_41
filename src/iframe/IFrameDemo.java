package iframe;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IFrameDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3F_encoding%3DUTF8%26ref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
   
		Thread.sleep(2000);

		WebElement emailMobile =  driver.findElement(By.id("ap_email_login"));
		emailMobile.sendKeys("paloskr26@gmail.com");
		
		WebElement continueButton = driver.findElement(By.id("continue"));
		continueButton.click();
		
		WebElement password = driver.findElement(By.id("ap_password"));
		password.sendKeys("Shekhar@123");
		
		WebElement passwordButton = driver.findElement(By.id("signInSubmit"));
		passwordButton.click();
		
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("shoes");
		search.sendKeys(Keys.ENTER);

		// add to wishlist
		WebElement selectProduct = driver.findElement(By.xpath("(//div[@class='s-image-padding']/span)[1]"));
		selectProduct.click();

		Set<String> set = driver.getWindowHandles();
		Iterator<String> parentChildID = set.iterator();
		parentChildID.next();
		String childId = parentChildID.next();
		driver.switchTo().window(childId);
		Thread.sleep(1000);

		/*
		 * WebElement addToWishList =
		 * driver.findElement(By.xpath("//input[@title='Add to Wish List']"));
		 * addToWishList.click(); driver.navigate().refresh(); Thread.sleep(2000);
		 */
		WebElement addToCart = driver.findElement(By.id("add-to-cart-button"));
		addToCart.click();
		
		WebElement proceedToBuy = driver.findElement(By.name("proceedToRetailCheckout"));
		proceedToBuy.click();
		
		WebElement selectAddress = driver.findElement(By.xpath("(//span[normalize-space()='Deliver to this address'])[5]"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectAddress));
		selectAddress.click();
		
		
		WebElement creditRadio = driver.findElement(By.xpath("//span[normalize-space()='Credit or debit card']"));
		creditRadio.click();
		
		WebElement newCreditCard = driver.findElement(By.xpath("(//a[normalize-space()='Add a new credit or debit card'])[1]"));
		newCreditCard.click();

		driver.switchTo().frame(driver.findElement(By.name("ApxSecureIframe")));
		WebElement cardNumber = driver.findElement(By.name("addCreditCardNumber"));
		cardNumber.sendKeys("123456789012");
		
		WebElement cancel = driver.findElement(By.xpath("//button[normalize-space()='Cancel']"));
		cancel.click();
		
		driver.switchTo().defaultContent();
		
	}

}
