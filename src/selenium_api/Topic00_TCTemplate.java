package selenium_api;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Topic00_TCTemplate {
	// Create Global variables
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// Open driver
		driver = new FirefoxDriver();
		// open app
		driver.get("");
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();

	}

	@Test
	public void TC01() {
	}

	@Test
	public void TC02() {
	}

	@Test
	public void TC03() {
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
