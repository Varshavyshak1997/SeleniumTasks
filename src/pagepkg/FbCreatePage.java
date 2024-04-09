package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FbCreatePage {
	WebDriver driver;
	By signUpButton=By.xpath("//*[@id=\"login_link\"]/a[2]");
	By forgotPass=By.xpath("//*[@id=\"login_link\"]/div/a");
	By cancelButton=By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div/div/form/div/div[3]/div/div[1]/a");
	By tryAnotherWay=By.xpath("//*[@id=\"loginform\"]/div[4]/a");
	
	public FbCreatePage(WebDriver driver)
	{
		this.driver=driver;
		System.out.println(driver);
	}
	
	public void forgotPassword() throws Exception 
	{
		driver.findElement(forgotPass).click();
		driver.findElement(tryAnotherWay).click();
		driver.findElement(cancelButton).click();
		Thread.sleep(3000);
	}
	
	public void signUpPage()
	{
		driver.findElement(signUpButton).click();
	}
}
