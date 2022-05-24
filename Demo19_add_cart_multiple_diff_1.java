//See bottom of this program for fixation
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo19_add_cart_multiple_diff_1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		int j = 0;
		String[] itemNeeded = { "Brocolli - 1 Kg", "Cucumber - 1 Kg", "Beetroot - 1 Kg" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(3000);
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// Check whether the name you extracted is present in array list or not.
			// Convert declared array to array list.
			List itemNeededList = Arrays.asList(itemNeeded);

			if (itemNeededList.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();//Here dynamic button. So do not use this. That is why test is failing.
				// TL asks why no break statement
				// Here we are not using break statement because,.
				// As we found Brocolli 1st then break statement will stops the execution.
				// As a result cucumber will not found.
				// But TL asks loop will run 30 times.Use break
				// Then we can see in the web page Brocolli and Cucumber are in 1st row
				// Declare a var, intitialize to 0, make a loop, then break it till 2
				if (j==itemNeeded.length)//if(j==2)
					break;

			}
		}

	}

}


//To fix the error
//Line no 17: String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot" };
//Line no 30: driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();