package Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_wait_generic_method {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys("selenium");
		driver.findElement(By.cssSelector("input[title='Search']")).sendKeys(Keys.RETURN);

		By elelocator = By.xpath("//h3[text()='Selenium: Definition, How it works and Why you need it']");
		waitForElement(driver, elelocator).click();
		
		By elelocator1 = By.xpath("//a[text()='Start Automating for Free']");
		waitForElement(driver, elelocator1).click();
		
		driver.close();

	}

	public static WebElement waitForElement(WebDriver driver, final By locator) {

		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement element = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}

}
