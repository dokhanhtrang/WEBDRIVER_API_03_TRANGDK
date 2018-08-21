package selenium_api;

import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic09_UploadFile {
	WebDriver driver;
	String filePath = "D:\\Selenium\\Workspace\\WEBDRIVER_API_TRANGDK\\upload\\image.jpg";
	String imgName = "image.jpg";

	@BeforeClass
	public void setup() {
		// Open IEDriver
		// System.setProperty("webdriver.ie.driver",
		// ".\\.\\.\\Driver\\IEDriverServer.exe");
		// driver = new InternetExplorerDriver();
		// Open driver
		driver = new FirefoxDriver();
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();

	}

//	@Test
//	public void TC01_uploadfileBySendKeys() {
//		driver.get("http://www.helloselenium.com/2015/03/how-to-upload-file-using-sendkeys.html");
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
//		driver.findElement(By.xpath("//input[@name='uploadFileButton']")).click();
//		System.out.println("Image is uploaded at helloselenium");
//		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
//		WebElement imgname = driver.findElement(By.xpath("//p[contains(text(),'" + imgName + "')]"));
//		assertTrue(imgname.isDisplayed());
//		driver.findElement(By.xpath(".//*[@id='fileupload']/table/tbody/tr/td[4]/button[1]")).click();
//		WebElement imgUploaded = driver.findElement(By.xpath("//img[contains(@src,'" + imgName + "')]"));
//		assertTrue(imgUploaded.isDisplayed());
//		System.out.println("Is uploaded, Done TC01");
//	}
//
//	@Test
//	public void TC02_uploadfileByAutoIT() throws Exception {
//		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
//		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(filePath);
//		// // IE 11
//		// WebElement uploadIE =
//		// driver.findElement(By.xpath("//span[contains(text(),'Add files...')]"));
//		// uploadIE.click();
//		//
//		// // Chrome
//		// WebElement uploadChrome =
//		// driver.findElement(By.cssSelector(".fileinput-button"));
//		// uploadChrome.click();
//
//		// Firefox
//		WebElement uploadFirefox = driver.findElement(By.xpath("//input[@type='file']"));
//		uploadFirefox.click();
//		Runtime.getRuntime().exec(new String[] { ".\\upload\\firefox.exe", filePath });
//		Thread.sleep(3000);
//		WebElement imgname = driver.findElement(By.xpath("//p[contains(text(),'" + imgName + "')]"));
//		assertTrue(imgname.isDisplayed());
//		driver.findElement(By.xpath(".//*[@id='fileupload']/table/tbody/tr/td[4]/button[1]")).click();
//		WebElement imgUploaded = driver.findElement(By.xpath("//img[contains(@src,'" + imgName + "')]"));
//		assertTrue(imgUploaded.isDisplayed());
//		System.out.println("Done TC02");
//	}
//
	@Test
	public void TC03_uploadfileByRobotClass() throws Exception {
		driver.get("http://blueimp.github.io/jQuery-File-Upload/");
		// Specify the file location with extension
		StringSelection select = new StringSelection(filePath);

		// Copy to clipboard
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

		// Click
		WebElement uploadFirefox = driver.findElement(By.xpath("//input[@type='file']"));
		uploadFirefox.click();

		Robot robot = new Robot();
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		Thread.sleep(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);

	}

//	@Test
//	public void TC04_uploadfile() throws Exception {
//		driver.get("https://encodable.com/uploaddemo/");
//		//choose img
//		driver.findElement(By.xpath("//input[@class='upform_field file required ']")).sendKeys(filePath);
//		//Select
//		Select list = new Select(driver.findElement(By.xpath("//select[@name='subdir1']")));
//		list.selectByIndex(0);
//		//Input folder
//		driver.findElement(By.xpath("//input[@id='newsubdir1']")).sendKeys("Dokhanhtrang");
//		driver.findElement(By.xpath("//input[@name='email_address']")).sendKeys("dokhanhtrang@gmail.com");
//		driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Khanh Trang");
//		driver.findElement(By.xpath("//input[@class='button']")).click();
//		assertTrue(driver.findElement(By.xpath("//dd[contains(.,'Email Address: dokhanhtrang@gmail.com')]")).isDisplayed());
//		assertTrue(driver.findElement(By.xpath("//dd[contains(.,'First Name: Khanh Trang')]")).isDisplayed());
//		assertTrue(driver.findElement(By.xpath("//dt[contains(.,'"+imgName+"')]")).isDisplayed());
//		driver.findElement(By.xpath("//a[@href='/uploaddemo/?action=listfiles']")).click();
//		driver.findElement(By.xpath("//a[@href='/uploaddemo/?action=listfiles&path=Dokhanhtrang']")).click();
//		assertTrue(driver.findElement(By.xpath("//a[contains(.,'"+imgName+"')]")).isDisplayed());
//		System.out.println("Done TC04");
//
//	}

	public int randomData() {
		Random rand = new Random();
		int number = rand.nextInt(999999) + 1;
		return number;
	}
	public Object clickWebElement(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			return js.executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			e.getMessage();
			return null;
		}
	}
	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
