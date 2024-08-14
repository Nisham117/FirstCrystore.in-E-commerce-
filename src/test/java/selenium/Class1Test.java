package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class1Test {

	String driverPath = "D:\\seleniumZip\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	WebDriver driver= new ChromeDriver();
	
	@BeforeTest
	void navigate() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void login() throws InterruptedException {
		Thread.sleep(2000);
		WebElement un=driver.findElement(By.xpath("//input[@name=\"username\"]"));
		un.sendKeys("Admin");
		
		WebElement ps=driver.findElement(By.xpath("//input[@type=\"password\"]"));
		ps.sendKeys("admin123");
	}
	@Test(priority=2)
	void button() {
		//WebElement log=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		//log.click();
	}
	@Test(priority=3)
	void buzz() {
		
		//driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Buzz']")).click();
		
		WebElement buzz=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Buzz']"));

        // Use JavaScript to identify overlapping elements
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].scrollIntoView(true);", buzz);
        buzz.click();
	}
	@Test(priority=4)       //@Test(priority=4 ,enabled=false)  // for skip
	void post() {
		//WebElement log=driver.findElement(By.xpath("//button[@type=\"submit\"]"));
		driver.findElement(By.xpath("//textarea[@placeholder=\"What's on your mind?\"]")).sendKeys("Nisha Maurya");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//log.click();
	}
	@AfterTest
	 void close() {
		 driver.quit();
	 }


}
