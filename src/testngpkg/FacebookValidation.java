package testngpkg;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FacebookValidation {
    ChromeDriver driver;
    String baseurl = "https://rishiherbalindia.linker.store/";

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void urlLoading() {
        driver.get(baseurl);
        System.out.println("URL loading");
    }

//    @Test
//    public void fbtitleverification() throws IOException {
//        String Exp = "Facebook – log in or sign up";
//        String actual = driver.getTitle();
//        Assert.assertEquals(actual, Exp);
//        System.out.println(actual);
//        System.out.println("hello");
//    }
//
//    @Test
//    public void fbbuttontest() throws IOException {
//        String buttontext = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).getText();
//        Assert.assertEquals(buttontext, "Log in");
//        System.out.println("Button test: " + buttontext);
//    }
//
//    @Test
//    public void fblogotest() throws IOException {
//        boolean b = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"))
//                           .isDisplayed();
//        Assert.assertTrue(b);
//    }
//
//    @Test
//    public void fbbuttonEnabled() throws IOException {
//        boolean button = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button"))
//                                 .isEnabled();
//        Assert.assertTrue(button);
//    }
    @Test
    public void test() throws Exception
    {
    	driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div[1]/div[2]/div/ul/li[1]/a/span")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("/html/body/div/header/div/div/div/div[1]/div[2]/div/ul/li[1]/ul/li[2]/a")).click();
    }

//    @AfterTest
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }

}
