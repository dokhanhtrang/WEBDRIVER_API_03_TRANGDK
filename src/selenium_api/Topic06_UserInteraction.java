package selenium_api;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic06_UserInteraction {
	// Create Global variables
	WebDriver driver;

	@BeforeClass
	public void setup() {
		// Open ChromeDriver
		// System.setProperty("webdriver.chrome.driver",
		// ".\\.\\.\\Driver\\chromedriver.exe");
		// driver = new ChromeDriver();
		// // Open driver
		driver = new FirefoxDriver();
		// wait page load sucessfully
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Maximize browser fullscreen
		driver.manage().window().maximize();

	}

	 @Test
	 public void TC01_Move_Mouse_To_Element() {
	 driver.get("http://daominhdam.890m.com/");
	 WebElement text = driver.findElement(By.xpath("//a[contains(.,'Hover over me')]"));
	 Actions buider = new Actions(driver);
	 buider.moveToElement(text).perform();
	 WebElement tooltip =
	 driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
	 Assert.assertTrue(tooltip.isDisplayed());
	 String note1 = tooltip.getText();
	 Assert.assertEquals("Hooray!", note1);
	 System.out.println("Tooltip:Horray is display");
	 driver.get("http://www.myntra.com/");
	 WebElement user = driver
	 .findElement(By.xpath("//span[contains(@class,'myntraweb-sprite desktop-iconUser sprites-user')]"));
	 Actions buider1 = new Actions(driver);
	 buider1.moveToElement(user).perform();
	 driver.findElement(By.xpath("//a[@data-track='login']")).click();
	 Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='mountRoot']//div[@class='login-box']")).isDisplayed());
	 System.out.println("Form login is display");
	
	 }
	
	 @Test
	 public void TC02_ClickandHold_SelectMultiple() {
	 driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
	 List<WebElement> listNumber = driver.findElements(By.xpath("//ol[@class='ui-selectable']/li"));
	 Actions builder = new Actions(driver);
	 builder.clickAndHold(listNumber.get(0)).clickAndHold(listNumber.get(3)).release().perform();
	 List<WebElement> numberSelected =driver.findElements(By.xpath("//li[@class='ui-state-default ui-selecteeui-selected']"));
	 int number =numberSelected.size();
	 Assert.assertEquals(4, number);
	 }

	 @Test
	 public void TC03_DoubleClick() {
	 driver.get("http://www.seleniumlearn.com/double-click");
	 WebElement ele =driver.findElement(By.xpath("//button[contains(.,'Double-Click Me!')]"));
	 Actions doubleClick = new Actions(driver);
	 doubleClick.doubleClick(ele).perform();
	 Alert alert = driver.switchTo().alert();
	 Assert.assertEquals("The Button was double-clicked.", alert.getText());
	 alert.accept();
	 }
	@Test
	public void TC04_RightClick() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		WebElement context = driver.findElement(By.xpath("//span[contains(text(),\"right click me\")]"));
		Actions action = new Actions(driver);
		action.contextClick(context).perform();
		WebElement display = driver
				.findElement(By.xpath("//li[contains(@class,'context-menu-icon-quit') and contains(.,'Quit')]"));
		action.moveToElement(display).perform();
		WebElement quit = driver.findElement(By.xpath("//li[contains(@class,'context-menu-visible') and contains(.,'Quit')]"));
		Assert.assertTrue(quit.isDisplayed());
		WebElement hover = driver.findElement(By.xpath("//li[contains(@class,'context-menu-hover') and contains(.,'Quit')]"));
		Assert.assertTrue(hover.isDisplayed());
		hover.click();
	}
	@Test
	public void TC05_DragAndDrop() {
		//circle
		driver.get("http://demos.telerik.com/kendo-ui/dragdrop/angular");
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='droptarget']"));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(dragFrom)
		.moveToElement(target).release(target).build();
		dragAndDrop.perform();
		Assert.assertTrue(target.getText().contains("You did great!"));
		//square
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		WebElement dragFrom1 = driver.findElement(By.xpath("//p[contains(.,'Drag me to my target')]"));
		WebElement target1 = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions builder1 = new Actions(driver);
		Action dragAndDrop1 = builder1.clickAndHold(dragFrom1)
		.moveToElement(target1).release(target1).build();
		dragAndDrop1.perform();
		Assert.assertTrue(target1.getText().contains("Dropped!"));
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
