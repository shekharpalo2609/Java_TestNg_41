package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_AmazonRegistration {

	@DataProvider(name = "registrationData")
	public Object[][] registrationCredentials() {

		Object[][] data = new Object[10][3];

		data[0][0] = 9985412354L;
		data[0][1] = "amar";
		data[0][2] = "password@111";

		data[1][0] = 9522102574L;
		data[1][1] = "raju";
		data[1][2] = "password@222";

		data[2][0] = 9965410247L;
		data[2][1] = "mukesh";
		data[2][2] = "password@333";

		data[3][0] = 8541003657L;
		data[3][1] = "suri";
		data[3][2] = "password@444";

		data[4][0] = 9641102477L;
		data[4][1] = "deepak";
		data[4][2] = "password@555";

		data[5][0] = 7451125899L;
		data[5][1] = "chandu";
		data[5][2] = "password@666";

		data[6][0] = 7002566641L;
		data[6][1] = "adi";
		data[6][2] = "password@777";

		data[7][0] = 8541226980L;
		data[7][1] = "akshay";
		data[7][2] = "password@888";

		data[8][0] = 9647712025L;
		data[8][1] = "sumeet";
		data[8][2] = "password@999";

		data[9][0] = 9410247862L;
		data[9][1] = "rohit";
		data[9][2] = "password@100";

		return data;
	}

	@Test(dataProvider = "registrationData")
	public void registration(long mobile, String uname, String password) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0";
		driver.get(url);

		WebElement mobileNo = driver.findElement(By.id("ap_email_login"));
		mobileNo.sendKeys(String.valueOf(mobile));

		WebElement continueButton = driver.findElement(By.cssSelector("input.a-button-input"));
		continueButton.click();

		WebElement proceedButton = driver.findElement(By.xpath("//span[@class='a-button-inner']"));
		proceedButton.click();

		WebElement name = driver.findElement(By.xpath("//input[@id='ap_customer_name']"));
		name.sendKeys(uname);

		WebElement pwd = driver.findElement(By.xpath("//input[@id='ap_password']"));
		pwd.sendKeys(password);

	}

}
