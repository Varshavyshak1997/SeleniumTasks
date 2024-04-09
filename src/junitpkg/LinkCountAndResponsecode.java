package junitpkg;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkCountAndResponsecode {
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
		        String linkUrl = link.getAttribute("href");
		        verify(linkUrl);
		        
		        
		    }
	}

	private void verify(String linkUrl) {
		try {
			URL obj=new URL(linkUrl);
			HttpURLConnection conn=(HttpURLConnection) obj.openConnection();
			conn.connect();
			
			if(conn.getResponseCode()==200)
			{
				System.out.println(linkUrl+"--------Response code is 200");
				System.out.println("-----------------------------");
			}
			else if(conn.getResponseCode()==400)
			{
				System.out.println(linkUrl+"--------Response code is 400");
				System.out.println("-----------------------------");
			}
		}
		catch(Exception e)
		{
			System.out.println("null");
		}
		
	}
}
