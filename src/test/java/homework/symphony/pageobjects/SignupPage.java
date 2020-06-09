package homework.symphony.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.Button;
import homework.symphony.framework.elements.Input;
import homework.symphony.framework.elements.Link;
import homework.symphony.pageobjects.components.ErrorBanner;

/** 
 * Class to describe the elements of the Sign Up Page and high level actions and checks that can be performed on it.
 */
public class SignupPage {
	
	WebDriver driver;
	Reporter reporter;
	
	Input signupFirstNameInput;
	By signupFirstNameInputId = By.id("signup-first");
	
	Input signupLastNameInput;
	By signupLastNameInputId = By.id("signup-last");
	
	Input signupEmailInput;
	By signupEmailInputId = By.id("signup-email");
	
	Input signupPasswordInput;
	By signupPasswordInputId = By.id("signup-password");
	
	Button signupNextButton;
	By signupNextButtonId = By.cssSelector(".getting-started-center-aligned button");
	
	Link signupTermsAndConditionsLink;
	By signupTermsAndConditionsLinkId = By.cssSelector(".disclaimer a[text()~='Terms']");
	
	Link signupPrivacyPolicyLink;
	By signupPrivacyPolicyLinkId = By.cssSelector(".disclaimer a[text()~='Privacy']");	
	
	ErrorBanner errorBanner;
	
	public SignupPage(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup elements
		this.signupFirstNameInput = new Input(driver,reporter, signupFirstNameInputId);
		this.signupLastNameInput = new Input(driver,reporter, signupLastNameInputId);
		this.signupEmailInput = new Input(driver,reporter, signupEmailInputId);
		this.signupPasswordInput = new Input(driver,reporter, signupPasswordInputId);
		this.signupNextButton = new Button(driver,reporter, signupNextButtonId);
		this.signupTermsAndConditionsLink = new Link(driver,reporter, signupTermsAndConditionsLinkId);
		this.signupPrivacyPolicyLink = new Link(driver,reporter, signupPrivacyPolicyLinkId);
		
		// Setup components
		this.errorBanner = new ErrorBanner(driver, reporter);
		
		// Check mandatory elements
		reporter.assertTrue("First Name input is displayed", signupFirstNameInput.isDisplayed());
		reporter.assertTrue("Last Name input is displayed", signupLastNameInput.isDisplayed());
		reporter.assertTrue("Email input is displayed", signupEmailInput.isDisplayed());
		reporter.assertTrue("Password input is displayed", signupPasswordInput.isDisplayed());
		reporter.assertTrue("Sign in button is displayed", signupNextButton.isDisplayed());
	}
	
	/** 
	 * Access the page object of the sub component Error Banner.
	 */
	public ErrorBanner getErrorBanner() {
		return errorBanner;
	}
	
	/** 
	 * Fill the first name input.
	 */
	public void fillFirstName(String input) {
		reporter.reportAction("Fill first Name input with " + input);
		signupFirstNameInput.fillInput(input);
		reporter.takeScreenshot("fillFirstNameInput");
	}
	
	/** 
	 * Fill the last name input.
	 */
	public void fillLastName(String input) {
		reporter.reportAction("Fill last Name input with " + input);
		signupLastNameInput.fillInput(input);
		reporter.takeScreenshot("fillLastNameInput");
	}
	
	/** 
	 * Fill the email input.
	 */
	public void fillEmail(String input) {
		reporter.reportAction("Fill email input with " + input);
		signupEmailInput.fillInput(input);
		reporter.takeScreenshot("fillEmailInput");
	}
	
	/** 
	 * Fill the password input.
	 */
	public void fillPassword(String input) {
		reporter.reportAction("Fill password input with " + input);
		signupPasswordInput.fillInput(input);
		reporter.takeScreenshot("fillPasswordInput");
	}
	
	/** 
	 * Click on Next.
	 */
	public void goToNextPage(){
		reporter.reportAction("Click on Next button");
		signupNextButton.clickOnButton();
		reporter.takeScreenshot("clickOnNext");
	}
	
	/** 
	 * Click on Terms and Conditions.
	 */
	public void openTermsAndConditionsLink(){
		reporter.reportAction("Click on Terms and Conditions link");
		signupTermsAndConditionsLink.clickOnLink();
		reporter.takeScreenshot("clickOnTermsAndConditionsLink");
	}
	
	/** 
	 * Click on Privacy Policy.
	 */
	public void openPrivacyPolicyLink(){
		reporter.reportAction("Click on Privacy Policy link");
		signupPrivacyPolicyLink.clickOnLink();
		reporter.takeScreenshot("clickOnPrivacyPolicy");
	}
	
	/** 
	 * Fill Sign Up page and click on Next
	 */
	public void fillSignupPageAndContinue(String firstName, String lastName, String email, String password){
		reporter.reportAction("Fill Sign Up page and clcik on Next");
		fillFirstName(firstName);
		fillLastName(lastName);
		fillEmail(email);
		fillPassword(password);
		goToNextPage();
		reporter.takeScreenshot("fillSignupPageAndContinue");
	}

}
