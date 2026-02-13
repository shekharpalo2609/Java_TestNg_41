//Facebook registration with 3 set of data(data provider). UAlso use DDT concept

package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFacebookDDT {

	@DataProvider(name = "facebook_credentials")
	
	public Object[][] facebookCredentials() throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\HP\\java practice\\Java_41\\TestData\\Book2.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		
		String firstName1 = workbook.getSheet("facebook").getRow(1).getCell(0).getStringCellValue();
		String surname1 = workbook.getSheet("facebook").getRow(1).getCell(1).getStringCellValue();
		String mobile1 = NumberToTextConverter.toText(workbook.getSheet("facebook").getRow(1).getCell(2).getNumericCellValue());
		String password1 = workbook.getSheet("facebook").getRow(1).getCell(3).getStringCellValue();
		
		String firstName2 = workbook.getSheet("facebook").getRow(2).getCell(0).getStringCellValue();
		String surname2 = workbook.getSheet("facebook").getRow(2).getCell(1).getStringCellValue();
		String mobile2 = NumberToTextConverter.toText(workbook.getSheet("facebook").getRow(2).getCell(2).getNumericCellValue());
		String password2 = workbook.getSheet("facebook").getRow(2).getCell(3).getStringCellValue();
		
		String firstName3 = workbook.getSheet("facebook").getRow(3).getCell(0).getStringCellValue();
		String surname3 = workbook.getSheet("facebook").getRow(3).getCell(1).getStringCellValue();
		String mobile3 = NumberToTextConverter.toText(workbook.getSheet("facebook").getRow(3).getCell(2).getNumericCellValue());
		String password3 = workbook.getSheet("facebook").getRow(3).getCell(3).getStringCellValue();
	
		Object data[][] = new Object[3][4];
		
		data[0][0] = firstName1;
		data[0][1] = surname1;
		data[0][2] = mobile1;
		data[0][3] = password1;
		
		data[1][0] = firstName2;     
		data[1][1] = surname2;       		
		data[1][2] = mobile2;        		
		data[1][3] = password2;      		
				
		data[2][0] = firstName3;     
		data[2][1] = surname3;       
		data[2][2] = mobile3;        		
		data[2][3] = password3;      
		
		return data;
	}
	
	@Test(dataProvider = "facebook_credentials")
	public void facebookRegistration(String fname, String lastname, String mobile, String pwd) throws EncryptedDocumentException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/r.php?entry_point=login");
		
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys(fname);
		
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys(lastname);
		
		WebElement dob= driver.findElement(By.id("day"));
		Select selectDOB = new Select(dob);
		selectDOB.selectByValue("6");
		
		WebElement dom= driver.findElement(By.id("month"));
		Select selectMonth = new Select(dom);
		selectMonth.selectByValue("9");
		
		WebElement doy = driver.findElement(By.id("year"));
		Select selectDOY = new Select(doy);
		selectDOY.selectByIndex(22);
		
		WebElement maleGender = driver.findElement(By.xpath("//label[normalize-space()='Male']"));
		maleGender.click();
		
		WebElement mobileNo = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(mobileNo));
		mobileNo.sendKeys("7894651466");
		
		WebElement password = driver.findElement(By.xpath("//input[@aria-label='New password']"));
		password.sendKeys(pwd);
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//driver.close();
	}
}
