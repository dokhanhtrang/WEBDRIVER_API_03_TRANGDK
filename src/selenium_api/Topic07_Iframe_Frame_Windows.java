package selenium_api;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;
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

public class Topic07_Iframe_Frame_Windows {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void setforAll() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void TC01() throws Exception {
		driver.get("http://www.hdfcbank.com/");
		WebElement lookingForIframe = driver.findElement(By.xpath("//div[@class='flipBannerWrap']//iframe"));
		driver.switchTo().frame(lookingForIframe);
		WebElement lookingForText = driver.findElement(By.xpath("//span[@id='messageText']"));
		String text = lookingForText.getText();
		Assert.assertEquals("What are you looking for?", text);
		Thread.sleep(1500);
		driver.switchTo().defaultContent();
		WebElement lookingForIframe1 = driver.findElement(By.xpath("//div[@class='slidingbanners']//iframe"));
		driver.switchTo().frame(lookingForIframe1);
		List<WebElement> images = driver.findElements(By.xpath("//img[@class='bannerimage']"));
		int numberImg = images.size();
		Assert.assertEquals(6, numberImg);
		for (WebElement image : images) {
			image.isDisplayed();
		}
		driver.switchTo().defaultContent();
		WebElement lookingForBanner = driver.findElement(By.xpath("//div[@class='flipBanner']"));
		assertTrue(lookingForBanner.isDisplayed());
	}

	@Test
	public void TC02() throws Exception {
		driver.get("http://daominhdam.890m.com/");
		String parentID = driver.getWindowHandle();
		WebElement windows = driver.findElement(By.xpath("//a[@href='http://google.com.vn']"));
		windows.click();
		switchToChildWindow(parentID);
		System.out.println("is switched");
		String googleTitle = driver.getTitle();
		Assert.assertEquals("Google", googleTitle);
		closeAllWithoutParentWindows(parentID);
		driver.switchTo().defaultContent();

	}

	@Test
	public void TC03() throws Exception {
		driver.get("https://www.hdfcbank.com/");
		String IDp = driver.getWindowHandle();
		WebElement parents = driver.findElement(By.xpath("//a[@href='/htdocs/common/agri/index.html']"));
		parents.click();
		System.out.println(driver.getTitle());
		switchToChildWindow(IDp);
		WebElement child1 = driver.findElement(By.xpath("//p[contains(text(),'Account Details')]"));
		child1.click();
		System.out.println(driver.getTitle());
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		driver.switchTo().frame(1);
		WebElement child2 = driver.findElement(By.xpath("//a[contains(text(),'Privacy Policy')]"));
		child2.click();
		System.out.println(driver.getTitle());
		switchToWindowByTitle("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		WebElement child3 =driver.findElement(By.xpath("//a[@href='/csr/index.aspx']"));
		child3.click();
		System.out.println(driver.getTitle());
		closeAllWithoutParentWindows(IDp);
	}
//switch by GUID
	public void switchToChildWindow(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}
//switch by title
	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}
//Close window child
	public boolean closeAllWithoutParentWindows(String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	@AfterClass
	public void Teardown() {
		driver.quit();
	}

}
