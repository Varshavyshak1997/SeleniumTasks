package testngpkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonCartTaskNew {
	WebDriver  driver;
	String baseUrl="https://www.amazon.in/";
	
    @BeforeTest
    public void setUp()
    {
    	driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
    }
    
    @Test
	public void test1() throws Exception
	{
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobilephones",Keys.ENTER);
    	String actualtitle=driver.getTitle();
		String exp="Amazon.in : Mobilephones";
		if(actualtitle.equals(exp))
		{
			System.out.println("Title verification passed");
		}
		else
		{
			System.out.println("Title verification Failed");
		}
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span")).click();
		
		String parentWindow=driver.getWindowHandle();
		
		Set<String> allWindowhandles=driver.getWindowHandles();
    	
    	for(String handle: allWindowhandles)
    	{
    		
    		if(!handle.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(handle);
    			
//    			JavascriptExecutor js = (JavascriptExecutor) driver;  
//    			js.executeScript("javascrpt:window.scrollBy(250,350)");
    			
    			WebElement cartElement = driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div[8]/div[8]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/input"));

    			cartElement.click();
    			
    			Thread.sleep(30000);
    			
    			driver.findElement(By.xpath("/html/body/div[12]/div[3]/div[3]/div/div[1]/div[3]/div[1]/div[2]/div[3]/form/span/span/input")).click();
    			
    			//driver.close();
    		}
	}
	}
}
