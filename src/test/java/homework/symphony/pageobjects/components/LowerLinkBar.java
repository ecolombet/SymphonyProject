package homework.symphony.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.Link;

/** 
 * Class to describe the elements of the link bar of the main page and high level actions and checks that can be performed on it.
 */
public class LowerLinkBar {
	
	WebDriver driver;
	Reporter reporter;
	
	Link signOutLink;
	By signOutLinkId = By.cssSelector(".tabs-master-buttons-wrapper a.sign-out");
	
	public LowerLinkBar(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup elements
		this.signOutLink = new Link(driver,reporter, signOutLinkId);
	}
	
	/** 
	 * Click on Sign out link.
	 */
	public void signOut(){
		reporter.reportAction("Click on Sign out link.");
		signOutLink.clickOnLink();
		reporter.takeScreenshot("clickOnSignOut");
	}
}
