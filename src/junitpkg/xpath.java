package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class xpath {
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
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("abc123");
		driver.findElement(By.xpath("//button[@name='login']")).click();
	}
}
