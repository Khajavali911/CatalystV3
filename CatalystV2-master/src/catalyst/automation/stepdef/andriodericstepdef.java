package catalyst.automation.stepdef;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;
import catalyst.automation.pages.YoutubeSearchPageElementMap;
import catalyst.automation.pages.YoutubeSearchPageValidator;
import catalyst.automation.utility.Driver;
import catalyst.automation.utility.propertiesfilereader;
import catalyst.base.BaseUtil;
import catalyst.base.ExtentReportUtil;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class andriodericstepdef {
	 propertiesfilereader obj= new propertiesfilereader();  
	 private BaseUtil base;
	 private static ExtentReportUtil extentreportUtil= new ExtentReportUtil();
	
	 SoftAssert softAssert=new SoftAssert();
	 
	 @Given("^I want to launch ericbank app$")
	 public void launch_ericbank_app() throws Throwable 
	 {	
		   BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given").pass("launch eric bank app");
		        
			
			Properties properties=obj.getProperty(); 
			
			//String url=properties.getProperty("browser.baseURL");
			//BaseUtil.scenarioDef=BaseUtil.scenarioDef.log(Status.PASS, "url entered as "+url);
	     //   Driver.browser.get(properties.getProperty("browser.baseURL"));
	      //  BaseUtil.scenarioDef.log(Status.PASS, "from log file");*/
	 }
	 
	 @And("^I enter ([^\"]*) and ([^\"]*)$")
	 public void enter_user_credentials(String username,String password) throws Throwable 
	 {	
		 System.out.println(username);
		Driver.browser.findElement(By.xpath("//*[@id='usernameTextField']")).click();
		Driver.browser.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys(username);
     	Driver.browser.findElement(By.xpath("//*[@id='passwordTextField']")).click();
     	Driver.browser.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys(password);
     	BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("I entered username as "+ username + " and password"); 
	 }
	 @And("^I click loginbutton$")
	 public void click_loginbutton()
	 {
		 new WebDriverWait(Driver.browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Login']")));
		 Driver.browser.findElement(By.xpath("//*[@text='Login']")).click();
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("I click loginbutton"); 
	 }
	 
	 @Then("^I verify the successful login$")
	 public void validatesuccessfullogin()
	 {
		//*[@id='phoneTextField']
		  

		 
		 new WebDriverWait(Driver.browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Make Payment']")));
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Then.class, "Then").pass("I verify the successful login"); 
		//  Driver.browser.findElement(By.xpath("//*[@id='countryTextField']")).sendKeys("india");
		//  new WebDriverWait(Driver.browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='amountTextField']")));
		//  Driver.browser.findElement(By.xpath("//*[@id='amountTextField']")).click();
	 }
	 
	 @And("^I click on make payment$")
	 public void clickonmakepayment()
	 {
		  Driver.browser.findElement(By.xpath("//*[@text='Make Payment']")).click();
		  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("I click on make payment"); 
	 }
	 
	 @And("^I entered phnumber$")
	 public void enter_phonenumber()
	 {
		  new WebDriverWait(Driver.browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='phoneTextField']")));
		  Driver.browser.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("9676918549");
		  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("I enter phonenumber "); 
	 }
	
	 @And("^I entered candidtename ([^\"]*)$")
	 public void enter_amount(String name)
	 {
		 new WebDriverWait(Driver.browser, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='nameTextField']")));
		 Driver.browser.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys(name);
		 Driver.browser.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("1");
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("I entered name as " + name+" and amount "+ 1); 
	 }
	 
	 @And("^Select country ([^\"]*)$")
	 public void enter_country(String country)
	 {
		 Driver.browser.findElement(By.xpath("//*[@text='Select']")).click();
		 Driver.browser.findElement(By.xpath("//*[@text='"+country+"']")).click();
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass("Select " +country ); 
	 }
	 
	 @And("^I click on  send payment button$")
	 public void send_paymentbutton()
	 {
		 Driver.browser.findElement(By.xpath("//*[@text='Send Payment']")).click();
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").pass( "I click on  send payment button"); 		
		
	 }
	 
	 @Then("^Verify for successful payment$")
	 public void verify_successfulpayment()
	 {		
		 Driver.browser.findElement(By.xpath("//*[@text='Yes']")).click();
		 Driver.browser.findElement(By.xpath("//*[@text='Logout']")).click();
		 BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Then.class, "Then").pass( "Payment successfully done"); 
	 }
	 
	 

	 
}
