import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

//Click a check box and count the total no of check boxes and same for radio buttons
//Calender-select the present date
public class Demo10_checkbox {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");// Path of chrome
																									// driver
		WebDriver driver = new ChromeDriver();
		driver.get("http://3.110.88.201/dropdownsPractise/");

		// Assert.assertFalse(False) then test will pass else fail.
		Assert.assertFalse(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());

		driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).click();

		// Assert.assertTrue(True) then test will pass else fail.
		Assert.assertTrue(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());
		System.out.println(driver.findElement(By.cssSelector("input[name*='friendsandfamily']")).isSelected());

		// Count the total no of check boxes using size of-->Find a common locator for
		// all check boxes
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		// Radio buttons
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());// Returns false
		System.out.println(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());// Prints false
		driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());// Returns true
		System.out.println(driver.findElement(By.cssSelector("input[id*='Trip_1']")).isSelected());// Prints false
		System.out.println(driver.findElements(By.cssSelector("input[type='radio']")).size());// Count the total no of
																								// radio buttons.

		// Calender-select the present date
		driver.findElement(By.cssSelector("input[name*='date1']")).click();
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
	}

}
