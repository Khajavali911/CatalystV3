/**
 * 
 */
package catalyst.base;

import java.io.IOException;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author E000911
 *
 */
public class Hooks {
	
	//private DataServices services;
	private static ExtentReportUtil extentreportUtil=new ExtentReportUtil();
	
	private static boolean isReportRunning;
	
	@Before
	public void BeforeScenario()
	{
		if(!isReportRunning) {
			
			extentreportUtil.ExtentReport();
		    isReportRunning = true;				
		}
		System.out.print("before scenario from hook");
	}
	
	@After
	public void AfterScenario(Scenario scenario) throws IOException
	{
		/*String screenshotfilename = "file.png";
				if(scenario.isFailed())
				{
					extentreportUtil.ExtentReportScreenShot();
					
				}
				extentreportUtil.creatTest(scenario, screenshotfilename);*/
		
		System.out.print("after scenario");
		 extentreportUtil.FlushReport();
	}
	

}
