package testngpkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadAuto {
	
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
	public void fileUploadPrgm() throws AWTException
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
		
		fileUpload("\"C:\\Users\\91813\\OneDrive\\Desktop\\Software Testing\\Resume_Varsha_2024.docx\"");
	}
	
	public void fileUpload(String p) throws AWTException
	{
		StringSelection strSelection=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSelection, null);
		
		Robot robot= new Robot() ; //using robot class for auto file upload
		
		robot.delay(3000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		robot.keyRelease(KeyEvent.VK_ENTER);
	}
} //File first copy the file path to the clipboard
