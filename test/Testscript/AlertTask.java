package Testscript;

import org.testng.annotations.Test;
import pageObjectTask.AlertTask_PO;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class AlertTask {

	AlertTask_PO alert;

	@Test
	public void AlertActionsHandling() throws InterruptedException {
		alert.simpleAlert();
		alert.confirmationAlert();
		alert.PromptAlert();
	}

	@AfterMethod
	public void afterMethod() {

	}

	@BeforeClass
	public void beforeClass() {
		alert = new AlertTask_PO();
	}

	@AfterClass
	public void afterClass() {
		// alert.browserClose();
	}

}
