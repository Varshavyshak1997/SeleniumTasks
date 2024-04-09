package testngpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DataDrivenTask {

	WebDriver  driver;
	
	String baseUrl="https://shoppy.sg/";
	
	@BeforeTest
	public void urlOpen()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test() throws Exception
	{
		
			driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[3]/div[2]/div[2]/ul/li[5]/a")).click();
			driver.findElement(By.name("customer[email]")).sendKeys("varsharameshK007@gmail.com");
			driver.findElement(By.name("customer[password]")).sendKeys("Varsha@1997");
			driver.findElement(By.xpath("//*[@id=\"customer_login\"]/input[5]")).click();
			
			
//	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	        wait.until(ExpectedConditions.urlToBe("https://shoppy.sg/account"));
//	        Thread.sleep(30000);
			String actualUrl=driver.getCurrentUrl();
			String expUrl="https://shoppy.sg/account";
			    
			if(actualUrl.equals(expUrl))
			{
				System.out.println("Successful");
			}
			else
			{
				System.out.println("Unsuccessful");
			}
	}
}
