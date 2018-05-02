package selenium_api;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.base.Function;

public class Topic10_Verify_Assert_Waits {
	// create global var
	private WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setup() {
		// driver = new FirefoxDriver();
		// Open ChromeDriver
		System.setProperty("webdriver.chrome.driver", ".\\.\\.\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_ImplicitWait() throws Exception {
		driver.get("http://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[contains(.,'Start')]")).click();
		Thread.sleep(6000);
		assertTrue(driver.findElement(By.xpath("//h4[contains(.,'Hello World!')]")).isDisplayed());
		System.out.println("Done TC01");
	}

	@Test
	public void TC02_ExplicitWait() {
		driver.get(
				"http://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		assertTrue(driver.findElement(By.xpath("//div[@class='contentWrapper']")).isDisplayed());
		System.out.println("Before choose date: "
				+ driver.findElement(By.xpath("//span[@id='ctl00_ContentPlaceholder1_Label1']")).getText());
		driver.findElement(By.xpath("//a[contains(.,'24')]")).click();
		By ajax = By.xpath("//div[@class='raDiv']");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ajax));
		WebElement ele = driver.findElement(By.xpath("//span[contains(.,'24,')]"));
		String noteDate = ele.getText();
		assertTrue(noteDate.contains("24"));
		System.out.println("After choose date: " + noteDate);
		System.out.println("Done TC02");
	}

	@Test
	public void TC03_FluentWait1() throws Exception {
		driver.get("https://stuntcoders.com/snippets/javascript-countdown/");
		assertTrue(driver.findElement(By.id("javascript_countdown_time")).isDisplayed());
		By countDown = By.xpath("//div[@id='javascript_countdown_time']");
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(countDown));
		// Create Fluent variable
		new FluentWait<WebElement>(driver.findElement(By.xpath("//div[@id='javascript_countdown_time']")))
				.withTimeout(10, TimeUnit.SECONDS).pollingEvery(100, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement element) {
						boolean flag = element.getText().endsWith("00");
						System.out.println("Time = " + element.getText());
						return flag;
					}
				});
		System.out.println("Done TC 03");
	}

	@Test
	public void TC04_FluentWait2() {
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		new FluentWait<WebElement>(driver.findElement(By.xpath("//span[@class='timer']")))
				.withTimeout(40, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).until(new Function<WebElement, Boolean>() {
					public Boolean apply(WebElement arg0) {
						WebElement ele = driver.findElement(By.xpath("//button[@id='colorVar']"));
						String color = ele.getCssValue("style");
						System.out.println(color);
						if (color.equals("red")) {
							return true;
						}
						return false;
					}
				});

	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}
}
