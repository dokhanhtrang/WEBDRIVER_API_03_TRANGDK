package selenium_api;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Check_Element_Enable_Disable {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test01_TextboxIsDisabled() throws Exception {
		//wait for
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//get link
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		String element = "//input[@id='password']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Textbox is enabled");
		} else {
			System.out.println("Textbox is disabled");
		}
	}

	@Test
	public void Test02_TextAreaIsDisabled() throws Exception {
		String element = "//textarea[@id='bio']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Text Area is enabled");
		} else {
			System.out.println("Text Area is disabled");
		}
	}

	@Test
	public void Test03_CheckboxIsDisabled() throws Exception {
		String element = "//*[@id='check-disbaled']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Checkbox is enabled");
		} else {
			System.out.println("Checkbox is disabled");
		}
	}

	@Test
	public void Test04_ButtonIsDisabled() throws Exception {
		String element = "//*[@id='button-disabled']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Button is enabled");
		} else {
			System.out.println("Button is disabled");
		}
	}

	@Test
	public void Test05_SliderIsDisabled() throws Exception {
		String element = "//*[@id='slider-2']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Slider is enabled");
		} else {
			System.out.println("Slider is disabled");
		}
	}

	@Test
	public void Test06_RadioButtonIsDisabled() throws Exception {
		String element = "//input[@id='radio-disabled']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Radio button is enabled");
		} else {
			System.out.println("Radio button is disabled");
		}
	}

	@Test
	public void Test07_DropdownListIsDisabled() throws Exception {
		String element = "//*[@id='job2']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Dropdown List is enabled");
		} else {
			System.out.println("Dropdown List is disabled n");
		}
	}
	@Test
	public void Test08_TextboxIsDisable() throws Exception{
		String element = "//*[@id='mail']";
		if (isElementEnabled(driver, element)) {
			System.out.println("Email is enable");
		}else {
			System.out.println("Email is disable");
		}
	}

	public boolean isElementEnabled(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isEnabled();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}