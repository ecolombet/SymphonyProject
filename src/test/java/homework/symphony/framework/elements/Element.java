package homework.symphony.framework.elements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import homework.symphony.framework.Reporter;

/** 
 * Class to manage a basic web element and actions that can be performed on it.
 */
public class Element {
	
	WebDriverWait wait;
	int TIMEOUT_IN_SESOND = 5;
	
	protected WebDriver driver;
	protected Reporter reporter;
	protected By identifier;
	
	public Element(WebDriver driver, Reporter reporter, By identifier) {
		this.driver = driver;
		this.reporter = reporter;
		this.identifier = identifier;
		this.wait = new WebDriverWait(driver, TIMEOUT_IN_SESOND);
	}
	
	/** 
	 * Check if the web element is displayed.
	 * @return boolean
	 */
	public boolean isDisplayed() {
		return findElement(identifier).isDisplayed();
	}
	
	/** 
	 * Click on the web element.
	 */
	public void click() {
		findElement(identifier).click();
	}
	
	/** 
	 * Simulate when the cursor goes over the element.
	 */
	public void mouseOver() {
		Actions action = new Actions(driver);
		action.moveToElement(findElement(identifier)).build().perform();
	}
	
	/** 
	 * Find the web element within {@value #TIMEOUT_IN_SESOND} seconds.
	 * @return WebElement
	 */
	protected WebElement findElement(By identifier) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
			return driver.findElement(identifier);
		} catch (Exception e) {
			reporter.reportError("Element " + identifier + " not found - " + e.getMessage());
			throw e;
		}
	}
	
	/** 
	 * Find the list of web elements within {@value #TIMEOUT_IN_SESOND} seconds.
	 * @return List<WebElement>
	 */
	protected List<WebElement> findElements(By identifier) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(identifier));
		return driver.findElements(identifier);
	}
}
