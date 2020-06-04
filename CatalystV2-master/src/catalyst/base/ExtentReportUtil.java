/**
 * 
 */
package catalyst.base;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

import catalyst.automation.utility.Driver;
import cucumber.api.Scenario;
//import catalyst.automation.utility.Driver;
/**
 * @author E000911
 *
 */
public class ExtentReportUtil extends BaseUtil{

	//private String filename = reportLocation + "\\extentreport.html";
	
	public void ExtentReport() {
		String filename = reportLocation + "extentreport.html";
		extent = new ExtentReports();
       // extent.
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filename);
		htmlReporter.loadXMLConfig("resources\\extent-config.xml");		
		extent.attachReporter(htmlReporter);
	}
	
	public String ExtentReportScreenShot() throws IOException {		
		File scr= ((TakesScreenshot)Driver.browser).getScreenshotAs(OutputType.FILE);
		Files.copy(scr,new File(reportLocation + "screenshot.png"));
		return reportLocation + "screenshot.png";
	
	}
	
	public void FlushReport() {
		extent.flush();
	}
	
}
