package catalyst.automation.pages;
import com.aventstack.extentreports.reporter.*;

import org.testng.Reporter;

import com.aventstack.extentreports.GherkinKeyword;

public class YoutubeSearchPageValidator  extends BasePageValidator<YoutubeSearchPageElementMap> {

public YoutubeSearchPageValidator(YoutubeSearchPageElementMap Map1) {
		super(Map1);
		// TODO Auto-generated constructor stub
	}
	public void entertext(String searchtext) throws Throwable
    {
		//reporter.log("entered by khajavali");
    	this.getMap().searchelement().sendKeys(searchtext);
    	
    }
	public void clicktext() throws Throwable
    {
    	this.getMap().searchelementbutton.click();
    }
	
	
}
