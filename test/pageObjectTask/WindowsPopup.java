package pageObjectTask;

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

public class WindowsPopup {

	WebDriver driver;

	@Test
	public void windowTask() throws InterruptedException {

		driver.get("https://nichethyself.com/tourism/home.html");
		String parentWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Customized tours']")).click();

		Set<String> AllopenWindow = driver.getWindowHandles();

		for (String window : AllopenWindow) {
			if (window.equals(parentWindowHandle)) {
				continue;
			}
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			// driver.findElement(By.xpath("//a[text()='Customized tours']")).click();
			Thread.sleep(2000);
			WebElement dropdown = driver.findElement(By.xpath("//select[@id='days']"));
			Select makeSelect = new Select(dropdown);
			makeSelect.selectByIndex(2);

			// WebElement countryDropdown=driver.

		}
		// driver.close();
		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();

		driver.switchTo().window("Contact");

		driver.findElement(By.xpath("//a[@onclick='prompty()']")).click();

		driver.switchTo().alert().sendKeys("London");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		driver.switchTo().window(parentWindowHandle);

		System.out.println("Window Handles test case 2 passed!");
		// ------------
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
