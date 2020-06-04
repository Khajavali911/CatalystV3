package catalyst.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import catalyst.automation.utility.Selenide;

public class YoutubeSearchPageElementMap extends BasePageElementMap {

	public YoutubeSearchPageElementMap(WebDriver driver) {
		super(driver);		
	}
	/*@FindBy(id="search")
	public WebElement searchelement; */
	
	@FindBy(id = "search-icon-legacy")
	public WebElement searchelementbutton;
	

    public WebElement searchelement() throws Throwable {
		return Selenide.getElement(By.id("search"),15);    	
    }
}
