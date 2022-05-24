package Wait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_example {

	public static void main(String[] args) throws Exception {
		//System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector(".cart-preview.active .action-block button")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".promoWrapper .promoBtn")).click();
		Thread.sleep(5000);
		System.out.println(driver.findElement(By.cssSelector(".promoWrapper .promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector(".wrapperTwo>div select"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("India");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		Thread.sleep(30000);
	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}
		}
	}

}
