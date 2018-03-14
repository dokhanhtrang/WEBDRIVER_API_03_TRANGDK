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

public class Check_Element_IsSelected {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = new FirefoxDriver();
	}

	@Test
	public void Test01_DevelopmentCheckboxIsSelected() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://daominhdam.890m.com/");
		driver.manage().window().maximize();
		String element = "//*[@id='development']";
		driver.findElement(By.xpath(element)).click();
		Thread.sleep(2000);
		if (isElementSelected(driver, element)) {
			System.out.println("'Development' checkbox is selected");
		} else {
			System.out.println("'Development' checkbox isn't selected");
		}
	}

	@Test
	public void Test02_DesignCheckboxIsNotSelected() throws Exception {
		String element = "//*[@id='design']";
		if (isElementSelected(driver, element)) {
			System.out.println("'Design' checkbox is selected");
		} else {
			System.out.println("'Design' checkbox isn't selected");
		}
	}

	@Test
	public void Test03_Under18RadioButtonIsSelected() throws Exception {
		String element = "//*[@id='under_18']";
		driver.findElement(By.xpath(element)).click();
		Thread.sleep(2000);
		if (isElementSelected(driver, element)) {
			System.out.println("'Under 18' radio button is selected");
		} else {
			System.out.println("'Under 18' radio button isn't selected");
		}
	}

	@Test
	public void Test04_18OrOrderRadioButtonIsNotSelected() throws Exception {
		String element = "//*[@id='over_18']";
		if (isElementSelected(driver, element)) {
			System.out.println("'Over 18' radio button is selected");
		} else {
			System.out.println("'Over 18' radio button isn't selected");
		}
	}

	@Test
	public void Test05_JobRoleDropdownListIsNotSelected() throws Exception {
		String element = "//*[@id='job1']";
		if (isElementSelected(driver, element)) {
			System.out.println("'Job Role 01' dropdown list is selected");
		} else {
			System.out.println("'Job Role 01' dropdown list isn't selected n");
		}
	}

	public boolean isElementSelected(WebDriver driver, String yourLocator) {
		try {
			WebElement locator;
			locator = driver.findElement(By.xpath(yourLocator));
			return locator.isSelected();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}