package homework.symphony.framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/** 
 * Base class for component and system tests using Selenium.
 */
public class SeleniumTest {
	
	/** 
     * Selenium WebDriver to be used through the test run.
     * By default, it is set as a Chrome driver, but can be changed to Firefox or IE by setting the system property browser to firefox or ie.
     */
	protected WebDriver driver;
	
	/** 
     * Reporter instance to be used through the test run.
     */
	protected Reporter reporter;
	
	/** 
     * URL loaded qt the beginning of the test.
     * By default, it is set to http://my.symphony.com, but can be changed by setting the system property url (don't forget http://).
     */
	protected String url;
	
	public SeleniumTest() {
		reporter = new Reporter(driver, this.getClass().getSimpleName());
		reporter.startReport();
	}
	
	protected void setUp() throws Exception {
		setupBrowser();
		setupUrl();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		reporter.setWebDriver(driver);	  
	}
	
	protected void tearDown() throws Exception {
		reporter.finalizeReport();
		if(driver != null) driver.close();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public Reporter getReporter() {
		return reporter;
	}
	
	private void setupBrowser() {
		String browser = System.getProperty("browser");
		if(browser == null) {
			browser = "chrome";
		}
		
		switch (browser) {
	        case "firefox": System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
	    					driver = new FirefoxDriver();
	    					break;
	        case "ie":  	System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
							driver = new InternetExplorerDriver();
							break;
	        case "chrome": 	System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
							driver = new ChromeDriver();
							break;
			default:		throw new AssertionError("Browser "+ browser + " not supported.");
	    }
	}
	
	private void setupUrl() {
		url = System.getProperty("url");
		
		if (url==null || url == "") {
			url = "http://my.symphony.com";
		}
	}
}
