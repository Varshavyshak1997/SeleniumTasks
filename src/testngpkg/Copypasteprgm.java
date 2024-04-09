package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Copypasteprgm {
	WebDriver  driver;
	
	String baseUrl="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1()
	{
		WebElement fullName=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[3]/td[3]/input"));
		fullName.sendKeys("abc");
		WebElement redifid=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[1]"));
		Actions act=new Actions(driver);
		act.keyDown(fullName,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(fullName,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(redifid,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		act.perform();
	}
	
}
