import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Add cart
//Sending array of products to cart for checkout dynamically.
public class Demo16_add_cart {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			if (name.contains("Cucumber")) {

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				break;
				//Here we are using break statement.
				//As we found Brocolli and cucumber then why the loop will run 30 times(check page).

			}
		}
	}

}
