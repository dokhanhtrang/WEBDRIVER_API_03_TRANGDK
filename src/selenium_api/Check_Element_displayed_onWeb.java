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

public class Check_Element_displayed_onWeb {
	// Create gobal variables
	WebDriver driver;

	@BeforeClass
	public void SetUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test01_TextboxIsDisplayed() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://daominhdam.890m.com");
		driver.manage().window().maximize();

		String element = "//*[@id='mail']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Textbox is displayed");
		} else {
			System.out.println("Textbox isn't displayed");
		}
	}

	@Test
	public void Test02_DropdownListIsDisplayed() throws Exception {
		String element = "//*[@id='job1']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Dropdown list is displayed");
		} else {
			System.out.println("Dropdown list isn't displayed");
		}
	}

	@Test
	public void Test03_TableIsDisplayed() throws Exception {
		String element = "//*[@id='table-column-toggle']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Table is displayed");
		} else {
			System.out.println("Table isn't displayed");
		}
	}

	@Test
	public void Test04_RadioButtonIsDisplayed() throws Exception {
		String element = "//input[@id='under_18']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Radio button is displayed");
		} else {
			System.out.println("Radio button isn't displayed");
		}
	}

	@Test
	public void Test05_CheckboxIsDisplayed() throws Exception {
		String element = "//*[@id='development']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Checkbox is displayed");
		} else {
			System.out.println("Checkbox isn't displayed");
		}
	}

	@Test
	public void Test06_TextAreaIsDisplayed() throws Exception {
		String element = "//*[@id='edu']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Text Area is displayed");
		} else {
			System.out.println("Text Area isn't displayed");
		}
	}

	@Test
	public void Test07_ButtonIsDisplayed() throws Exception {
		String element = "//*[@id='button-enabled']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Button is displayed");
		} else {
			System.out.println("Button isn't displayed");
		}
	}

	@Test
	public void Test08_SliderIsDisplayed() throws Exception {
		String element = "//*[@id='slider-1']";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Slider is displayed");
		} else {
			System.out.println("Slider isn't displayed");
		}
	}

	@Test
	public void Test09_IframeIsNotDisplayed() throws Exception {
		String element = "//iframe";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Iframe is displayed");
		} else {
			System.out.println("Iframe isn't displayed");
		}
	}

	@Test
	public void Test10_ImageIsNotDisplayed() throws Exception {
		String element = "//img";
		if (isElementDisplayed(driver, element)) {
			System.out.println("Image is displayed");
		} else {
			System.out.println("Image isn't displayed n");
		}
	}

	private boolean isElementDisplayed(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterClass
	 public void tearDown() {
		 driver.quit();
	}

}
