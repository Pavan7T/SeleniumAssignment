package Testscript;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoibiboAssignment1 {

	WebDriver driver;

	@Test
	public void Implicitwaiteg2() throws InterruptedException {
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		// Thread.sleep(3000);

		WebElement banglore = driver.findElement(By.xpath("//input[@type='text']"));
		banglore.sendKeys("Ben");
		driver.findElement(By.xpath("//span[text()='Bengaluru, India']")).click();

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
