package catalyst.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import catalyst.automation.utility.Selenide;

public class Elsevier_Home_Page extends BasePageElementMap{
	
	
	
	public Elsevier_Home_Page(WebDriver driver) {
		super(driver);
	}

	public @FindBy(xpath="//*[contains(@title,'Link to the homepage')]") WebElement logo;
	public @FindBy(xpath="//*[@title='View account']") WebElement login_btn;
	public @FindBy(xpath="//*[@id='signin-email']") WebElement username;
	public @FindBy(xpath="//*[@id='signin-password']") WebElement Password;
	public @FindBy(xpath="//*[contains(@value,'Log In')]") WebElement  signin_btn;
	public @FindBy(xpath="//*[@class='text-center']") WebElement login_head;
	public @FindBy(xpath="//li[@data-aa-region='Shop' and @class='dropdown-wrapper']") WebElement shop_btn;
	public @FindBy(xpath="//li[4]/div/div/div/ul/li[1]/a") WebElement books_journals;
	public @FindBy(xpath="//*[contains(@class,'clear-filter')]") WebElement clear_search;
	//public @FindBy(xpath="//*[@name='q']") WebElement serach_text;
	public @FindBy(xpath="//button[contains(@type,'submit')]") WebElement search_btn;
	public @FindBy(xpath="//*[contains(@class,'listing-form-filters-results-showing')]/span[2]") WebElement search_result;

	public @FindBy(xpath="//*[contains(@title,'Profile dropdown')]") WebElement profile;
	public @FindBy(xpath="//*[contains(@class,'sign-out-btn')]") WebElement signout;
	
	//public @FindBy(xpath="//*[contains(@class,'listing-section-products')]/div[1]//*[@class='listing-products-info-text-title']/a") WebElement product;
	//public @FindBy(xpath="//*[contains(@class,'addToCart-btn')]") WebElement preorder;
	public @FindBy(xpath="//*[contains(@class,'shopping-cart-count')]") WebElement ordercounty;
	public @FindBy(xpath="//*[contains(@class,'item-remove')]") WebElement removeItem;
	
	public WebElement preorder() throws Throwable {
	 return Selenide.getElement(By.xpath("//*[contains(@class,'addToCart-btn')]"),15);    	
    }
	
	public WebElement product() throws Throwable {
		 return Selenide.getElement(By.xpath("//*[contains(@class,'listing-section-products')]/div[1]//*[@class='listing-products-info-text-title']/a"),15);    	
	    }
	public WebElement serach_text() throws Throwable {
		 return Selenide.getElement(By.xpath("//*[@name='q']"),15);    	
	    }
	
	//public @FindBy(xpath="//*[@name='q']") WebElement serach_text;
}
