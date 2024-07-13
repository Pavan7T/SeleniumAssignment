package pageObjectTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class AlertTask {

	WebDriver driver;

	@Test
	public void AlertActionsHandling() throws InterruptedException {
		driver.get("http://www.cookbook.seleniumacademy.com/Alerts.html");
		WebElement alertBtn = driver.findElement(By.id("simple"));
		alertBtn.click();

		// Simple Alert
		try {
			String str = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			System.out.println("Simple Alert popup Msg: " + str);
			System.out.println("------------------------------------------------");
			assertEquals("Hello! I am an alert box!", str);
		} catch (UnhandledAlertException e) {
			fail("Alert exception");
		}

		// Confirmation Alert
		WebElement ConfirmAlert = driver.findElement(By.xpath("//button[@id='confirm']"));
		ConfirmAlert.click();

		try {

			String AlertMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(2000);
			String str1 = driver.findElement(By.id("demo")).getText();

			ConfirmAlert.click();
			driver.switchTo().alert().dismiss();
			String cancelmsg = driver.findElement(By.id("demo")).getText();
			System.out.println("Confirmation Alert Popup msg: " + AlertMsg);
			System.out.println("Accept Alert msg: " + str1);
			System.out.println("Dismiss Alert msg: " + cancelmsg);
			System.out.println("------------------------------------------------");
			assertEquals("You Accepted Alert!", str1);
			assertEquals("Press a button!", AlertMsg);
			assertEquals("You Dismissed Alert!", cancelmsg);
		} catch (UnhandledAlertException e) {
			fail("Alert exception");
		}

		// prompt Alert
		WebElement promptAlert = driver.findElement(By.xpath("//button[@id='prompt']"));
		promptAlert.click();

		try {
			driver.switchTo().alert().sendKeys("selenium");
			String popUpMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
			String str2 = driver.findElement(By.id("prompt_demo")).getText();
			System.out.println("Prompt Alert popup msg: " + popUpMsg);
			System.out.println("Prompt Accept Alert masg: " + str2);
			System.out.println("------------------------------------------------");

			assertEquals("Please enter your name", popUpMsg);
			assertEquals("Hello selenium! How are you today?", str2);
		} catch (UnhandledAlertException e) {
			fail("Alert exception");
		}

	}

	// @Test
	public void AFlipcart() throws InterruptedException {
		driver.get("https://www.flipkart.com/");
		WebElement search = null;
		Thread.sleep(2000);
		try {
			search = driver.findElement(By.className("zDPmFV"));
			search.sendKeys("samsung mobile");
			search.submit();
			driver.findElement(By.xpath("//div[@class='XqNaEv']")).click();
		} catch (Exception e) {
			System.out.println("No such element found");
		}

		// Thread.sleep(2000);
		System.out.println("Flipcart test case");
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
