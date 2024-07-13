package Testscript;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowHandle_assignment2 {
	WebDriver driver;

	@Test
	public void WindowPopup() throws InterruptedException {

		driver.get("https://www.cookbook.seleniumacademy.com/Config.html");
		String parentWindow = driver.getWindowHandle();
		driver.findElement(By.id("helpbutton")).click();
		Thread.sleep(20000);
		try {
			driver.switchTo().window("HelpWindow");
			String HelpText = driver.findElement(By.xpath("//h3[text()=' Build my Car - Configuration Help']"))
					.getText();

			assertEquals("Build my Car - Configuration Help", HelpText);
			System.out.println("Help Text test case passed");
		} catch (NoAlertPresentException e) {
			fail("Alert is not present");
		}

		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("chatbutton")).click();

		Set<String> AllopenWindow = driver.getWindowHandles();
		try {
			for (String window : AllopenWindow) {
				if (window.equals(parentWindow) && (window.equals("HelpWindow"))) {
					continue;
				}
				driver.switchTo().window(window);
			}
		} catch (NoAlertPresentException e) {
			fail("Alert is not present");
		}

		String OnlineChatText = driver
				.findElement(By.xpath("//h3[text()='Build my Car - Configuration - Online Chat']")).getText();
		assertEquals("Build my Car - Configuration - Online Chat", OnlineChatText);

		System.out.println("Online Chat test case 2 passed!");

		driver.switchTo().window(parentWindow);
		driver.findElement(By.id("visitbutton")).click();
		driver.switchTo().window("VisitUsWindow");
		String visitUsText = driver.findElement(By.xpath("//h3[text()='Build my Car - Configuration - Visit Us']"))
				.getText();
		assertEquals("Build my Car - Configuration - Visit Us", visitUsText);
		System.out.println("Visit Us test case 2 passed!");

	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
