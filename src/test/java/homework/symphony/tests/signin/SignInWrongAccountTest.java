package homework.symphony.tests.signin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.SigninPage;

public class SignInWrongAccountTest extends SeleniumTest{
	
	private String INVALID_ACCOUNT_ERROR_MESSAGE = "Invalid username or password.";

	public SignInWrongAccountTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSignInFailedWrongAccount() {
		reporter.reportTest("Sign in failed - wrong account");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Enter an invalid email address and any password");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.fillEmail("test@test.com");
		loginPage.fillPassword("anything");
		
		reporter.reportStep("Click on Sign in and check the error");
		loginPage.signIn();
		loginPage.getErrorBanner().checkErrorMessage(INVALID_ACCOUNT_ERROR_MESSAGE);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
