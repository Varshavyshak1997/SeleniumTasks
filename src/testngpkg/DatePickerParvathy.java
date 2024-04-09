package testngpkg;

import org.openqa.selenium.WebDriver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DatePickerParvathy {
	String URL="https://www.goibibo.com/";
	WebDriver driver;

	@BeforeTest

	public void SetUp() throws InterruptedException
	{
	driver=new ChromeDriver();
	driver.get(URL);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.navigate().refresh();
	}

	@Test
	public void Testing() throws InterruptedException
	{

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div")).click();
	Thread.sleep(3000);
	//driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).;
	while(true) {
	WebElement monthyear= driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]"));
	////*[@id="root"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div
	String month=monthyear.getText();
	System.out.println(month);
	if(month.equals("August 2024")) {
	break;
	}
	else {

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
	Thread.sleep(1000);
	}
	}
	System.out.println("Mentioning dates");

	List<WebElement> li=driver.findElements(By.xpath("/html/body/div/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div[5]/div[5]/p"));
	for(WebElement ele:li)
	{
	String date=ele.getText();
	System.out.println(date);

	if(date.equals("29")) {
	System.out.println("date verification is correct");
	Thread.sleep(1000);
	ele.click();
	break;
	// Thread.sleep(1000);
	}
	}
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
	//driver.findElement(By.xpath("////*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[3]/span[1]")).click();

	}

}
