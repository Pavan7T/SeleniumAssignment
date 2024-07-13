package pageObjectTask;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebFormAutomation_PO {

	WebDriver driver;
	WebDriverWait wait;
	private String url = "https://demoqa.com/automation-practice-form";
	private String name = "John";
	private String surname = "Doe";
	private String Email = "john.doe@gmail.com";
	private String mobNo = "9977885544";
	private String sub = "science";

	@FindBy(id = "firstName")
	private WebElement username;

	@FindBy(id = "lastName")
	private WebElement lastname;

	@FindBy(xpath = "//input[@placeholder='name@example.com']")
	private WebElement mailbox;

	@FindBy(xpath = "//label[@for='gender-radio-1']")
	private WebElement gender;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	private WebElement mobilebox;

	@FindBy(id = "subjectsInput")
	private WebElement subject;

	@FindBy(id = "dateOfBirthInput")
	private WebElement dob;

	public WebFormAutomation_PO() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	public void fillWebform() {
		username.sendKeys(name);
		System.out.println("UserName: " + username.getAttribute("value"));
		lastname.sendKeys(surname);
		System.out.println("UserName: " + lastname.getAttribute("value"));
		mailbox.sendKeys(Email);
		mobilebox.sendKeys(mobNo);

		dob.clear();
		dob.sendKeys("04 Jul 1998");

		wait.until(ExpectedConditions.visibilityOf(gender));
		if (!gender.isSelected()) {
			gender.click();
		} else {
			System.out.println("Gender is already selected");
		}

		subject.sendKeys("Science");
		System.out.println("Form filled succesfully");
	}

	public void closeBrowser() {
		driver.quit();
	}

}
