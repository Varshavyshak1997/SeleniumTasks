package testngpkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WindowHandler {
	WebDriver  driver;
	String baseUrl="http://demo.guru99.com/popup.php";
	
    @BeforeTest
    public void setUp()
    {
    	driver=new ChromeDriver();
		driver.get(baseUrl);
		//driver.manage().window().maximize();
    }
    
    @Test
	public void test1() throws Exception
	{
    	String parentWindow=driver.getWindowHandle();//current window
    	
    	System.out.println("Parent window title is "+driver.getTitle());
    	driver.findElement(By.xpath("/html/body/p/a")).click();
    	
    	Set<String> allWindowhandles=driver.getWindowHandles();
    	
    	for(String handle: allWindowhandles)
    	{
    		
    		if(!handle.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(handle);
    			driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("abc@gmail.com");
    			Thread.sleep(3000);
    			driver.close();    			
    		}
    		driver.switchTo().window(parentWindow);
    	}
	}
	
}
