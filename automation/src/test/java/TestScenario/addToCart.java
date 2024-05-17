package TestScenario;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class addToCart extends BeforeTest.BeforeTestt{
	
	@Test(priority = 1)
	public void doaddToCart() throws InterruptedException {
		addToCart a= new addToCart();
		String firstItemxpath = "//img[@alt='BULLMER Tribal Printed Oversized Cotton T-shirt']";
		a.testAddToCartFlow(firstItemxpath);
	}
	
	@Test(priority = 2)
	public void doaddToCartitem2() throws InterruptedException {
		addToCart a= new addToCart();
		String Seconditemxpath = "//img[@alt='Stormborn Graphic Printed Drop Shoulder Sleeves Pure Cotton Oversized T-shirt']";
		a.testAddToCartFlow(Seconditemxpath);
	}

	
	public void testAddToCartFlow(String shop1xpath) throws InterruptedException {
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Mens Tshirt");
		driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconSearch sprites-search']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(shop1xpath)).click();
		Thread.sleep(2000);
		
		Set<String> wi = driver.getWindowHandles();
		Iterator<String> it = wi.iterator();
		
		String WID = driver.getWindowHandle();
		driver.switchTo().window(WID);
		
		String fw = it.next();
		String sw = it.next();
		driver.switchTo().window(sw);
		
		//to assert you landed on info page for tshirt
		
		
		  String actualTiltle = "Tribal Printed Oversized Cotton T-shirt";
		  Thread.sleep(10000); String expectedTitle = driver.findElement(By.
		  xpath("//h1[text()='Tribal Printed Oversized Cotton T-shirt']")).getText();
		  Assert.assertEquals(actualTiltle, expectedTitle);
		 
		 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='WISHLIST']")).click();
		driver.findElement(By.xpath("//input[@class='form-control mobileNumberInput']")).sendKeys("8805692201");
		driver.findElement(By.xpath("//div[text()='CONTINUE']")).click();
		
		driver.findElement(By.xpath("//span[text()='Profile']")).click();
		
		WebElement a = driver.findElement(By.xpath("//div[@class='desktop-getInLinks']"));
		Actions act = new Actions(driver);
		act.moveToElement(a);
		
		
		driver.findElement(By.xpath("//div[text()=' Logout ']")).click();		
		
	}
	
}
