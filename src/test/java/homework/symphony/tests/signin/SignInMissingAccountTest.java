package homework.symphony.tests.signin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.SigninPage;

public class SignInMissingAccountTest extends SeleniumTest{
	
	private String MISSING_FIELD_ERROR_MESSAGE = "All fields are required.";

	public SignInMissingAccountTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSignInFailedMissingAccount() {
		reporter.reportTest("Sign in failed - missing account");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Fill only the password");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.fillPassword("anything");
		
		reporter.reportStep("Click on Sign in and check the error");
		loginPage.signIn();
		loginPage.getErrorBanner().checkErrorMessage(MISSING_FIELD_ERROR_MESSAGE);
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
