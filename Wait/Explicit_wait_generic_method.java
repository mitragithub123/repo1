package Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Explicit_wait_generic_method {

	public static void main(String[] args) {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);//hit enter

		By elelocator = By.xpath("//h3[text()='Selenium: Definition, How it works and Why you need it']");
		waitForElement(driver, elelocator, 5).click();
		
		By elelocator1 = By.cssSelector("section .btn.btn-sm.btn-primary.btn-md");
		waitForElement(driver, elelocator1, 5).click();

		driver.close();

	}

	public static WebElement waitForElement(WebDriver driver, By locator, int timeout) {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}

}
