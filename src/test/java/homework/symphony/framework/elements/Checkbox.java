package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web checkbox and specific actions that can be performed on it.
 */
public class Checkbox extends Element {
	
	
	public Checkbox(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Click on the checkbox.
	 */
	public void clickOnCheckbox() {
		findElement(identifier).click();
	}
}
