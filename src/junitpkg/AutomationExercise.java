package junitpkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertNotNull;

public class AutomationExercise {
	ChromeDriver driver;
	String url="https://automationexercise.com/login";
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(url);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void siteTitleVerify()
	{
		String actualText=driver.getTitle();
		String expectedText="Automation Exercise - Signup / Login";
		
		if(actualText.equals(expectedText))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	@Test
	public void linkCOunt()
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links= "+links.size());
	}
	
	@Test
	public void signupTextVerify()
	{
		WebElement text=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
		//assertNotNull("Element is not present", text);
		 if(text != null) {
		        System.out.println("Element is present");
		    } else {
		        System.out.println("Element is not present");
		    }
	}
	
	@Test
	public void verifyButtonText()
	{
		WebElement button=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		String buttonText=button.getText();
		String expectedText="Signup";
		
		if(buttonText.equals(expectedText))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	@Test
	public void buttonEnable()
	{
		WebElement button=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
		if(button.isEnabled()) {
	        System.out.println("Signup button is enabled");
	    } else {
	        System.out.println("Signup button is disabled");
	    }
	}

}
