package testngpkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExampleprgmContextmenu {
	WebDriver  driver;
	
	String baseUrl="https://demo.guru99.com/test/simple_context_menu.html";
	
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
		 WebElement rightClickElement = driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));	 
		 Actions act = new Actions(driver);
		 act.contextClick(rightClickElement).perform(); 
		 driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]")).click();
		 driver.switchTo().alert().accept();
		 WebElement doublec=driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
		 act.doubleClick(doublec).perform();
		 Alert a=driver.switchTo().alert();
		 String alerttext=a.getText();
		 System.out.println(alerttext);
		 a.accept();
	}
}
