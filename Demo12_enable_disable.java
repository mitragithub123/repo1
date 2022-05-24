import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



//To check whether an web element is enabled or disabled.
//isEnabled() and isDisabled() methods may or may not work in some cases.
//So, here we will resolve this with an different approach.

public class Demo12_enable_disable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
        
		//WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
        driver.get("http://3.110.88.201/dropdownsPractise/");
        driver.findElement(By.cssSelector("input[id*='Trip_1']")).click();
        /*After clicking on the round trip button, the style attribute(display: block; opacity: 0.5;)
        is changing to style attribute(display: block; opacity: 1;)*/
        //So target that element.
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));//display: block; opacity: 1;
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {//or, contains("display: block; opacity: 1;")
        	System.out.println("It is enabled");
        	Assert.assertTrue(true);
        }
        else {
        	System.out.println("It is disabled");
        	Assert.assertTrue(false);
        }

	}

}
