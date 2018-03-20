package selenium_api;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic02_WebBrowser_WebElement {
	// Create Global variables
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// Open driver
		driver = new FirefoxDriver();

	}

	@BeforeMethod
	public void StepForAllTC() {
		// open app
		driver.get("http://live.guru99.com/");
		// get title
		String homePageTitle = driver.getTitle();
		// verify
		Assert.assertEquals(homePageTitle, "Home page");
		// go to log in page
		driver.get("http://live.guru99.com/index.php/customer/account/");
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();

	}

	@Test
	public void TC01_VerifyUrlAndTitle() {
		// go to sign up page
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		// back to log in
		driver.findElement(By.xpath("//a[@class='back-link']")).click();
		// get url
		String urlLoginPage = driver.getCurrentUrl();
		// verify
		Assert.assertEquals(urlLoginPage, "http://live.guru99.com/index.php/customer/account/login/");
		// go to sign up page
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		// get url
		String urlSignupPage = driver.getCurrentUrl();
		// verify
		Assert.assertEquals(urlSignupPage, "http://live.guru99.com/index.php/customer/account/create/");
		// go to sign up page
	}

	@Test
	public void TC02_LoginEmpty() {
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		WebElement element = driver.findElement(By.xpath(".//*[@class='validation-advice']"));
		String error = element.getText();
		Assert.assertEquals("This is a required field.", error);
	}

	@Test
	public void TC03_LoginWithEmailInvalid() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		WebElement element = driver.findElement(By.xpath("//*[@id='advice-validate-email-email']"));
		String error = element.getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", error);
	}

	@Test
	public void TC04_LoginWithPassworIncorrect() {
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123123@123.com");
		driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@id='send2']")).click();
		WebElement element = driver.findElement(By.xpath("//div[@class='validation-advice']"));
		String error = element.getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", error);
	}

	@Test
	public void TC05_CreateAnAccount() {
		driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[3]/div/div[4]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Do");
		driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Khanh");
		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Trang");
		driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys("khanhtranghihi2806@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123@123");
		driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123@123");
		driver.findElement(By.xpath("//input[@class='checkbox']")).click();
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		WebElement element = driver
				.findElement(By.xpath("//span[contains(.,'Thank you for registering with Main Website Store.')]"));
		String notify = element.getText();
		Assert.assertEquals("Thank you for registering with Main Website Store.", notify);

	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
