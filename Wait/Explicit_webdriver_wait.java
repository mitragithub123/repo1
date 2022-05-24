package Wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_webdriver_wait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);
		
		WebElement element=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Selenium: Definition, How it works and Why you need it']")));
		
		element.click();
		
		driver.close();
	}
	
}
