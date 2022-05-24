import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//Handling Static dropdowns with Select webdriver API
public class Demo6_static_dropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");// Path of chrome
																									// driver
		WebDriver driver = new ChromeDriver();
		driver.get("http://3.110.88.201/dropdownsPractise/");
		// static dropdown-->select tag
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(3);// Select the options inside dropdown by index(starts from 0).
		System.out.println(dropdown.getFirstSelectedOption().getText());// getFirstSelectedOption-->selects the 1st
																		// option.

		dropdown.selectByVisibleText("AED");// Select the options inside dropdown by visible texts.
		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByValue("INR");// Select the options inside dropdown by value tag.
		System.out.println(dropdown.getFirstSelectedOption().getText());
	}

}
