package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic03_Browser_WebElementCommands_MultiBrowsers {
	// Create Global variables
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// Open driver
		driver = new FirefoxDriver();
		// Maximize browser fullscreen
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void StepforAll() {
		// open app
		driver.get("http://daominhdam.890m.com/");
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void TC01_CheckElementDisplay() {
		// WebElement Email = driver.findElement(By.xpath("//input[@id='mail']"));
		// Assert.assertTrue(Email.isDisplayed());
		// Email.sendKeys("Automation Testing");
		// WebElement Radio = driver.findElement(By.xpath("//input[@id='under_18']"));
		// Assert.assertTrue(Radio.isDisplayed());
		// Radio.click();
		// WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
		// Assert.assertTrue(Education.isDisplayed());
		// Education.sendKeys("Automation Testing");
		String Email = "//*[@id='mail']";
		if (isElementDisplayed(driver, Email)) {
			WebElement Email1 = driver.findElement(By.xpath("//input[@id='mail']"));
			Email1.sendKeys("Automation Testing");
		}
		String Radio = "//input[@id='under_18']";
		if (isElementDisplayed(driver, Radio)) {
			WebElement Radio1 = driver.findElement(By.xpath("//input[@id='under_18']"));
			Radio1.click();
		}
		String Education = "//textarea[@id='edu']";
		if (isElementDisplayed(driver, Education)) {
			WebElement Education1 = driver.findElement(By.xpath("//textarea[@id='edu']"));
			Education1.sendKeys("Automation Testing");
		}

	}

	private boolean isElementDisplayed(WebDriver driver2, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Test
	public void TC02_CheckElementEnable() {
	}

	@Test
	public void TC03_CheckElementIsSelected() {
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
