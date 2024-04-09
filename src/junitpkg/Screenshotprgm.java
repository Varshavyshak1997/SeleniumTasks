package junitpkg;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshotprgm {

	ChromeDriver driver;
	String baseUrl="https://www.google.in";
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void screenshottest() throws IOException
	{
		File src=((TakesScreenshot)driver) .getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("C:\\Users\\91813\\OneDrive\\Desktop\\Software Testing\\Screenshots\\screenshot1.png"));
		
		WebElement ele=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]"));
		File screenshot=ele.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenshot, new File("./Screenshots/searchbutton.png"));
	}
}
