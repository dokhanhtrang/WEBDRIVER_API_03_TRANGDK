package selenium_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic05_Button_Radio_Checkbox_Alert {
	// create global var
	private WebDriver driver;
	private String name;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		name = "khanhtrang";
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC01_ButtonClick() {
		driver.get("http://daominhdam.890m.com/");
		// use selenium code
		WebElement Button = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		Button.click();
		String url = driver.getCurrentUrl();
		Assert.assertEquals("http://daominhdam.890m.com/#", url);
		driver.navigate().back();
		// Must declear var after load page
		// Use Javascript code
		WebElement Button1 = driver.findElement(By.xpath("//button[@id='button-enabled']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", Button1);
		String url1 = driver.getCurrentUrl();
		Assert.assertEquals("http://daominhdam.890m.com/#", url1);

	}

	@Test
	public void TC02_CheckboxClick() {
		driver.get("http://demos.telerik.com/kendo-ui/styling/checkboxes");
		WebElement Checkbox = driver.findElement(By.xpath("//label[contains(@for,'eq5')]"));
		Checkbox.click();
		if (Checkbox.isSelected()) {
			Checkbox.click();
			assert !Checkbox.isSelected();
		}
	}

	@Test
	public void TC03_RadioButtonClick() {
		driver.get("https://demos.telerik.com/kendo-ui/styling/radios");
		WebElement Radio = driver.findElement(By.xpath("//label[@for='engine3']"));
		Radio.click();
		if (!Radio.isSelected()) {
			Radio.click();
		}
	}

	@Test
	public void TC04_AcceptAlert() {
		driver.get("http://daominhdam.890m.com/");
		WebElement Button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
		Button.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Alert", alert.getText());
		alert.accept();
		Assert.assertEquals("You clicked an alert successfully",
				driver.findElement(By.xpath("//p[@id='result']")).getText());
	}

	@Test
	public void TC05_DismissAlert() {
		driver.get("http://daominhdam.890m.com/");
		WebElement Button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
		Button.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS Confirm", alert.getText());
		alert.dismiss();
		Assert.assertEquals("You clicked: Cancel", driver.findElement(By.xpath("//p[@id='result']")).getText());
	}

	@Test
	public void TC06_PromptAlert() {
		driver.get("http://daominhdam.890m.com/");
		WebElement Button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
		Button.click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("I am a JS prompt", alert.getText());
		alert.sendKeys(name);
		alert.accept();
		Assert.assertTrue(driver.findElement(By.xpath("//p[@id='result' and contains(text(),'"+name+"')]")).isDisplayed());
	}

	@AfterClass
	// Clean up
	public void tearDown() {
		driver.quit();
	}

}
