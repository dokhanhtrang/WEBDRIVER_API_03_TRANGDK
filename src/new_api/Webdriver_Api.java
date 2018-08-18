package new_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebElement;

public class Webdriver_Api {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		// System.setProperty("webdriver.chrome.driver",".\\.\\.\\Driver\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get("http://dev.tms.betacorp.vn/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void Tcs() throws Exception {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("savis.sonpn");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("12345a@");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(10000);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='caption caption-md']")).isDisplayed());
		driver.findElement(By.xpath("//a[contains(.,'Phim và show chiếu')]")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//a[@href='#!/show']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[@ng-click='Button.Add.Click()']")).click();
		Thread.sleep(3000);
		System.out.println("Add page open");
		driver.findElement(By.xpath("//div[@title='Chọn rạp chiếu']")).click();
		driver.findElement(By.xpath("//div[@title='Chọn rạp chiếu']//div[contains(text(),\"BẮC GIANG\")]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@title='Chọn phòng chiếu chiếu']")).click();
		driver.findElement(By.xpath("//div[@title='Chọn phòng chiếu chiếu']//div[contains(text(),\"P2\")]")).click();
		driver.findElement(By.xpath("//div[@title='Chọn phim']")).click();
		driver.findElement(By.xpath("//div[@title='Chọn phim']//div[contains(text(),'Mỹ Nhân Ngư: Hồ Tử Thần')]")).click();
		WebElement Schedule = driver.findElement(By.xpath("//input[@name='ShowTime']"));
		removeAttributeInDOM(Schedule,"disabled");
		Schedule.clear();
		Schedule.sendKeys("5:00PM");
		driver.findElement(By.xpath("//div[@title='Chọn chính sách']")).click();
		driver.findElement(By.xpath("//div[@title='Chọn chính sách']//div[contains(text(),'3D 12.06')]")).click();
		driver.findElement(By.xpath("//div [@ng-model='Show.SaleChanelSelected']")).click();
		driver.findElement(By.xpath("//div [@ng-model='Show.SaleChanelSelected']//span[contains(text(),'Website')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

	}

//	public void selectDropdown(String expectText, String xpath) {
//		List<WebElement> list = driver.findElements(By.xpath(xpath));
//		for (WebElement item: list)
//		{
//			String text = item.getText();
//			System.out.println(text);
//			if (text == expectText) {
//				item.click();
//				break;
//			}}}
	public Object removeAttributeInDOM(WebElement element, String attribute) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
