package homework.symphony.framework;

import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/** 
 * Class to report steps and failures during the test run and compile a html report per test.
 */
public class Reporter {
	String reportName;
	WebDriver driver;
	StringBuilder htmlStringBuilder;
	
	public Reporter(WebDriver driver, String testName) {
		this.driver = driver;
		this.reportName = testName;
		this.htmlStringBuilder=new StringBuilder();
	}
	
	public void setWebDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	/** 
	 * Start the html report for the current test run.
	 */
	public void startReport() {
        //append html header and title
        htmlStringBuilder.append("<html><head><title>Selenium Test Report - " + reportName + "</title></head>");
        //append body
        htmlStringBuilder.append("<body>");
        htmlStringBuilder.append("<h1>Selenium Test Report - " + reportName + "</h1>");
    }
	
	/** 
	 * Close and write the html report with the same name as the test class in target/surefire-reports folder. 
	 */
	public void finalizeReport() {
        try {
            //close html file
            htmlStringBuilder.append("</body></html>");
            //write html string content to a file
            WriteToFile(htmlStringBuilder.toString(),"target\\surefire-reports\\" + reportName + ".html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	/** 
	 * Add to the report the test name. 
	 */
	public void reportTest(String testName) {
		htmlStringBuilder.append("<h2>Test: " + testName + "</h2>");
	}
	
	/** 
	 * Add to the report a step detail. 
	 */
	public void reportStep(String stepName) {
		htmlStringBuilder.append("<h3>Step: " + stepName + "</h3>");
	}
	
	/** 
	 * Add to the report an action detail. 
	 */
	public void reportAction(String actionName) {
		htmlStringBuilder.append("<p>" + actionName + "</p>");
	}
	
	/** 
	 * Add to the report an error. 
	 */
	public void reportError(String message) {
		htmlStringBuilder.append("<h4 style='color:red'>" + message + "</h4>");
	}
	
	/** 
	 * Add to the report a screenshot. The image will be stored in target/surefire-reports/screenshots with a unique name based on the name give in parameter and the timestamp
	 */
	public void takeScreenshot(String imageName) {
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String uniqueId = new SimpleDateFormat("HHmmssmm").format(timestamp);
			String imageUniqueName = imageName + "_" + uniqueId +".png";
			String fileLocation = ".\\target\\surefire-reports\\screenshots\\"+ imageUniqueName;
			
			FileUtils.copyFile(scrFile, new File(fileLocation));
			htmlStringBuilder.append("<img src='screenshots\\" + imageUniqueName + "'>");
		} catch(IOException e) {
			htmlStringBuilder.append("<h3>Error while taking screenshot: " + e.getMessage() + "</h3>");
		}
	}
    
	/** 
	 * To assert if a condition is true and report the result.
	 * Based on org.junit.Assert.assertTrue.
	 * @throws AssertionError
	 */
	public void assertTrue(String message, boolean condition) {
		try {
			Assert.assertTrue(message, condition);
		} catch(AssertionError e) {
			htmlStringBuilder.append("<h4 style='color:red'>Error during check: " + message + " - " + e.getMessage() + "</h4>");
			throw e;
		}
	}
	
	/** 
	 * To assert if 2 objects are equal and report the result.
	 * Based on org.junit.Assert.assertEquals.
	 * @throws AssertionError
	 */
	public void assertEquals(String message, Object arg1, Object arg2)  {
		try {
			Assert.assertEquals(message, arg1, arg2);
		} catch(AssertionError e) {
			System.out.println("in catch - "+e.getStackTrace());
			htmlStringBuilder.append("<h4 style='color:red'>Error during check: " + message + " - " + e.getMessage() + "</h4>");
			throw e;
		}
	}

	private void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator+fileName;
        File file = new File(tempFile);
        // if file does exists, then delete and create a new file
        if (file.exists()) {
            try {
                File newFileName = new File(projectPath + File.separator+ "backup_"+fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer=new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }
}
