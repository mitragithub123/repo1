import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo1_locators_practice {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit wait of 5s
        driver.get("https://sso.teachable.com/secure/9521/identity/login/password");
        driver.manage().window().maximize();//Maximize the window
        driver.findElement(By.id("email")).sendKeys("aryaaish.2011@gmail.com");//Targeting the input field
        driver.findElement(By.id("password")).sendKeys("mitra@1234");//Targeting the password field
        driver.findElement(By.name("commit")).click();//Clicking the button
        System.out.println(driver.findElement(By.cssSelector("div.bodySmall")).getText());//Catching and printing the error message in console. 
        driver.findElement(By.cssSelector("div a.bodySmall")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mitrabhanuprusty@yahoo.co.in");
        driver.findElement(By.cssSelector("input[name='email']")).clear();//Clearing the input data
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        
        
        //driver.close();
	}

}
