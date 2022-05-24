import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Auto suggestive dropdown
/* 1. Target the dropdown by inspecting
2. Type some text in the dropdown and inpect 1 option
3. Target all options combined(find elements)and store in a loop and get text
4. Inside a if loop-if the typed text equals shown result then click it and break.*/
public class Demo9_auto_suggestive_dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");// Path of chrome
																									// driver
		WebDriver driver = new ChromeDriver();
		driver.get("http://3.110.88.201/dropdownsPractise/");
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("ul.ui-autocomplete li.ui-menu-item a"));
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("india")) {
				option.click();
				break;
			}
		}
	}

}
