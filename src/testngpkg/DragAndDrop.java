package testngpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {

WebDriver  driver;
	
	String baseUrl="https://demo.guru99.com/test/drag_drop.html";
	
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
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 Actions act = new Actions(driver);
		 WebElement source=driver.findElement(By.xpath("//*[@id=\"credit2\"]"));
		 WebElement Destination=driver.findElement(By.xpath("//*[@id=\"shoppingCart1\"]/div"));
		 act.dragAndDrop(source, Destination).perform();
		 
		 WebElement sourceAmount=driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
		 WebElement destinationAmount=driver.findElement(By.xpath("//*[@id=\"shoppingCart4\"]/div"));
		 act.dragAndDrop(sourceAmount,  destinationAmount).perform();
		 
		 WebElement sourceDebit=driver.findElement(By.xpath("//*[@id=\"credit1\"]"));
		 WebElement DestinationDebit=driver.findElement(By.xpath("//*[@id=\"shoppingCart3\"]/div"));
		 act.dragAndDrop(sourceDebit, DestinationDebit).perform();
		 
		 WebElement sourceDebitAmount=driver.findElement(By.xpath("//*[@id=\"fourth\"]"));
		 WebElement destinationDebitAmount=driver.findElement(By.xpath("//*[@id=\"amt8\"]"));
		 act.dragAndDrop(sourceDebitAmount,destinationDebitAmount).perform();
		 
		 WebElement element = driver.findElement(By.xpath("//*[@id=\"equal\"]"));
	        String actualText = element.getText();	        
	        String expectedText = "Perfect!";
	        if (actualText.equals(expectedText)) {
	            System.out.println("Text verification passed: Actual text is '" + actualText + "'.");
	        } else {
	            System.out.println("Text verification failed: Actual text is '" + actualText + "', but expected text is '" + expectedText + "'.");
	        }
		
	}
}
