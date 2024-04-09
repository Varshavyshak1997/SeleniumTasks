package junitpkg;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class elementverification {
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@Before 
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void titleverification()
	{
		driver.findElement(By.id("email")).sendKeys("abc");
		driver.findElement(By.id("pass")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
	}
	
	
//	@After
//	public void tearDown()
//	{
//		driver.quit();
//	}
}
