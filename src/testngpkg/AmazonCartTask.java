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

public class AmazonCartTask {
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
    	
    	
    	
    	//Search mobiles
    	driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Mobilephones",Keys.ENTER);
    	
    	//Verify title
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
		
		String parentWindow=driver.getWindowHandle();//current window
		
    	//driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down to the element
		WebElement element = driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		element.click();
		
		Set<String> allWindowhandles=driver.getWindowHandles();
    	
    	for(String handle: allWindowhandles)
    	{
    		
    		if(!handle.equalsIgnoreCase(parentWindow))
    		{
    			driver.switchTo().window(handle);
    			System.out.println("Switch window title is "+driver.getTitle());
    			
//    			WebElement cartElement = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
//    			js.executeScript("arguments[0].scrollIntoView(true);", cartElement);
//    			cartElement.click();
    			
    			JavascriptExecutor js1=(JavascriptExecutor) driver;
    			js1.executeScript("javascrpt:window.scrollBy(250,350)");
    			
    			WebElement cartElement = driver.findElement(By.xpath("//*[@id=\"add-to-cart-button\"]"));
    			cartElement.click();
    			
   
    			
    			//driver.findElement(By.xpath("//*[@id=\"quantityLayoutLow_feature_div\"]")).click();
    			
//    			WebElement cartFinalElement = driver.findElement(By.xpath("//*[@id=\\\"attach-sidesheet-view-cart-button\\\"]/span/input"));
//    			js1.executeScript("arguments[0].scrollIntoView(true);", cartFinalElement);
//    			cartFinalElement.click();
    			
    			//driver.findElement(By.xpath("//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")).click();
    			//Thread.sleep(3000);
    			driver.close();    			
    		}
    		driver.switchTo().window(parentWindow);
    	}
		
    	
	}
    
	
}
