package testngpkg;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestngGrouping {
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
	
	@Test(groups = {"smoke"})
	public void test1()
	{
		System.out.println("test1");
	}
	
	@Test(groups = {"smoke","sanity"})
	public void test2()
	{
		System.out.println("test2");
	}
	
	@Test(groups = {"sanity"})
	public void test3()
	{
		System.out.println("test3");
	}
	
	@Test(groups={"regression"})
	public void test4()
	{
		System.out.println("test4");
	}
	
	@Test(groups={"smoke","regression"})
	public void test5()
	{
		System.out.println("test5");
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
