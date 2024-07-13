package Testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameAssignment {

	WebDriver driver;

	@Test
	public void FramesTask() throws InterruptedException {

		driver.get("http://the-internet.herokuapp.com/frames");
		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
		try {
			driver.switchTo().frame(1);
		} catch (NoSuchFrameException e) {
			Assert.fail("Frame was expected but not found");
		}

		driver.switchTo().defaultContent();

		driver.get("http://the-internet.herokuapp.com/frames");
		driver.findElement(By.xpath("//a[text()='iFrame']")).click();
		try {
			driver.switchTo().frame("frame-top");
		} catch (NoSuchFrameException e) {
			Assert.fail("Frame was expected but not found");
		}
		driver.findElement(By.xpath("//div[@class='tox-icon']")).click();
		Thread.sleep(2000);

		System.out.println("Iframe Test case pass");
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
