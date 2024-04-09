package testpkg;



import org.testng.annotations.Test;

import pagepkg.FbCreatePage;
import pagepkg.FbLoginPage;

public class FbLoginTest extends BaseClass 
{
	@Test
	public void test()
	{
		FbLoginPage obj=new FbLoginPage(driver);
		obj.setValues("abc@gmail.com", "abc1997");
		obj.loginClick();
	}
	
	@Test
	public void test1() throws Exception
	{
		FbCreatePage ob=new FbCreatePage (driver);
		ob.forgotPassword();
		ob.signUpPage();
	}
}
