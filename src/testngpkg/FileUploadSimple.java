package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadSimple {
	WebDriver  driver;
	
	String baseUrl="https://demo.guru99.com/test/upload/";
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test1()
	{
		driver.findElement(By.id("uploadfile_0")).sendKeys("C:\\Users\\91813\\OneDrive\\Desktop\\Software Testing\\AutomationTask.txt");
	}
}
