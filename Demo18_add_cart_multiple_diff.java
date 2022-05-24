//See bottom of this program for fixation
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Add cart
//Sending array of multiple products to cart for checkout dynamically.
//Requirement is test lead says 
//You can not use String[] itemNeeded = { "Brocolli - 1 Kg", "Cucumber - 1 Kg" };
//Instead of this use Brocolli and Cucumber.
//Logic is split the string using -
//Trim white space.
public class Demo18_add_cart_multiple_diff {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String[] itemNeeded = { "Brocolli - 1 Kg", "Cucumber - 1 Kg" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName=name[0].trim();
			// Check whether the name you extracted is present in array list or not.
			// Convert declared array to array list.
			List itemNeededList = Arrays.asList(itemNeeded);
			
			if (itemNeededList.contains(formattedName)) {
				
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				//Here we are not using break statement.
				//As we found Brocolli 1st then break statement will stops the execution.
				//As a result cucumber will not found.

			}
		}

	}

}
//To fix the error
//Line no 23: String[] itemsNeeded = { "Cucumber", "Brocolli"};
//Line no 36: driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
