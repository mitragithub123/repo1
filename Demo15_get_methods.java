import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//get()
//getTitle()
//getUrl()
//getAttribute()
//getTagName()
public class Demo15_get_methods {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();// Maximize the window
		driver.get("https://www.facebook.com/");// URL of Webpage
		String title = driver.getTitle();// Title of web page
		System.out.println("Title is : " + title);
		System.out.println("Current URL is : " + driver.getCurrentUrl());// Get URL of web page
		System.out.println("Attribute is : " + driver.findElement(By.id("email")).getAttribute("id"));// Attr
		System.out.println("Tag name is : " + driver.findElement(By.id("email")).getTagName());// Tag name
		driver.close();
	}

}
