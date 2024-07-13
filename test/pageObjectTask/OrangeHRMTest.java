
package pageObjectTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class OrangeHRMTest {

	OrangeHRMPO login;
	private String user = "admin";
	private String password = "admin123";
	private String expectedTitle = "OrangeHRM";

	@Test
	public void OrangeHRMLogin() throws InterruptedException {
		String actualTitle = login.loginMethod(user, password);
		assertEquals(expectedTitle, actualTitle);
		System.out.println("Actual Title: " + actualTitle);
		System.out.println("Orange HRM test case Passed");
	}

	@BeforeClass
	public void beforeClass() {
		login = new OrangeHRMPO();
	}

	@AfterClass
	public void afterClass() {
		login.closeBrowser();
	}

}
