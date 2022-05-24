package Wait;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Implicit_wait {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));// implicit wait
		
		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		addItems(driver, itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.cssSelector(".cart-preview.active .action-block button")).click();
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		
		driver.findElement(By.cssSelector(".promoWrapper .promoBtn")).click();
		
		System.out.println(driver.findElement(By.cssSelector(".promoWrapper .promoInfo")).getText());
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement staticDropdown = driver.findElement(By.cssSelector(".wrapperTwo>div select"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByVisibleText("India");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		
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
