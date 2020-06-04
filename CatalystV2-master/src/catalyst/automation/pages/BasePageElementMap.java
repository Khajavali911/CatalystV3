package catalyst.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageElementMap {
	private final WebDriver browser;
	public BasePageElementMap(WebDriver driver){
		this.browser = driver;		
		PageFactory.initElements(driver, this); 
	}
	
	public WebDriver getBrowser() {
		return browser;
	}
	
}
