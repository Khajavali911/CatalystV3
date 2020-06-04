package catalyst.automation.stepdef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.IGherkinFormatterModel;

import bsh.Console;
import catalyst.automation.model.Category;
import catalyst.automation.model.Pet;
import catalyst.automation.model.Tag;
import catalyst.automation.utility.APIConstant;
import catalyst.automation.utility.RestAssuredExtention;
import catalyst.base.BaseUtil;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;

import io.restassured.response.ResponseOptions;





public class apiteststepdef {
	public static ResponseOptions<Response> response;
    public static String token;
    
    
   	@Before
   	public void BeforeScenario(Scenario scenario) throws ClassNotFoundException
   	{
   		//if(extentreportUtil != null) {
   	//	BaseUtil.features = BaseUtil.extent.createTest(Feature.class, "youtube feature");
   		//BaseUtil.features  = BaseUtil.extent.createTest(new GherkinKeyword("Feature"),"API validation");
   		//BaseUtil.scenarioDef  = BaseUtil.features.createNode(new GherkinKeyword("Scenario"),scenario.getName());
   			// features.createNode((Class<? extends IGherkinFormatterModel>) Scenario.class, scenario.getName());
   		
   	}
    @Given("^I perform GET operation for \"([^\"]*)\"$")
	    public void iPerformGETOperationFor(String url) throws Throwable {
		 RestAssuredExtention restassured =new RestAssuredExtention(url, APIConstant.ApiMethods.GET,null);	      
		 response= restassured.ExecuteWithOutPathParams();
		  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given: I perform GET operation for "+url).pass("I perform GET operation");
		
		// restassured.typicode
	    }
    
    @Given("^I ensure to Perform POST operation for \"([^\"]*)\" with body as$")
    public void iEnsureToPerformPOSTOperationForWithBodyAs(String url, io.cucumber.datatable.DataTable table) throws Throwable {
    	try {
        List<String> data = table.row(1);
        Map<String, String> body = new HashMap<>();
      
        body.put("id",data.get(0));
        body.put("name",data.get(1));
        body.put("status", data.get(2)); 
        RestAssuredExtention restassured =new RestAssuredExtention(url, APIConstant.ApiMethods.POST,null);
        response = restassured.PostOpsWithBody(url, body);
      
        if(response.getStatusCode() == 200)
        {
        	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Given: I ensure to Perform POST operation for "+url).pass("Updated pet details as ID " +data.get(0)+" Name "+data.get(1) + " Status " +data.get(2));
        }
        //Perform post operation
      //  response= restassured.PostOpsWithBody(url, );
    	}
    	catch(Exception ex) {
    		
    		String msg =ex.getMessage();
    	}
    }
    @Then("I should get availble pet list")
    public void ValidateAvailablePetList()
    {
    String s=	response.getBody().jsonPath().get().toString();
    List<Pet> pets =new ArrayList<Pet>();
    pets=	response.getBody().as(pets.getClass());  
	    if(response.getStatusCode() == 200)
	    {
	    	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Given.class, "Then: I should get availble pet list").pass("Availbale Pets list successfully retrived");
	    }
    }
    
    @And("^I Perform DELETE operation for \"([^\"]*)\"$")
    public void iPerformDELETEOperationFor(String url, io.cucumber.datatable.DataTable table) throws Throwable {
    	List<String> data = table.row(1);
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("id", data.get(0));
        RestAssuredExtention restassured =new RestAssuredExtention(url, APIConstant.ApiMethods.DELETE,null);
        //Perform Delete operation
        restassured.DeleteOpsWithPathParams(pathParams);
        if(response.getStatusCode() == 200)
	    {
	    	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I Perform DELETE operation for id " +data.get(0)).pass("pet successfuly deleted");
	    }
        else {
        	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I Perform DELETE operation for id " +data.get(0)).fail("pet deletion unsuccessful");
        }
    }

    @And("^I perform GET operation with path parameter for \"([^\"]*)\"$")
    public void iPerformGETOperationWithPathParameterFor(String url, io.cucumber.datatable.DataTable table) throws Throwable {
    	 List<String> data = table.row(1);

         Map<String, String> pathParams = new HashMap<String, String>();
         pathParams.put("id", data.get(0));
         RestAssuredExtention restassured =new RestAssuredExtention(url, APIConstant.ApiMethods.GET,null);         //Perform Delete operation

        response = restassured.ExecuteWithPathParams(pathParams);
        Pet pet =new Pet();
        pet=	response.getBody().as(pet.getClass());  
        
        if(response.getStatusCode() == 200)
	    {
	    	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I perform GET operation with path parameter for " +data.get(0)).pass("pet details as "+ pet.getId()+" pet name "+pet.getName()+" pet status "+ pet.getStatus());
	    }
        else {
        	  BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) And.class, "And: I perform GET operation with path parameter for " +data.get(0)).fail("unable get pet details");
        }
    }
    
    @Then("^verify user name as \\\"([^\\\"]*)\\\"$")
    public void iValidateAuthorName(String authorname) throws Throwable {
		
		String auth =response.getBody().jsonPath().get("author");
		if(auth.contains(authorname)) {
			BaseUtil.scenarioDef.createNode((Class<? extends IGherkinFormatterModel>) Then.class, "Then: Authorname matched").pass("Author name Matched");
			//BaseUtil.scenarioDef=BaseUtil.features.createNode(new GherkinKeyword("Then"), "Author Name matched").pass("pass");
		}
		
		// restassured.typicode
	    }
    
    
}
