package pageObjectTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HerokuL1_Test {
	HerokuL1_PO homepageLogin;
	String expectedText = "Hello World!";

	@Test
	public void l2login() {
		String Actualtext = homepageLogin.loginToL2();
		assertEquals(expectedText, Actualtext);
		System.out.println("Actual Text: " + Actualtext);
		System.out.println("L2 login test case passed.");
		homepageLogin.closeDriver();
	}

	@Test
	public void l1login() {
		String Actualtext = homepageLogin.logIn();
		assertEquals(expectedText, Actualtext);
		System.out.println("Actual Text: " + Actualtext);
		System.out.println("L1 login test case passed.");
		// homepageLogin.closeDriver();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {

	}

	@BeforeClass
	public void beforeClass() {
		homepageLogin = new HerokuL1_PO();
	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
