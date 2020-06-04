package catalyst.automation.pages;

import org.testng.asserts.SoftAssert;

public class Elsevier_Home_Page_Validator extends BasePageValidator<Elsevier_Home_Page> {

	public Elsevier_Home_Page_Validator(Elsevier_Home_Page Map1) {
		super(Map1);
		// TODO Auto-generated constructor stub
	}
	SoftAssert softAssert=new SoftAssert();
	
	public void click_signIn_icon() throws Throwable {
		this.getMap().login_btn.click();
	}
	
	public void enter_credentials(String username, String password) throws Throwable {
		this.getMap().username.sendKeys(username);
		this.getMap().Password.sendKeys(password);
	}
	
	public void click_login() throws Throwable{
		this.getMap().signin_btn.click();
	}
	
	public void click_book_shop() throws Throwable{
		this.getMap().shop_btn.click();
	}
	
	public void click_journals() throws Throwable{
		this.getMap().books_journals.click();
	}
	
	public void clear_pre_search_item() throws Throwable{
		this.getMap().clear_search.click();
	}
	public void search_item(String item) throws Throwable{
		this.getMap().serach_text().sendKeys(item);
		this.getMap().search_btn.click();
	}
	public String get_items() throws Throwable{
		
		return this.getMap().search_result.getText()+" Products";
	}
	
	public String click_item() throws Throwable {
		if(this.getMap().product() != null) {
			this.getMap().product().click();
		}
	
			if(this.getMap().product() != null) {			
			return this.getMap().product().getText();
		}
		else
		return "";
		//return this.getMap().product().getText();
	}
	
	public void click_preorder() throws Throwable{
		this.getMap().preorder().click();
	}
	
	public String get_Order_item_count() throws Throwable{
		return this.getMap().ordercounty.getText();
	}
	public void remove_item() throws Throwable{
		this.getMap().ordercounty.click();
		this.getMap().removeItem.click();
	}
	
	public void signout() throws Throwable {
		this.getMap().profile.click();
		this.getMap().signout.click();
		Thread.sleep(2000);
	}
	
}
