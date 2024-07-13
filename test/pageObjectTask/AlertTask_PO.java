package pageObjectTask;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertTask_PO {

	WebDriver driver;
	WebDriverWait wait;

	private String url = "http://www.cookbook.seleniumacademy.com/Alerts.html";

	@FindBy(id = "simple")
	private WebElement AlertBtn;

	@FindBy(xpath = "//button[@id='confirm']")
	private WebElement ConfirmAlertBtn;

	@FindBy(xpath = "//button[@id='prompt']")
	private WebElement promptAlertBtn;

	/*
	 * @FindBy(xpath = "//button[@id='prompt']") private WebElement
	 * promptAlertBtn;demo
	 */

	public AlertTask_PO() {
		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(url);
		PageFactory.initElements(driver, this);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void simpleAlert() {

		// Simple Alert
		AlertBtn.click();
		try {
			String str = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();

			System.out.println("Simple Alert popup Msg: " + str);
			System.out.println("------------------------------------------------");
			assertEquals("Hello! I am an alert box!", str);
		} catch (UnhandledAlertException e) {
			fail("Alert exception");
		}
	}

	public void confirmationAlert() {

		// Confirmation Alert

		ConfirmAlertBtn.click();

		try {

			String AlertMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			String str1 = driver.findElement(By.id("demo")).getText();
			ConfirmAlertBtn.click();
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
	}

	public void PromptAlert() {

		// Prompt Alert

		promptAlertBtn.click();
		try {
			driver.switchTo().alert().sendKeys("selenium");
			String popUpMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
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

	public void browserClose() {
		driver.quit();
	}

}
