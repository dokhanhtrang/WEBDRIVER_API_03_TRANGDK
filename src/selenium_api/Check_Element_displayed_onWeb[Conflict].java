package selenium_api;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class Check_Element_displayed_onWeb {
	//Create gobal variables
	WebDriver driver;
	@BeforeClass
	public void SetUp() {
		//O
		driver = new FirefoxDriver();
	}

	@Test
	public void f() {
	}

	@AfterClass
	public void afterClass() {
	}

}
