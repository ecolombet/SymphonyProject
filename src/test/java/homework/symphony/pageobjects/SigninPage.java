package homework.symphony.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.Button;
import homework.symphony.framework.elements.Checkbox;
import homework.symphony.framework.elements.Dropdown;
import homework.symphony.framework.elements.Element;
import homework.symphony.framework.elements.Input;
import homework.symphony.framework.elements.Link;
import homework.symphony.framework.elements.TextField;
import homework.symphony.pageobjects.components.ErrorBanner;

/** 
 * Class to describe the elements of the Sign In Page and high level actions and checks that can be performed on it.
 */
public class SigninPage {
	
	WebDriver driver;
	Reporter reporter;
	
	Input signinEmailInput;
	By signinEmailInputId = By.id("signin-email");
	
	Input signinPasswordInput;
	By signinPasswordInputId = By.id("signin-password");
	
	Button signinButton;
	By signinButtonId = By.name("signin-submit");
	
	Checkbox signinRememberCheckbox;
	By signinRememberCheckboxId = By.id("signin-remember");
	
	Link signinForgotPwdLink;
	By signinForgotPwdLinkId = By.cssSelector(".forgot-password a");
	
	Dropdown signinLanguageDropdown;
	By signinLanguageDropdownId = By.id("menu-tooltip-language-selected");
	By signinLanguageDropdownOptionJapaneseId = By.id("ja-JP");
	By signinLanguageDropdownOptionEnglishId = By.id("en-US");
	By signinLanguageDropdownOptionFrenchId = By.id("fr-FR");
	
	Element signinLanguageInfoIcon;
	By signinLanguageInfoIconId = By.cssSelector(".language-preference .tooltip__icon");
	
	TextField signinLanguageTooltip;
	By signinLanguageTooltipId = By.id("tooltiptext-language-login");
	
	Link signupLink;
	By signupLinkId = By.cssSelector(".signup-paragraph .link");
	
	ErrorBanner errorBanner;
	
	
	public SigninPage(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
			
		// Setup elements
		this.signinEmailInput = new Input(driver,reporter, signinEmailInputId);
		this.signinPasswordInput = new Input(driver,reporter, signinPasswordInputId);
		this.signinButton = new Button(driver,reporter, signinButtonId);
		this.signinRememberCheckbox = new Checkbox(driver,reporter, signinRememberCheckboxId);
		this.signinForgotPwdLink = new Link(driver,reporter, signinForgotPwdLinkId);
		this.signinLanguageDropdown = new Dropdown(driver,reporter, signinLanguageDropdownId);
		this.signinLanguageInfoIcon = new Element(driver,reporter, signinLanguageInfoIconId);
		this.signinLanguageTooltip = new TextField(driver,reporter, signinLanguageTooltipId);
		this.signupLink = new Link(driver,reporter, signupLinkId);
		
		// Setup components
		this.errorBanner = new ErrorBanner(driver, reporter);
		
		// Check mandatory elements
		reporter.assertTrue("Email input is displayed", signinEmailInput.isDisplayed());
		reporter.assertTrue("Password input is displayed", signinPasswordInput.isDisplayed());
		reporter.assertTrue("Sign in button is displayed", signinButton.isDisplayed());
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
		signinEmailInput.fillInput(input);
		reporter.takeScreenshot("fillEmailInput");
	}
	
	/** 
	 * Check if the email input is displayed. Report an error if not.
	 */
	public void checkEmailDisplay() {
		reporter.reportAction("Check if email input is displayed");
		reporter.assertTrue("Email input is displayed", signinEmailInput.isDisplayed());
		reporter.takeScreenshot("fillEmailInput");
	}
	
	/** 
	 * Fill the password input.
	 */
	public void fillPassword(String input) {
		reporter.reportAction("Fill password input with " + input);
		signinPasswordInput.fillInput(input);
		reporter.takeScreenshot("fillPasswordInput");
	}
	
	/** 
	 * Click on Sign in.
	 */
	public void signIn(){
		reporter.reportAction("Click on Sign in button");
		signinButton.clickOnButton();
		reporter.takeScreenshot("clickOnSignIn");
	}
	
	/** 
	 * Click on Remember my password.
	 */
	public void goToRememberMyPassword(){
		reporter.reportAction("Click on Remember my password checkbox.");
		signinRememberCheckbox.clickOnCheckbox();
		reporter.takeScreenshot("clickOnRememberMyPassword");
	}
	
	/** 
	 * Click on Forgot my password.
	 */
	public void goToForgotPassword(){
		reporter.reportAction("Click on Forgot my password link.");
		signinForgotPwdLink.clickOnLink();
		reporter.takeScreenshot("clickOnForgotPassword");
	}
	
	/** 
	 * Select a language.
	 */
	public void selectLanguage(String input){
		reporter.reportAction("Select " + input + " in the Language preference dropdown");
		
		switch (input) {
	        case "Japanese":  	signinLanguageDropdown.selectWithText(By.className("menu-tooltip-language-select-option"), "日本語");
	        					// should be for consistency with the other case: signinLanguageDropdown.selectWithWebElement(signinLanguageDropdownOptionJapaneseId);
	        					// but it is to demonstrate that my 2 select methods are working
	                 			break;
	        case "English":  	signinLanguageDropdown.selectWithWebElement(signinLanguageDropdownOptionEnglishId);
	                 			break;
	        case "French":  	signinLanguageDropdown.selectWithWebElement(signinLanguageDropdownOptionFrenchId);
	                 			break;
	        default: 			reporter.reportError("Language " + input + " not supported");
	                 			break;
	    }
		reporter.takeScreenshot("selectLanguage");
	}
	
	/** 
	 * Check if the text if the language preference tooltip corresponds to the expected one.
	 * Report an error if not.
	 */
	public void checkLanguageTooltipText(String expectedContent) {
		reporter.reportAction("Check the content of the language tooltip");
		signinLanguageInfoIcon.mouseOver();
		reporter.assertEquals("language tooltip content is correct", expectedContent, signinLanguageTooltip.getText());
		reporter.takeScreenshot("checkLanguageTooltipText");
	}
	
	/** 
	 * Click on Sign up.
	 */
	public void signUp(){
		reporter.reportAction("Click on Sign up link.");
		signupLink.clickOnLink();
		reporter.takeScreenshot("clickOnSignUp");
	}
	
	/** 
	 * Sign in.
	 */
	public void signInAs(String email, String password){
		reporter.reportAction("Sign in as " + email);
		fillEmail(email);
		fillPassword(password);
		signIn();
		reporter.takeScreenshot("signIn");
	}

}
