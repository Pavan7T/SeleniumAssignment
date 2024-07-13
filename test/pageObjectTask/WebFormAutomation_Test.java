package pageObjectTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebFormAutomation_Test {

	WebFormAutomation_PO formFill;

	@Test
	public void fillWebform() {
		formFill.fillWebform();
	}

	@BeforeMethod
	public void beforeMethod() {
	}

	@AfterMethod
	public void afterMethod() {

	}

	@BeforeClass
	public void beforeClass() {
		formFill = new WebFormAutomation_PO();
	}

	@AfterClass
	public void afterClass() {
		// formFill.closeBrowser();
	}

}
