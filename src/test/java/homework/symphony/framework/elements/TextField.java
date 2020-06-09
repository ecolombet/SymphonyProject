package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web element containing text and specific actions that can be performed on it.
 */
public class TextField extends Element {
	
	
	public TextField(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Get the text from the element.
	 * @ String
	 */
	public String getText() {
		return findElement(identifier).getText();
	}
}
