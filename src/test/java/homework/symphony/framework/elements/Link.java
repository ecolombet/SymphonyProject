package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web link and specific actions that can be performed on it.
 */
public class Link extends Element {
	
	public Link(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Click on the link.
	 */
	public void clickOnLink() {
		findElement(identifier).click();
	}
}
