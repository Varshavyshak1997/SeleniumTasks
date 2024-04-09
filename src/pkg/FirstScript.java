package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) {
		//chromedriver-chrome
		//edgedriver-edge
		//firefoxdriver-firefox
		
		ChromeDriver driver=new ChromeDriver(); //chromedriver is a class it define many mehtods
		driver.get("https://www.google.com"); //load application -by loading url use get method
		//check the title of url
		//for getting title getatitle
		String actualtitle=driver.getTitle();
		String exp="google";
		if(actualtitle.equalsIgnoreCase(exp))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		

	}

}
