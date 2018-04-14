package selenium_api;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic08_JavascriptExecutor {
	private WebDriver driver;

	@BeforeClass
	public void setup() {
//		 Open IEDriver
		System.setProperty("webdriver.ie.driver", ".\\.\\.\\Driver\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
//		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01() {
		driver.get("http://live.guru99.com/");
		String domainName = (String) executeForBrowser("return document.domain");
		Assert.assertEquals("live.guru99.com", domainName);
		String url = (String) executeForBrowser("return document.URL");
		Assert.assertEquals("http://live.guru99.com/", url);
		WebElement mobile = driver.findElement(By.xpath("//a[contains(text(),'Mobile')]"));
		clickWebElement(mobile);
		WebElement add = driver.findElement(By
				.xpath("//h2[a[contains(text(),'Samsung Galaxy')]]/following-sibling::div[@class='actions']//button"));
		clickWebElement(add);
		String notify = (String) executeForBrowser("return document.documentElement.innerText;");
		assertTrue(notify.contains("Samsung Galaxy was added to your shopping cart."));
		WebElement policy = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		clickWebElement(policy);
		String title = (String) executeForBrowser("return document.title");
		Assert.assertEquals("Privacy Policy", title);
		scrollToBottomPage();
		WebElement lastTr = driver.findElement(By.xpath("//tr[contains(.,\"WISHLIST_CNT\")]"));
		assertTrue(lastTr.isDisplayed());
		navigateDomain("http://demo.guru99.com/v4/");
		String navigateDomain = (String) executeForBrowser("return document.URL");
		Assert.assertEquals("http://demo.guru99.com/v4/", navigateDomain);
		System.out.println("Done TC01");
	}

	@Test
	public void TC02_removeAttribute() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='iframeResult']")));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lname']"));
		removeAttributeInDOM(lastName, "disabled");
		lastName.sendKeys("Troang");
		clickWebElement(driver.findElement(By.xpath("//input[@type='submit']")));
		String noty = driver.findElement(By.xpath("//div[@style='word-wrap:break-word']")).getText();
		assertTrue(noty.contains("Troang"));
		System.out.println("Done TC02");
	}

	// Execute for Browser
	public Object executeForBrowser(String javaSript) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript(javaSript);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Click in WebElement
	public Object clickWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}

	// Scroll to bottom page
	public Object scrollToBottomPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	// Navigate url
	public Object navigateDomain(String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.location ='" + url + "'");

	}

	// Remove attribute in DOM
	public Object removeAttributeInDOM(WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}
}
