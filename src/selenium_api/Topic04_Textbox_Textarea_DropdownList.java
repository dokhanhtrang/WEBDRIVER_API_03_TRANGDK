package selenium_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic04_Textbox_Textarea_DropdownList {
	// Create Global variables
	private WebDriver driver;
	private String name, birthday, add, city, state, pin, mobile, mail, password, customeriD;

	@BeforeClass
	public void setup() {
		// Open driver
		driver = new FirefoxDriver();
		// open app
		driver.get("http://daominhdam.890m.com/");
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();
		name = "Do Khanh Trang";
		birthday = "28/06/1995";
		add = "Hanoi";
		city = "Hanoi";
		state = "VietNam";
		pin = "123456";
		mobile = "023456789";
		mail = "khanhtrang" + randomData() + "@gmail.com";
		password = "123456" + randomData();

	}

	@Test
	public void TC01_Handle_Dropdown_List() throws Exception {
		Select Job1 = new Select(driver.findElement(By.xpath("//select[@id='job1']")));
		Assert.assertFalse(Job1.isMultiple());
		Job1.selectByVisibleText("Automation Tester");
		Thread.sleep(2000);
		Assert.assertEquals("Automation Tester", Job1.getFirstSelectedOption().getText());
		Job1.selectByValue("manual");
		Thread.sleep(2000);
		Assert.assertEquals("Manual Tester", Job1.getFirstSelectedOption().getText());
		Job1.selectByIndex(3);
		Thread.sleep(2000);
		Assert.assertEquals("Mobile Tester", Job1.getFirstSelectedOption().getText());
		Assert.assertEquals(5, Job1.getOptions().size());

	}

	@Test
	public void TC02_Handle_Textbox_Textarea() throws Exception {
		driver.get("http://demo.guru99.com/v4");
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr125142");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("YvavYrA");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		driver.findElement(By.xpath("//a[@href='addcustomerpage.php']")).click();
		driver.findElement(By.xpath("//input[@value='f']")).click();
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		driver.findElement(By.xpath("//input[@name='dob']")).sendKeys(birthday);
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(add);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(pin);
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(mail);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='sub']")).click();
		customeriD = driver.findElement(By.xpath("//td[contains(text(),'Customer ID')]/following-sibling::td"))
				.getText();
		System.out.println("Customer ID : " + customeriD);
		driver.findElement(By.xpath("//a[@href='EditCustomer.php']")).click();
		driver.findElement(By.xpath("//input[@name='cusid']")).sendKeys(customeriD);
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		Assert.assertEquals(name, driver.findElement(By.xpath("//input[@name='name']")).getAttribute("value"));
		Assert.assertEquals(add, driver.findElement(By.xpath("//textarea[@name='addr']")).getAttribute("value"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@name='addr']")).clear();
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys("ABC123");
		driver.findElement(By.xpath("//input[@name='city']")).clear();
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("ABC123");
		driver.findElement(By.xpath("//input[@name='sub']")).click();
	}

	public int randomData() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
