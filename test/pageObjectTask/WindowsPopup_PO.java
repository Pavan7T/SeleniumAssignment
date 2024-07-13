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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowsPopup_PO {

	WebDriver driver;
	WebDriverWait wait;
	private String url = "https://nichethyself.com/tourism/home.html";

	@FindBy(xpath = "//a[text()='Customized tours']")
	private WebElement cmzTourBtn;

	@FindBy(xpath = "//button[text()='Contact us!']")
	private WebElement contactUs;

	@FindBy(xpath = "//a[@onclick='prompty()']")
	private WebElement prompty;

	@FindBy(xpath = "//select[@id='days']")
	private WebElement dropDown;

	public WindowsPopup_PO() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void homeLogin() {

		String parentWindowHandle = driver.getWindowHandle();
		cmzTourBtn.click();

		Set<String> AllopenWindow = driver.getWindowHandles();

		for (String window : AllopenWindow) {
			if (window.equals(parentWindowHandle)) {
				continue;
			}
			driver.switchTo().window(window);
			System.out.println(driver.getTitle());
			// driver.findElement(By.xpath("//a[text()='Customized tours']")).click();
			// Thread.sleep(2000);

			Select makeSelect = new Select(dropDown);
			makeSelect.selectByIndex(2);

		}

		driver.switchTo().window(parentWindowHandle);
		System.out.println(driver.getTitle());

		contactUs.click();
		driver.switchTo().window("Contact");
		prompty.click();

		driver.switchTo().alert().sendKeys("London");
		driver.switchTo().alert().accept();
		driver.switchTo().window(parentWindowHandle);

		System.out.println("Window Handles test case 2 passed!");
	}

	public void broserClose() {
		driver.quit();
	}

}
