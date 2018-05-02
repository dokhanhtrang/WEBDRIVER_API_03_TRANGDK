package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest {
	// create global var
	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_Move_Mouse_To_Element() throws Exception {
		driver.get("http://daominhdam.890m.com/");
		WebElement text = driver.findElement(By.xpath("//a[contains(.,'Hover over me')]"));
		Actions buider = new Actions(driver);
		buider.moveToElement(text).perform();
		WebElement tooltip = driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
		Assert.assertTrue(tooltip.isDisplayed());
		String note1 = tooltip.getText();
		Assert.assertEquals("Hooray!", note1);
		System.out.println("Tooltip:Horray is display");
		Thread.sleep(2000);
		driver.get("http://www.myntra.com/");
		WebElement user = driver
				.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite desktop-iconUser sprites-user')]"));
		Actions buider1 = new Actions(driver);
		buider1.moveToElement(user).perform();
		driver.findElement(By.xpath("//a[@data-track='login']")).click();
		Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='mountRoot']//div[@class='login-box']")).isDisplayed());
		System.out.println("Form login is display");
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
