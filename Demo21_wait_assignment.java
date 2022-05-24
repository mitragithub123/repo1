import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo21_wait_assignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String[] itemNeeded = { "iphone", "iphone", "Nokia" };
		driver.get("https://rahulshettyacademy.com/angularpractice/shop/");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> buttons = driver.findElements(By.cssSelector(".btn.btn-info"));
		for (int i = 0; i < buttons.size() - 1; i++) {
			buttons.get(i).click();
		}

	}

}
