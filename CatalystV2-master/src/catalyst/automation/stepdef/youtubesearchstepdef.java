package catalyst.automation.stepdef;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;

import catalyst.automation.pages.Elsevier_Home_Page;
import catalyst.automation.pages.Elsevier_Home_Page_Validator;
import catalyst.automation.pages.YoutubeSearchPageElementMap;
import catalyst.automation.pages.YoutubeSearchPageValidator;

import catalyst.automation.utility.Driver;
import catalyst.automation.utility.propertiesfilereader;
import catalyst.base.BaseUtil;
import catalyst.base.ExtentReportUtil;
import catalyst.base.Hooks;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.TestNGCucumberRunner;


public class youtubesearchstepdef {
	//public static WebDriver driver;
	 propertiesfilereader obj= new propertiesfilereader();  
	 private BaseUtil base;
	 private static ExtentReportUtil extentreportUtil= new ExtentReportUtil();
	// YoutubeSearchPageElementMap youtubesearch=	new YoutubeSearchPageElementMap(Driver.browser);
	// YoutubeSearchPageValidator serachValidator = new YoutubeSearchPageValidator(youtubesearch);
	 SoftAssert softAssert=new SoftAssert();
	 
	 Elsevier_Home_Page elsevierPage = new Elsevier_Home_Page(Driver.browser);
	 Elsevier_Home_Page_Validator elsevierValidator = new Elsevier_Home_Page_Validator(elsevierPage);
	 public youtubesearchstepdef(BaseUtil base)
	 {
		this.setBase(base);
	 }
	
	 
	@Before
	public void BeforeScenario(Scenario scenario) throws ClassNotFoundException
	{
		//if(extentreportUtil != null) {
	//	BaseUtil.features = BaseUtil.extent.createTest(Feature.class, "youtube feature");
	//	BaseUtil.features  = BaseUtil.extent.createTest(new GherkinKeyword("Feature"),"Youtube feature validation");
		BaseUtil.scenarioDef  = BaseUtil.features.createNode(new GherkinKeyword("Scenario"),scenario.getName());
	}
	
	@After
	public void AfterScenario()
	{
		
	}
	
	@Given("^Open chrome browser and enter url$")
	public void open_chrome_browser_and_enter_url() throws Throwable 
	{	
		// ExtentTest feature = BaseUtil.extent.createTest("Hello Method");
	    //    ExtentTest scenario = feature.createNode((Class<? extends IGherkinFormatterModel>) Scenario.class, "Scenario");
	     //   ExtentTest given = scenario.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given").info("info");
	     //   ExtentTest and = scenario.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And").info("info");
	    //    ExtentTest when = scenario.createNode((Class<? extends IGherkinFormatterModel>) When.class, "When").info("info");
	   //     ExtentTest then = scenario.createNode((Class<? extends IGherkinFormatterModel>) Then.class, "Then").fail("pass");
	    //    ExtentTest but = scenario.createNode((Class<? extends IGherkinFormatterModel>) Then.class, "But").pass("pass");
	        BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given").pass("Open chrome browser and enter url");
	        
		
		Properties properties=obj.getProperty(); 
		
		String url=properties.getProperty("browser.baseURL");
		//BaseUtil.scenarioDef=BaseUtil.scenarioDef.log(Status.PASS, "url entered as "+url);
        Driver.browser.get(properties.getProperty("browser.baseURL"));
      //  BaseUtil.scenarioDef.log(Status.PASS, "from log file");*/
	}

	/* @When("^Enter search creteria$")
	public void enter_search_creteria() throws Throwable 
	{	
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("When"), "When: Enter text in search creteria");
		serachValidator.entertext("Khajavali");
		//BaseUtil.scenarioDef.log(Status.PASS, "entred text as Khajavali" );
		Thread.sleep(1000);	 	    
	} */

	@Then("^Click on search button$")
	public void click_on_search_button() throws Throwable 
	{
		//BaseUtil.scenarioDef=BaseUtil.scenarioDef.createNode(new GherkinKeyword("Then"), "Clicks on search button").pass("Successfully clicked on searchbutton");
		//serachValidator.clicktext();	
	}

	@When("^Click on the signin button$")
	public void click_on_signin_button() throws Throwable{
		softAssert.assertEquals(true, false,"this is msg from softasser");
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("When"), "Click on the signin button").pass("Successfully clicked on sigin button");
		elsevierValidator.click_signIn_icon();
		
	}
			
	@And("^Enter the User credentials$")
	public void enter_credentials() throws Throwable{
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Enter the User credentials").pass("Successfully Entered the User credentials");
		elsevierValidator.enter_credentials("prabhakar.ontela99@gmail.com", "8125959364");
		elsevierValidator.click_login();
	}
	@And("^Click on the Shop and Discover tab in the menu bar$")
	public void click_on_Shop() throws Throwable{
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Click on the Shop and Discover tab in the menu ba").pass("Successfully Entered the User credentials Clicked on the Shop and Discover tab in the menu ba");
		elsevierValidator.click_book_shop();
	}
	@Then("^Click on the  Books and Journals$")
	public void click_on_books() throws Throwable{
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Click on the  Books and Journals").pass("Successfully Clicked on the  Books and Journals");
		elsevierValidator.click_journals();
	}
	
	@And("^Clear the previous search item$")
	public void clear_search() throws Throwable{
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Clear the previous search item").pass("Successfully Clear the previous search item");
		elsevierValidator.clear_pre_search_item();
	}
	
	@And("^Search the java books$")
	public void search_product() throws Throwable{
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Search the java book").pass("Successfully Search the java book");
		elsevierValidator.search_item("java");
		Thread.sleep(2000);
	}
	@And("^Get the result products list$")
	public void get_result() throws Throwable{
		String result = elsevierValidator.get_items();
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Get the result products list"+result).pass("Successfully get the product list and no of Products are :"+result);
	}
	
	@Then("^Click on the first item in the serach result$")
	public void select_item() throws Throwable {
		Thread.sleep(2000);				
		String item = elsevierValidator.click_item();
		if(item!="") {
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("Then"), "Clicked on the first item in the serach result").pass("Successfully Clicked on the first item in the serach result");
		//ssoftAssert.assertAll();
		}
		else {
			//BaseUtil.scenarioDef.fail("filed to Click on the first item in the serach result").addScreenCaptureFromPath(extentreportUtil.ExtentReportScreenShot());
			BaseUtil.scenarioDef.createNode(new GherkinKeyword("Then"), "Clicked on the first item in the serach result").fail("filed to Click on the first item in the serach result").addScreenCaptureFromPath(extentreportUtil.ExtentReportScreenShot());;
		}
		softAssert.assertAll();
	}
	
	@And("^Click the pre order button$")
	public void click_preorder() throws Throwable {				
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Click the pre order button").pass("Successfully Clicked the pre order button");
		elsevierValidator.click_preorder();
		
		
	}
	
	@And("^check the item count in the cart$")
	public void verify_item_count() throws Throwable {
		String order_count=elsevierValidator.get_Order_item_count();		
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "check the item count in the cart"+order_count).pass("Successfully get the items count from the cart :"+order_count);
	}
	
	@And("^Remove the  item from thee  cart$")
	public void remove_item() throws Throwable {
		elsevierValidator.remove_item();
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Remove the  item from thee  cart").pass("Successfully Remove the  item from thee  cart");
	}
	
	@And("^Signout from the account")
	public void signout_account() throws Throwable {
		elsevierValidator.signout();
		BaseUtil.scenarioDef.createNode(new GherkinKeyword("And"), "Signout from the account").pass("Successfully Signout from the account");
	}
	
	public BaseUtil getBase() {
		return base;
	}

	public void setBase(BaseUtil base) {
		this.base = base;
	}

}