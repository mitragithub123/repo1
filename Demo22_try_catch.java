import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo22_try_catch {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		
		try {
			driver.findElement(By.id("demo-fake"));
		}
		catch(Exception e) {
			System.out.println("No such element exception generated");
			System.out.println("Hello, user ignore this exception");
			//throw e;  //if you want to throw the exception
		}
		driver.close();
		
	}

}
