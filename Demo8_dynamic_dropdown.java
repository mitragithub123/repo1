import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Dynamic Dropdown(Using indexing and Parent-child relationship locator)
public class Demo8_dynamic_dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");//Path of chrome driver
        WebDriver driver= new ChromeDriver();
        driver.get("http://3.110.88.201/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
        Thread.sleep(2000);
        //Use index in xpath when multiple elements are matching.
        //And when errors in console shows(in xpath), no elements are visible.
        //driver.findElement(By.xpath("(//a[text()=' Delhi (DEL)'])[2]")).click();//As 2 elements are matching.
        //Some clients are not comfortable with indexing. In that case use parent-child relationship locator.
        //Parent-child relationship locator-->Construct a unique xpath for parent and same for child, then give a space in between them.
        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='DEL']")).click();

	}

}
