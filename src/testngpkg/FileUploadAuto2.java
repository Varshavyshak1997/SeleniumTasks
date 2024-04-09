package testngpkg;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadAuto2 {
WebDriver  driver;
	
	String baseUrl="https://www.ilovepdf.com/word_to_pdf";
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void fileUploadPrgm() throws IOException, Exception 
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec("C:\\Users\\91813\\OneDrive\\Desktop\\Software Testing\\autoitPrgms\\T1.exe");
		Thread.sleep(3000);
		
	}
}
