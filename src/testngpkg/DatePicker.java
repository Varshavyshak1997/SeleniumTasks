package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DatePicker {
	WebDriver  driver;
	
	String baseUrl="https://www.goibibo.com/flights/?utm_source=google&utm_medium=cpc&utm_campaign=DF-Brand-EM&utm_adgroup=Only%20Goibibo&utm_term=!SEM!DF!G!Brand!RSA!108599293!6504095653!617695092667!e!goibibo!c!&gad_source=1&gclid=Cj0KCQjwncWvBhD_ARIsAEb2HW9A68IKewgAss574JW_OSMpi_FcdAKYc4cEcFoGa9x7mCXajxDAinoaAt5XEALw_wcB";
	
	@BeforeMethod
	public void urlOpen()
	{
		driver=new ChromeDriver();
		driver.get(baseUrl);
		//driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.navigate().refresh();
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]")).click();
		
		while(true)
		{
			WebElement month=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]"));
			String monthtext=month.getText();//month and year
			System.out.println("month selected is" +monthtext);
			if(monthtext.equals("July 2024"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
			}
		}
		List<WebElement> li=driver.findElements(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/p"));
		for(WebElement ele :li)
		{
			String date= ele.getText();
			if(date.equals("20"))
			{
				ele.click();

			}
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
		
	}
	
	
}
