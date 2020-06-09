package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web input field and specific actions that can be performed on it.
 */
public class Input extends Element {
	
	public Input(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Clear the input and type the content of the parameter input in it.
	 */
	public void fillInput(String input) {
		findElement(identifier).clear();
		findElement(identifier).sendKeys(input);
	}
	
	/** 
	 * Get the current text in the input.
	 */
	public String getInputText() {
		return findElement(identifier).getText();
	}
}
