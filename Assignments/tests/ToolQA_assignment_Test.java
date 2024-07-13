package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class ToolQA_assignment_Test {
	ToolQA_assignment_PO dataEntry;

	@Test
	public void loginTotooQA() {
		dataEntry.dataEntry();
	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod
	public void afterMethod() {

	}

	@BeforeClass
	public void beforeClass() {
		dataEntry = new ToolQA_assignment_PO();
	}

	@AfterClass
	public void afterClass() {
		// dataEntry.closeBrowser();
	}

}
