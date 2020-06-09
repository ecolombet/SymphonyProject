package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web button and specific actions that can be performed on it.
 */
public class Button extends Element {
	
	public Button(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Click on the button.
	 */
	public void clickOnButton() {
		findElement(identifier).click();
	}
}
