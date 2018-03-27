package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Topic03_Browser_WebElementCommands_MultiBrowsers {
	// Create Global variables
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// Open ChromeDriver
//		System.setProperty("webdriver.chrome.driver", ".\\.\\.\\Driver\\chromedriver.exe");
//		driver = new ChromeDriver();
		// Open IEDriver
//		System.setProperty("webdriver.ie.driver", ".\\.\\.\\Driver\\IEDriverServer.exe");
//		driver = new InternetExplorerDriver();
//		// Open firefox 47
//		// open firefox >47 use geckodriver
		driver = new FirefoxDriver();
//		// Maximize browser fullscreen
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
		WebElement Email = driver.findElement(By.xpath("//input[@id='mail']"));
		if (Email.isDisplayed()) {
			Email.sendKeys("Automation Testing");
		}
		WebElement Radio = driver.findElement(By.xpath("//input[@id='under_18']"));
		if (Radio.isDisplayed()) {
			Radio.click();
		}
		WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
		if (Education.isDisplayed()) {
			Education.sendKeys("Automation Testing");
		}
	}

	@Test
	public void TC02_CheckElementEnable() {
		WebElement Email = driver.findElement(By.xpath("//input[@id='mail']"));
		if (Email.isEnabled()) {
			System.out.println("Email is Enable");
		}
		WebElement RadioUnder18 = driver.findElement(By.xpath("//input[@id='under_18']"));
		if (RadioUnder18.isEnabled()) {
			System.out.println("Age Under 18 is enable");
		}
		WebElement Education = driver.findElement(By.xpath("//textarea[@id='edu']"));
		if (Education.isEnabled()) {
			System.out.println("Education is enable");
		}
		WebElement Job1 = driver.findElement(By.xpath("//select[@id='job1']"));
		if (Job1.isEnabled()) {
			System.out.println("Job 1 is enable");
		}
		WebElement Dev = driver.findElement(By.xpath("//label[@for='development']\n"));
		if (Dev.isEnabled()) {
			System.out.println("Checkbox development is enable");
		}
		WebElement Slide1 = driver.findElement(By.xpath("//input[@id='slider-1']"));
		if (Slide1.isEnabled()) {
			System.out.println("Slider 1 is enable");
		}
		WebElement Button1 = driver.findElement(By.xpath("//button[@type='submit']"));
		if (Button1.isEnabled()) {
			System.out.println("'This button is enable");
		}
		WebElement Password = driver.findElement(By.xpath("//button[@type='submit']"));
		if (!Password.isEnabled()) {
			System.out.println("'Password is disable");
		}
		WebElement RadioDisable = driver.findElement(By.xpath("//label[@for='radio-disabled']"));
		if (!RadioDisable.isEnabled()) {
			System.out.println("'Option is disable");
		}
		WebElement Biography = driver.findElement(By.xpath("//textarea[@disabled='disabled']"));
		if (!Biography.isEnabled()) {
			System.out.println("'Biography is disable");
		}
		WebElement Job2 = driver.findElement(By.xpath("//select[@id='job2']"));
		if (!Job2.isEnabled()) {
			System.out.println("'Job 2 is disable");
		}
		WebElement CheckboxDisable = driver.findElement(By.xpath("//label[@for='check-disbaled']"));
		if (!CheckboxDisable.isEnabled()) {
			System.out.println("'This option is disable");
		}
		WebElement Slider2 = driver.findElement(By.xpath("//input[@id='slider-2']"));
		if (!Slider2.isEnabled()) {
			System.out.println("'Slider 2 is disable");
		}
		WebElement Button2 = driver.findElement(By.xpath("//button[@disabled='disabled']"));
		if (!Button2.isEnabled()) {
			System.out.println("'Button 2 is disable");
		}

	}

	@Test
	public void TC03_CheckElementIsSelected() {
		WebElement Age = driver.findElement(By.xpath("//input[@id='mail']"));
		Age.click();
		WebElement Dev = driver.findElement(By.xpath("//label[@for='development']"));
		Dev.click();
		if (Dev.isSelected() || Age.isSelected()) {
		} else {
			Dev.click();
			Age.click();
		}
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
