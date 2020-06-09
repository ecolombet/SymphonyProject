package homework.symphony.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.TextField;

/** 
 * Class to describe the elements of the error banner and high level actions and checks that can be performed on it.
 */
public class ErrorBanner {
	
	WebDriver driver;
	Reporter reporter;
	
	TextField errorBanner;
	By errorBannerId = By.cssSelector("#sysMsg.show");
	
	public ErrorBanner(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup elements
		this.errorBanner = new TextField(driver,reporter, errorBannerId);
	}
	
	/** 
	 * Check if the error banner is displayed. Report an error if not.
	 */
	public void checkErrorBannerPresence(){
		reporter.reportAction("Check for error presence");
		reporter.assertTrue("Error is raised", errorBanner.isDisplayed());	
		reporter.takeScreenshot("getErrorBanner");
	}
	
	/** 
	 * Check if the error message from the banner corresponds to the expected one. Report an error if not.
	 */
	public void checkErrorMessage(String expectedError){
		reporter.reportAction("Check for error message: "+expectedError);
		reporter.assertTrue("Error is raised", errorBanner.isDisplayed());
		reporter.assertEquals("Error message is correct", expectedError, errorBanner.getText());	
		reporter.takeScreenshot("getError");
	}
}
