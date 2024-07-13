package pageObjectTask;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HerokuL1_PO {

	private WebDriver driver;
	private WebDriverWait wait;
	String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
	String url2 = "https://the-internet.herokuapp.com/dynamic_loading/2";

	@FindBy(xpath = "//button[text()='Start']") 
	private WebElement startBtn;

	public HerokuL1_PO() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); Implicits
		// wait
		// wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	public String loginToL2() {
		driver.get(url2);
		startBtn.click();
		WebElement helloworldText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		String actualtext = helloworldText.getText();
		return actualtext;
	}
	public String logIn() {
		driver.get(url);
		startBtn.click();
		WebElement helloworldText = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[text()='Hello World!']")));
		String actualtext = helloworldText.getText();
		return actualtext;
	}

	public void closeDriver() {
		driver.quit();
	}

}
