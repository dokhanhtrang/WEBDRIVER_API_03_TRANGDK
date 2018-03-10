package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test
public class Check_Environment {
	// Create global variables
	WebDriver driver;

	// Pre Condition
	@BeforeClass
	public void beforeClass() {
		// Open driver
		driver = new FirefoxDriver();
		// Open app
		driver.get("https://www.facebook.com");
		// Wait page load successfully
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();
	}

	// Action&Verify
	public void TC_01() {
			//Verify title homepage
			String HomepageTitle = driver.getTitle();
			//Verify title with with expected title
			Assert.assertEquals(HomepageTitle, "Facebook - Đăng nhập hoặc đăng ký");
		}

	// Clean Data
	@AfterClass

	public void afterClass() {
		//close browser
		driver.quit();
	}

}
