package firstCry;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Registration {

	String driverPath = "D:\\seleniumZip\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	WebDriver driver= new ChromeDriver();
	
	@BeforeTest
	void navigate() {
		driver.get("https://firstcrystore.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void account() {
		
		driver.findElement(By.xpath("//span[normalize-space()='Account']")).click();
		
		driver.findElement(By.xpath("//a[normalize-space()='Create Account']")).click();
		
		
	}
	
	@Test(priority=2)
	void registration() throws InterruptedException {
		Thread.sleep(2000);
		WebElement fn=driver.findElement(By.xpath("//input[@name='firstname']"));
		fn.sendKeys("Vivek");
		
		WebElement ls=driver.findElement(By.xpath("//input[@name='lastname']"));
		ls.sendKeys("Maurya");
		
		WebElement em=driver.findElement(By.xpath("//input[@name='email']"));
		em.sendKeys("vivek345@gmail.com");
		
		WebElement ps=driver.findElement(By.xpath("//input[@name='password']"));
		ps.sendKeys("vivek123");
		
		WebElement conps=driver.findElement(By.xpath("//input[@name='confirmpassword']"));
		conps.sendKeys("vivek123");
		
	}
	
	@Test(priority=3)
	void button() throws InterruptedException {
		//Thread.sleep(1000);
		//driver.findElement(By.xpath("//button[@type='submit']")).click(); // not working
		
		// OR
		
	   WebElement signup=driver.findElement(By.xpath("//button[@type='submit']"));
		// Use JavaScript to identify overlapping elements
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        //js.executeScript("arguments[0].scrollIntoView(true);", signup); // OR
        js.executeScript("arguments[0].click();", signup);
       // signup.click();
        
        
     // Wait until the button is clickable
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='SIGN IN']")));
//
//        // Click the button
//        signInButton.click();
		
	}
	
	
//	@AfterTest
//	 void close() {
//		 driver.quit();
//	 }
//	
	
	
}
