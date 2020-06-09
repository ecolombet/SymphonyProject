package homework.symphony.framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a web dropdown and specific actions that can be performed on it.
 */
public class Dropdown extends Element {
	
	public Dropdown(WebDriver driver, Reporter reporter, By identifier) {
		super(driver, reporter, identifier);
	}
	
	/** 
	 * Get the current selected value.
	 * @return String
	 */
	public String getText() {
		return findElement(identifier).getText();
	}
	
	/** 
	 * Select a value knowing its selenium.By identifier in the dropdown list.
	 */
	public void selectWithWebElement(By elementToSelectId) {
		findElement(identifier).click();
		findElement(elementToSelectId).click();
	}
	
	/** 
	 * Select a value using text content.
	 */
	public void selectWithText(By dropdownListElementId, String text) {
		findElement(identifier).click();
		for( WebElement element : findElements(dropdownListElementId) ) {
            if (element.getText().contains(text)) {
            	element.click();
            	break;
            }
        }
	}
}
