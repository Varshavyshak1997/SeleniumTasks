package junitpkg;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkcount {
	
	ChromeDriver driver;
	String baseUrl="https://www.google.in";
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void linkCOuntTest()
	{
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("Total number of links= "+links.size());
		//print link text and print the links
		 for (WebElement link : links) {
		    
		        //String linkText = link.getText().trim();
			 	String linkText = link.getText();
		        String linkUrl = link.getAttribute("href");
		        
		        System.out.println("Link Text: " + linkText);
		        System.out.println("URL: " + linkUrl);
		        System.out.println("-----------------------------");
		    }
	}
}
