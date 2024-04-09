package testngpkg;


import java.io.File;




import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendedReports {
	WebDriver driver;
	String baseurl="https://www.facebook.com";
	ExtentHtmlReporter reporter; //html look and feel
	ExtentTest test;//class for updation
	ExtentReports extent;//enter entries
	
	@BeforeTest
	public void beforetest()
	{
		reporter=new ExtentHtmlReporter("./Reports/myreport.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Funcitonal test");
		reporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("hostname", "localhost");
		extent.setSystemInfo("os", "windows11");
		extent.setSystemInfo("testername", "abc");
		extent.setSystemInfo("Browser Name", "Chrome");
		driver=new ChromeDriver();
		
	}
	
	@BeforeMethod
	public void setup()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void fbtitleverification() throws IOException
	{
		
		test=extent.createTest("Fbtitleverification");
		String Exp="Facebook – log in or sign upddd";
		String actual=driver.getTitle();
		Assert.assertEquals(Exp, actual);
		System.out.println(actual);
		System.out.println("hello");
			
	}
		
	
	@Test
	public void fbbuttontest() throws IOException
	{
		test=extent.createTest("Fbbuttontest");
		String buttontext=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).getText();
		Assert.assertEquals(buttontext, "Log in");
		System.out.println("Button test"+buttontext);
		
	}
	
	
	@Test
	public void fblogotest() throws IOException
	{
		test=extent.createTest("Fblogotest");
		boolean b=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).isDisplayed();
		Assert.assertTrue(b);	
	}
	
	@Test
	public void fbbuttonEnabled() throws IOException
	{
		test=extent.createTest("Fbbuttontest");
		boolean button=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).isEnabled();
		Assert.assertTrue(button);
		
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
		    
		       // if (driver != null) {
		          //  driver.quit();
		        //}
		    
	}
	
	
			@AfterMethod
			public void browserclose(ITestResult result) throws IOException
			{
	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case failed is"+result.getName());
			test.log(Status.FAIL, "test case failed is"+result.getThrowable());
			String screenshotpath=ExtendedReports.screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);

			
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, "test case skipped is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "test case Passed is"+result.getName());
		}
		 
	}	
			
			public static String screenshotMethod(WebDriver driver,String screenshotname) throws IOException
			{
				File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				String destination="./Screenshots/"+screenshotname +".png";
				//File finaldestination=new File(destination);
				//FileHandler.copy(src, finaldestination);
				FileHandler.copy(src, new File(destination));
		
				return destination;
			}

}
