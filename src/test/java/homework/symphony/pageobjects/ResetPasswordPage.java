package homework.symphony.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.Button;
import homework.symphony.framework.elements.Element;
import homework.symphony.framework.elements.Input;
import homework.symphony.framework.elements.Link;
import homework.symphony.pageobjects.components.ErrorBanner;

/** 
 * Class to describe the elements of the Reset Password page and high level actions and checks that can be performed on it.
 */
public class ResetPasswordPage {
	
	WebDriver driver;
	Reporter reporter;
	
	Input emailInput;
	By emailInputId = By.cssSelector("#recover-form input[name=recover-email]");
	
	Link cancelLink;
	By cancelLinkId = By.className("signup-link");
	
	Element captchaElement;
	By captchaElementId = By.className("recaptcha-checkbox-border");
	
	Button resetPasswordButton;
	By resetPasswordButtonId = By.cssSelector("button[name=recover-submit]");
	
	ErrorBanner errorBanner;	
	
	public ResetPasswordPage(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup elements
		this.emailInput = new Input(driver,reporter, emailInputId);
		this.cancelLink = new Link(driver,reporter, cancelLinkId);
		this.captchaElement = new Element(driver,reporter, captchaElementId);
		this.resetPasswordButton = new Button(driver,reporter, resetPasswordButtonId);
		
		// Setup components
		this.errorBanner = new ErrorBanner(driver, reporter);
		
		// Check mandatory elements
		reporter.assertTrue("Email input is displayed", emailInput.isDisplayed());
		reporter.assertTrue("Reset password button is displayed", resetPasswordButton.isDisplayed());
	}
	
	/** 
	 * Access the page object of the sub component Error Banner.
	 */
	public ErrorBanner getErrorBanner() {
		return errorBanner;
	}
	
	/** 
	 * Fill the email input.
	 */
	public void fillEmail(String input) {
		reporter.reportAction("Fill email input with " + input);
		emailInput.fillInput(input);
		reporter.takeScreenshot("fillEmailInput");
	}
	
	/** 
	 * Click on Reset.
	 */
	public void reset(){
		reporter.reportAction("Click on Reset Password button");
		resetPasswordButton.clickOnButton();
		reporter.takeScreenshot("clickOnReset");
	}
	
	/** 
	 * Click on cancel
	 */
	public void cancel(){
		reporter.reportAction("Click on Cancel link");
		cancelLink.clickOnLink();
		reporter.takeScreenshot("clickOnCancel");
	}
	
	/** 
	 * Validate the CAPTCHA (not tested)
	 */
	public void validateCaptcha(){
		reporter.reportAction("Click on CAPTCHA");
		captchaElement.click();
		reporter.takeScreenshot("clickOnCaptcha");
	}
}
