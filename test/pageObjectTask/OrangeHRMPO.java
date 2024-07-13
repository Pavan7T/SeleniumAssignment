
package pageObjectTask;

import org.testng.annotations.Test;

import net.bytebuddy.asm.Advice.Return;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.annotations.AfterClass;

public class OrangeHRMPO {

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(name = "username")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	private String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

	public OrangeHRMPO() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10),
		// Duration.ofMillis(200));
		driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

		// get();
		// get() method First checks if page is already loaded.
		// If not then call load() and then again check by calling isLoaded()
	}

	public String loginMethod(String user, String pass) {
		username.sendKeys(user);
		password.sendKeys(pass);
		submit.click();
		 String title=driver.getTitle();
		 return title;
	}

	public void closeBrowser() {
		driver.quit();
	}

	public String getTitleAfterLogin() {
		return driver.getTitle();
	}

	/*
	 * @Override protected void isLoaded() throws Error { // TODO Auto-generated
	 * method stub assertEquals(driver.getTitle(), "STC Tourism"); }
	 * 
	 * @Override protected void load() { // TODO Auto-generated method stub
	 * driver.get(url); }
	 */
}
