package homework.symphony.tests.signin;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import homework.symphony.framework.SeleniumTest;
import homework.symphony.pageobjects.SigninPage;

public class SignInLanguageSelectionTest extends SeleniumTest{
	
	public SignInLanguageSelectionTest() {
		super();
	}
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testSignInLanguageSelection() {
		reporter.reportTest("Sign in failed - Language Selection");
		
		reporter.reportStep("Navigate to my.symphony.com");
		driver.get(url);
		
		reporter.reportStep("Change the language to Japanese");
		SigninPage loginPage = new SigninPage(getDriver(), getReporter());
		loginPage.selectLanguage("Japanese");
		loginPage.checkLanguageTooltipText("言語の設定は「設定」メニューで変更できます。");
	}
	
	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}
}
