package Testscript;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ImplicitWaitTask {

	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void Implicitwaiteg() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.xpath("//button[text()='Start']")).click();

		// driver.findElement(By.xpath("//h4[text()='Hello World!']")).getText();
		WebElement clickMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		assertEquals("Hello World!", clickMsg.getText());
		System.out.println("Implicit Wait test 1 case passed!");
		// ------------

	}

	@Test
	public void Implicitwaiteg2() throws InterruptedException {

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.findElement(By.xpath("//div[@id='start']/button")).click();

		// String clickMsg = driver.findElement(By.xpath("//h4[text()='Hello
		// World!']")).getText();
		WebElement clickMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));

		assertEquals("Hello World!", clickMsg.getText());
		System.out.println("Implicit Wait test case 2 passed!");
		// ------------
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(200));
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
