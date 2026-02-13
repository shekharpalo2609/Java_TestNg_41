package amazonScenario;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LaunchAndQuit {

	WebDriver driver;
	@BeforeMethod
	public  void launch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");

		WebElement email = driver.findElement(By.id("ap_email_login"));
		email.sendKeys("paloskr26@gmail.com");
		email.sendKeys(Keys.ENTER);

		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.sendKeys("Paloskr@123");
		password.sendKeys(Keys.ENTER);
	}
	
	@AfterMethod
	public  void quit() throws InterruptedException, IOException {
		
		Date date = new Date();
		System.out.println(date);

		String dateInString = date.toString();

		String hour = dateInString.substring(11, 13);
		System.out.println(hour);

		String minute = dateInString.substring(14, 16);
		System.out.println(minute);

		String second = dateInString.substring(17, 19);
		System.out.println(second);
		String currentTime = hour+minute+second;
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\HP\\OneDrive - HiWi Forex Transaction Services Pvt Ltd\\Pictures\\Screenshots\\amazon"+currentTime+".png");
		FileHandler.copy(source, destination);
		WebElement accountsAndList = driver.findElement(By.xpath("//span[normalize-space()='Account & Lists']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(accountsAndList).perform();
		Thread.sleep(2000);

		WebElement logout = driver.findElement(By.xpath("//span[normalize-space()='Sign Out']"));
		logout.click();

	}
}
