//Login to amazon application with 5 set of data
package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_AmazonLogin {

	@DataProvider(name = "login data")
	public Object[][] loginCredentials() {

		Object obj[][] = new Object[5][2];

		obj[0][0] = "avinash123@gmail.com";
		obj[0][1] = "Avinash@123";

		obj[1][0] = "babu255@gmail.com";
		obj[1][1] = "Babu@255";

		obj[2][0] = "chandan965@gmail.com";
		obj[2][1] = "Chandan@965";

		obj[3][0] = "dinesh511@gmail.com";
		obj[3][1] = "Dinesh@511";

		obj[4][0] = "eknath850@gmail.com";
		obj[4][1] = "Eknath@850";

		return obj;
	}

	@Test(dataProvider = "login data")
	public void amazonLogin(String userName, String password) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fref%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		WebElement email = driver.findElement(By.id("ap_email_login"));
		email.sendKeys(userName);

		WebElement continueButton = driver.findElement(By.cssSelector("input[type='submit']"));
		continueButton.click();

		WebElement pwd = driver.findElement(By.cssSelector("#ap_password"));
		pwd.sendKeys(password);

		WebElement signinButton = driver.findElement(By.cssSelector("input[type='submit']"));
		signinButton.click();

	}

}
