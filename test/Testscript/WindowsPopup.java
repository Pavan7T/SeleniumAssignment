package Testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjectTask.WindowsPopup_PO;

public class WindowsPopup {
	WindowsPopup_PO windowPoups;

	@Test
	public void windowTask() throws InterruptedException {
		windowPoups.homeLogin();
	}

	@BeforeClass
	public void beforeClass() {
		windowPoups = new WindowsPopup_PO();
	}

	@AfterClass
	public void afterClass() {
		windowPoups.broserClose();
	}

}
