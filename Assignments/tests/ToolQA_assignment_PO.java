package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;


//ToolQA assignment page object file
//Modification for second branch 

public class ToolQA_assignment_PO {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "firstName")
	private WebElement username;

	@FindBy(id = "lastName")
	private WebElement lastName;

	@FindBy(xpath = "//input[@id='userEmail']")
	private WebElement emailID;

	@FindBy(xpath = "//label[text()='Male']")
	private WebElement gender;

	@FindBy(xpath = "//input[@placeholder='Mobile Number']")
	private WebElement mobileNo;

	@FindBy(id = "subjectsContainer")
	private WebElement subject;

	@FindBy(id = "//input[@id='hobbies-checkbox-1']")
	private WebElement hobbies;

	@FindBy(id = "//textarea[@id='currentAddress']")
	private WebElement address;

	@FindBy(id = "react-select-3-input")
	private WebElement dropdown;

	private String url = "https://demoqa.com/automation-practice-form";
	private String Name = "John";
	private String surName = "Doe";
	private String mail = "john.doe@ntech.com";
	private String MobileNo = "9977885544";
	private String sub = "Science";
	private String adress = "Pune, Maharashtra";

	public ToolQA_assignment_PO() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
		driver.get(url);

		// get() method First checks if page is already loaded.
		// If not then call load() and then again check by calling isLoaded()
	}

	public void dataEntry() {
		username.sendKeys(Name);
		lastName.sendKeys(surName);
		emailID.sendKeys(mail);

		// gender.click();
		subject.sendKeys(sub);
		if (!hobbies.isSelected()) {
			hobbies.click();
		}
		mobileNo.sendKeys(MobileNo);
		address.sendKeys(adress);

		/*
		 * WebElement genderclick = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "//label[text()='Male']"))); genderclick.click();
		 */

		WebElement genderclick = driver.findElement(By.xpath("//label[text()='Male']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", genderclick);
		genderclick = wait.until(ExpectedConditions.elementToBeClickable(genderclick));

		// Ensure the element is enabled
		if (genderclick.isEnabled()) {
			// Click the element
			Actions actions = new Actions(driver);
			actions.moveToElement(genderclick).click().perform();
		} else {
			System.out.println("Element is not enabled");
		}

	}

	public void closeBrowser() {
		driver.quit();
	}
}
