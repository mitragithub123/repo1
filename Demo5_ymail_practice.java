import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo5_ymail_practice {
	static{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
		}

	public static void main(String[] args) throws InterruptedException {
		  WebDriver driver= new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
          driver.manage().window().maximize();
          driver.get("https://login.yahoo.com/?.intl=in&.lang=en-IN&src=ym&activity=mail-direct&pspid=159600001&done=https%3A%2F%2Fin.mail.yahoo.com%2Fd&add=1");
          
          WebElement username=driver.findElement(By.id("login-username"));
          username.sendKeys("mitrabhanuprusty@yahoo.co.in");
          
          driver.findElement(By.id("login-signin")).click();
         
          WebElement password=driver.findElement(By.xpath("//button[@type='submit']"));
          password.sendKeys("mitra@1234");
          
          driver.findElement(By.id("login-signin")).click();
         
          /*WebElement search_link=driver.findElement(By.linkText(" SEARCH"));
          search_link.click();
          WebElement search=driver.findElement(By.className("select-input"));
          search.sendKeys("mitrabhanuprusty@yahoo.co.in");
          driver.close();
          WebElement loginf=driver.findElement(By.name("login"));
          loginf.click();*/
          driver.close();
          

	}

}
