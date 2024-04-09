package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class Contentverification {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();//chromedriver is a class it define many mehtods
		driver.get("https://www.google.com"); 
	
		String src=driver.getPageSource();
		
		if(src.contains("Gmail"))
		{
			System.out.println("Contain gmail text");
		}
		else
		{
			System.out.println("Not contain gmail text");
		}

	}

}
