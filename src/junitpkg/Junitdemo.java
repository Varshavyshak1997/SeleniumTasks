package junitpkg;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Junitdemo {
	ChromeDriver driver;
	String baseurl="https://www.google.com";
	
	@Before 
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void titleverification()
	{
		String actualtitle=driver.getTitle();
		String exp="Google";
		if(actualtitle.equals(exp))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
	}
	
	@Test
	public void contentverification()
	{
		String src=driver.getPageSource();
		
		if(src.contains("Gmail"))
		{
			System.out.println("Contain gmail text");
		}
		else
		{
			System.out.println("Not contain gmail text");
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
}
