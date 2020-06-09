package homework.symphony.tests.resetpassword;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.ResetPasswordPage;
import homework.symphony.pageobjects.SigninPage;

public class ResetPasswordWrongEmailTest extends SeleniumTest{
	
	private String RESET_PASSWORD_INVALID_INPUT_ERROR_MESSAGE = "An e-mail address is required.";

	public ResetPasswordWrongEmailTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testResetPasswordWrongEmail() {
		reporter.reportTest("Reset password - wrong email");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Click on the forgot password link");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.goToForgotPassword();
		ResetPasswordPage resetPage = new ResetPasswordPage(getDriver(), getReporter());
		
		reporter.reportStep("Enter an invalid format email and click on the Recover button.");
		resetPage.fillEmail("test");
		resetPage.reset();
		resetPage.getErrorBanner().checkErrorMessage(RESET_PASSWORD_INVALID_INPUT_ERROR_MESSAGE);
		
		reporter.reportStep("Click on Cancel");
		resetPage.cancel();
		loginPage.checkEmailDisplay();
		
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
