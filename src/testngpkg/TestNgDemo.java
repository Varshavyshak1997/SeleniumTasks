package testngpkg;

//import org.junit.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo {

	@BeforeTest
	public void setUp()
	{
		
		System.out.println("beforetest");
	}
	
	@BeforeMethod
	public void urlLoading()
	{
		System.out.println("url loading");
	}
	
	@Test(priority = 2,enabled=false)
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test(priority = 1,dependsOnMethods = {"test3"})
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(groups= {"smoke"})
	public void test3()
	{
		System.out.println("test3");
	}
	
	@AfterMethod
	public void aftermethod()
	{
		System.out.println("aftermethod");
	}
	
	@AfterTest
	public void aftertest()
	{
		System.out.println("afterTest");
	}
	
}
