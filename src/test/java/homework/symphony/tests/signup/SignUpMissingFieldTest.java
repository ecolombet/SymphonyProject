package homework.symphony.tests.signup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.SigninPage;
import homework.symphony.pageobjects.SignupPage;

public class SignUpMissingFieldTest extends SeleniumTest{
	
	private String SIGNUP_MISSING_FIELDS_ERROR_MESSAGE = "First name, last name, email and password are required to join Symphony. Please enter all four fields.";

	public SignUpMissingFieldTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSignUpMissingField() {
		reporter.reportTest("Sign up - missing field");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Click on the sign up link");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.signUp();
		SignupPage signupPage = new SignupPage(getDriver(), getReporter());
		
		reporter.reportStep("Fill all inputs except first Name. Click on Next");
		signupPage.fillFirstName("");
		signupPage.fillLastName("Tester");
		signupPage.fillEmail("bob.tester@symphony.com");
		signupPage.fillPassword("Password123!");
		signupPage.goToNextPage();;
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_MISSING_FIELDS_ERROR_MESSAGE);
		
		reporter.reportStep("Fill all inputs except last Name. Click on Next");
		signupPage.fillFirstName("Bob");
		signupPage.fillLastName("");
		signupPage.fillEmail("bob.tester@symphony.com");
		signupPage.fillPassword("Password123!");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_MISSING_FIELDS_ERROR_MESSAGE);
		
		reporter.reportStep("Fill all inputs except email. Click on Next");
		signupPage.fillFirstName("Bob");
		signupPage.fillLastName("Tester");
		signupPage.fillEmail("");
		signupPage.fillPassword("Password123!");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_MISSING_FIELDS_ERROR_MESSAGE);
		
		reporter.reportStep("Fill all inputs except password. Click on Next");
		signupPage.fillFirstName("Bob");
		signupPage.fillLastName("Tester");
		signupPage.fillEmail("bob.tester@symphony.com");
		signupPage.fillPassword("");
		signupPage.goToNextPage();
		signupPage.getErrorBanner().checkErrorMessage(SIGNUP_MISSING_FIELDS_ERROR_MESSAGE);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
