package firstCry;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class DiapersModule {

	String driverPath = "D:\\seleniumZip\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
	WebDriver driver= new ChromeDriver();
	Actions a=new Actions(driver);
	
	@BeforeTest
	void navigate() {
		driver.get("https://firstcrystore.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test(priority=1)
	void account() {
		
		driver.findElement(By.xpath("//span[normalize-space()='Account']")).click();
	}
	
	@Test(priority=2)
	void login() throws InterruptedException {
		Thread.sleep(2000);
		WebElement em=driver.findElement(By.xpath("//input[@name='email']"));
		em.sendKeys("nishim345@gmail.com");
		
		WebElement ps=driver.findElement(By.xpath("//input[@name='password']"));
		ps.sendKeys("nishim");
		
	}
	
	@Test(priority=3)
	void button(){
	WebElement signin=driver.findElement(By.xpath("//button[@type='submit']"));
		// Use JavaScript to identify overlapping elements
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        js.executeScript("arguments[0].scrollIntoView(true);", signin);
        signin.click();
        
//        Alert a=driver.switchTo().alert();
//		//Thread.sleep(1000); // for hold the alert message.
//		a.accept();
        
        try {
            // Wait explicitly for the alert to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.alertIsPresent());

            // Switch to the alert
            Alert alert = driver.switchTo().alert();

            // Get the text of the alert (Optional)
            String alertText = alert.getText();
            System.out.println("Alert text: " + alertText);

            // Accept the alert (Click OK)
            alert.accept();
            System.out.println("Alert accepted.");

        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
		
	}
	

	@Test(priority=4)
	void diapersSection(){
		WebElement ts=driver.findElement(By.xpath("//div[@class='categories-container']//div[3]"));
		a.moveToElement(ts).perform();
	}
	
	@Test(priority=5)
		void xxxlDiapers(){
			WebElement XD=driver.findElement(By.xpath("//li[normalize-space()='xxxl Diapers']"));
			a.moveToElement(XD).click();
//			Thread.sleep(1000);
//			WebElement addCart=driver.findElement(By.xpath("//button[@class='btn cart-btn ripple-surface']"));
//			addCart.click();
			
            }
	
	@Test(priority=6)
	void mamyPokoPants(){
		WebElement Mppx=driver.findElement(By.xpath("//li[normalize-space()='Mamy Poko Pants xxxl']"));
		a.moveToElement(Mppx).click();

        }

}
