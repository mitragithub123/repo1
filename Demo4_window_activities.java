//Automate Browser navigations and window properties with Selenium Webdriver.
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo4_window_activities {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
        WebDriver driver= new ChromeDriver();
        
        driver.manage().window().maximize();//Maximize the window.
        driver.get("https://www.google.com");//Selenium will wait until the webpage is fully loaded.
        driver.navigate().to("https://www.rahulshettyacademy.com/");//Selenium will not wait till the webpage is fully loaded.
        driver.navigate().back();//Moving back to previous page.
        driver.navigate().forward();//Moving to forward page.
        driver.close();

	}

}
