package homework.symphony.tests.signup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.SigninPage;
import homework.symphony.pageobjects.SignupPage;

public class SignUpPasswordComplexicityTest extends SeleniumTest{
	
	private String SIGNUP_INVALID_PASSWORD_ERROR_MESSAGE = "Please provide a valid password.";

	public SignUpPasswordComplexicityTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSignUpPasswordComplexity() {
		reporter.reportTest("Sign up - password Complexity");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Click on the sign up link");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.signUp();
		SignupPage signupPage = new SignupPage(getDriver(), getReporter());
		
		reporter.reportStep("Fill all inputs and set the password without lower case character. Click on Next");
		signupPage.fillFirstName("Bob");
		signupPage.fillLastName("Tester");
		signupPage.fillEmail("bob.tester@symphony.com");
		signupPage.fillPassword("P123!");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_INVALID_PASSWORD_ERROR_MESSAGE);
		
		reporter.reportStep("Set the password without upper case character. Click on Next");
		signupPage.fillPassword("assword123!");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_INVALID_PASSWORD_ERROR_MESSAGE);
		
		reporter.reportStep("Set the password without number. Click on Next");
		signupPage.fillPassword("Password!");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_INVALID_PASSWORD_ERROR_MESSAGE);
		
		reporter.reportStep("Set the password without special character. Click on Next");
		signupPage.fillPassword("Password123");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_INVALID_PASSWORD_ERROR_MESSAGE);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
