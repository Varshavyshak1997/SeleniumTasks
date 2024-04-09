package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class amazonTask {
	ChromeDriver driver;
	String baseurl="https://www.amazon.in/";
	
	@Before 
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void titleverification() throws InterruptedException
	{
		//Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobile",Keys.ENTER);
		driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[5]")).click();
		driver.findElement(By.xpath("//*[@id='s-refinements']/div[2]/ul/li/span/a")).click();
		//sort by
		driver.findElement(By.xpath("//span[@id='a-autoid-0-announce']")).click();
		driver.findElement(By.xpath("//a[@id='s-result-sort-select_1']")).click();
		
	}
}
