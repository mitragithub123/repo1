
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Add cart
//Sending array of multiple products to cart for checkout dynamically.
public class Demo17_add_cart_multiple {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemNeeded = {"Cucumber - 1 Kg", "Brocolli - 1 Kg" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getText();
			// Check whether the name you extracted is present in array list or not.
			// Convert declared array to array list.
			List itemNeededList = Arrays.asList(itemNeeded);
			if (itemNeededList.contains(name)) {

				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				//Here we are not using break statement.
				//As we found Brocolli 1st then break statement will stops the execution.
				//As a result cucumber will not found.
				

			}
		}

	}

	
}
