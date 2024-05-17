package BeforeTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BeforeTestt {
public static WebDriver driver;

	@BeforeTest
	public void setUpDriver() {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("--disable-notification");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(o);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	}
	
	@AfterTest
	public void afterrclass() {
		driver.quit();
	}
}
