package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbLoginPage {

		WebDriver driver;
		By fbEmail=By.id("email");
		By fbPassword=By.id("pass");
		By fbLoginButton=By.name("login");
		
		public FbLoginPage(WebDriver driver)
		{
			this.driver=driver;
			System.out.println(driver);
		}
		
		public void setValues(String email,String pass)
		{
			driver.findElement(fbEmail).sendKeys(email);
			driver.findElement(fbPassword).sendKeys(pass);
		}
		
		public void loginClick()
		{
			driver.findElement(fbLoginButton).click();
		}
}
