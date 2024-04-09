package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googleSearch {
	ChromeDriver driver;
	String baseurl="https://www.google.com";
	
	@Before 
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void searchverification()
	{
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.name("q")).sendKeys("abc");//we get element details
		//for storing the element details
		WebElement search=driver.findElement(By.name("q"));
		search.click();
		search.sendKeys("abc",Keys.ENTER);
		
	}
	
}
