package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertBoxChecking {
	
	ChromeDriver driver;
	String baseUrl="file:///C:/Users/91813/OneDrive/Desktop/Software%20Testing/alertpage.html";
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();//maximize the browser
		driver.get(baseUrl);
	}
	
	@Test
	public void alertChecking()
	{
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		Alert a=driver.switchTo().alert();
		String alerttext=a.getText();
		System.out.println(alerttext);
		a.accept();
		//a.dismiss()//to cancel alert
		driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("varsha");
		driver.findElement(By.xpath("//*[@name='lastname']")).sendKeys("ramesh");
		driver.findElement(By.xpath("/html/body/input[4]")).click();
	}
}
