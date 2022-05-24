import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Handling java script alrts
//1st-only ok button i.e +ve
//2nd-ok/cancel button i.e +ve/-ve
public class Demo14_alert {

	public static void main(String[] args) {
		String name1 = "Siku";
		String name2 = "Riku";
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");// Path of chrome
																									// driver
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		// 1st alert
		driver.findElement(By.id("name")).sendKeys(name1);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();// Clicking ok
		// 2nd alert
		driver.findElement(By.id("name")).sendKeys(name2);
		driver.findElement(By.id("confirmbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();// Clicking cancel
	}

}
