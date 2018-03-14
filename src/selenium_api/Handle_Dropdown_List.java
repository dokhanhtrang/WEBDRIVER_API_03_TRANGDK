package selenium_api;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Handle_Dropdown_List {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Test01_HandleDropdownList() throws Exception {
		// Select using ID attribute
		Select select = new Select(driver.findElement(By.id("job1")));
		// Verify Dropdown doesn't support multi-select
		Assert.assertFalse(select.isMultiple());
		// Verify Dropdown has five options
		Assert.assertEquals(5, select.getOptions().size());
		// Select an option in Dropdown using visible text
		select.selectByVisibleText("Automation Tester");
		Assert.assertEquals("Automation Tester", select.getFirstSelectedOption().getText());
		Thread.sleep(4000);
		// Select an option in Dropdown using value attribute
		select.selectByValue("manual");
		Assert.assertEquals("Manual Tester", select.getFirstSelectedOption().getText());
		Thread.sleep(4000);
		// Select an option in Dropdown using index
		select.selectByIndex(3);
		Assert.assertEquals("Mobile Tester", select.getFirstSelectedOption().getText());
		Thread.sleep(4000);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}