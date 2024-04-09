package testngpkg;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenprgm {
	WebDriver  driver;
	
	String baseUrl="https://www.facebook.com";
	
	@BeforeTest
	public void urlOpen()
	{
		driver=new ChromeDriver();
		//driver.get(baseUrl);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		FileInputStream obj=new FileInputStream("C:\\Users\\91813\\OneDrive\\Desktop\\Software Testing\\loginDetails.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(obj);//excel book
		XSSFSheet sheet=workBook.getSheet("Sheet1");//sheet details
		int lastRow=sheet.getLastRowNum();
		
		for(int i=1;i<=lastRow;i++)
		{
			String userName=sheet.getRow(i).getCell(0).getStringCellValue();
			String passWord=sheet.getRow(i).getCell(1).getStringCellValue();
			System.out.println("Username : "+userName);
			System.out.println("Password : "+passWord);
			
			driver.get(baseUrl);
			driver.findElement(By.name("email")).sendKeys(userName);
			driver.findElement(By.name("pass")).sendKeys(passWord);
			driver.findElement(By.name("login")).click();
			
			String actualUrl=driver.getCurrentUrl();
			String expUrl="https://www.facebook.com";
			if(actualUrl.equals(expUrl))
			{
				System.out.println("Successful");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
		}
		
	}
}
