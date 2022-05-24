import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Demo3_login {

	public static void main(String[] args) throws InterruptedException {
		String name="siku";
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit wait of 5s
        
        
        String orgPassword=getPassword(driver);
        
        driver.get("https://www.rahulshettyacademy.com/locatorspractice/");
        driver.manage().window().maximize();//Maximize the window
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys(orgPassword);
        driver.findElement(By.id("chkboxTwo")).click();
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.cssSelector(".login-container p")).getText(), "You are successfully logged in.");
        Assert.assertEquals(driver.findElement(By.cssSelector(".login-container h2")).getText(), "Hello "+name+",");
        driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        Thread.sleep(2000);
        driver.close();
	}
	
	//Parse the String with Java methods to get the password(e.g rahulshettyacademy) dynamically from the page.
	public  static String getPassword(WebDriver driver) throws InterruptedException {
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText =driver.findElement(By.cssSelector("form p")).getText();
		//passwordText-->Please use temporary password 'rahulshettyacademy' to Login.
		String[] passwordArray1=passwordText.split("'");//0th index-->Please use temporary password '//1st index-->rahulshettyacademy' to Login.
		String[] passwordArray2=passwordArray1[1].split("'");
		String orgPassword=passwordArray2[0];
		return orgPassword;
	}
	

}
