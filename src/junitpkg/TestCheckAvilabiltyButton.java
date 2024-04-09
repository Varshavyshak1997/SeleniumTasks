package junitpkg;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCheckAvilabiltyButton {
	ChromeDriver driver;
	String url="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@Before
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void buttonTextVerify()
	{
		WebElement path=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]"));
		String ButtonText = path.getAttribute("value");
		if(ButtonText.equals("Check availability"))
		{
			System.out.println("Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
	}

	
}
