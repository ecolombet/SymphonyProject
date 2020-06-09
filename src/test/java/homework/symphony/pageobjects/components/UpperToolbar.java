package homework.symphony.pageobjects.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;
import homework.symphony.framework.elements.Button;
import homework.symphony.framework.elements.Element;
import homework.symphony.framework.elements.Input;

/** 
 * Class to describe the elements of the toolbar at the top of the main Page and high level actions and checks that can be performed on it.
 */
public class UpperToolbar {
	
	WebDriver driver;
	Reporter reporter;
	
	Input searchInput;
	By searchInputId = By.className("header-search__autosuggest-input");
	
	Button settingsButton;
	By settingsButtonId = By.id("toolbar-settings");
	
	Element securityInSettingsElement;
	By securityInSettingsElementId = By.id("securitySettingsTrigger");
	
	
	public UpperToolbar(WebDriver driver, Reporter reporter) {
		this.driver = driver;
		this.reporter = reporter;
		
		// Setup elements
		this.searchInput = new Input(driver,reporter, searchInputId);
		this.settingsButton = new Button(driver,reporter, settingsButtonId);
		this.securityInSettingsElement = new Element(driver,reporter, securityInSettingsElementId);
	}
	
	/** 
	 * Fill the Search input.
	 */
	public void fillSearch(String input) {
		reporter.reportAction("Fill Search input with " + input);
		searchInput.fillInput(input);
		reporter.takeScreenshot("fillSearchInput");
	}
	
	/** 
	 * Click on Settings.
	 */
	public void goToSettings(){
		reporter.reportAction("Click on Settings button");
		settingsButton.clickOnButton();
		reporter.takeScreenshot("clickOnSettings");
	}
}
