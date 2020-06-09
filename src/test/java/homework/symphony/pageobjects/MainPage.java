package homework.symphony.pageobjects;

import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.pageobjects.components.LowerLinkBar;
import homework.symphony.pageobjects.components.UpperToolbar;

/** 
 * Class to describe the elements of the Main page and high level actions and checks that can be performed on it.
 */
public class MainPage {
	
	WebDriver driver;
	Reporter reporter;
	
	LowerLinkBar lowerLinkBar;
	UpperToolbar upperToolbar;
	
	public MainPage(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup components
		this.lowerLinkBar = new LowerLinkBar(driver, reporter);
		this.upperToolbar = new UpperToolbar(driver, reporter);
	}
	
	/** 
	 * Access the page object of the sub component UpperToolbar.
	 */
	public UpperToolbar getUpperToolbar() {
		return upperToolbar;
	}
	
	/** 
	 * Access the page object of the sub component LowerLinkBar.
	 */
	public LowerLinkBar getLowerLinkBar() {
		return lowerLinkBar;
	}
}
