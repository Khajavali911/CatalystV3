/**
 * 
 */
package catalyst.automation.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.GherkinKeyword;

//import com.mongodb.diagnostics.logging.Logger;

import catalyst.base.BaseUtil;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.*;
import org.apache.log4j.Logger;

/**
 * @author E000911
 *
 */
public class Selenide extends BaseUtil{
	public final static Logger LOG = Logger.getLogger(Selenide.class);
	protected boolean reportIndicator = true;

	protected boolean click(By locator, String locatorName) throws Throwable {
		boolean status = false;
		try {		
			//LOG.info("Class name" + getCallerClassName() + "Method name : " + getCallerMethodName());
			LOG.info("Method : click  ::  Locator : " + locatorName);
			WebDriverWait wait = new WebDriverWait(Driver.browser, 15);
			LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			LOG.info("Clicked on the Locator");
			Driver.browser.findElement(locator).click();
			//Driver.findElement(locator).click();
			LOG.info("identified the element :: " + locator);
			status = true;
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
			BaseUtil.scenarioDef.pass("entered text as khaja");
		} finally {
			if (!status) {
					//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
				BaseUtil.scenarioDef.pass("entered text as khaja");
			} else {
				//reporter.SuccessReport("Click : " + locatorName, msgClickSuccess + locatorName);
				BaseUtil.scenarioDef.pass("entered text as khaja");
			}
		}
		return status;
	}
	/* To provides the web element based on locator
	 * 
	 * 
	 */
	public static WebElement getElement(By locator,int defaultwait) throws Throwable {
		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(Driver.browser, defaultwait);
			LOG.info("Locator is Visible :: " + locator);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
			LOG.info("Clicked on the Locator");
			webelement= Driver.browser.findElement(locator);
			//Driver.findElement(locator).click();
			LOG.info("identified the element :: " + locator);
			return webelement;
		} catch (Exception e) {
			
			//LOG.info(e.getMessage());
			//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
			//BaseUtil.scenarioDef.createNode("Find Element Failure ").fail(e.getMessage());
			
			
		} finally {
			
		}
		return webelement;
	}	
	
	public static WebElement getFluentElement(By locator,int defaultwait) throws Throwable {
		WebElement webelement = null;
		try {
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(Driver.browser)
					.withTimeout(defaultwait, TimeUnit.SECONDS)
					.pollingEvery(500,TimeUnit.MILLISECONDS)
					.ignoring(NoSuchElementException.class);
			Function<WebDriver,WebElement> function = new Function<WebDriver,WebElement>(){
				@Override
				public WebElement apply(WebDriver t) {
					// TODO Auto-generated method stub
					WebElement element =t.findElement(locator);
					return element;
				}			
			};
			wait.until(function);
					
		} catch (Exception e) {
			
			LOG.info(e.getMessage());
			//reporter.failureReport("Click : ", msgClickFailure + locatorName, driver);
			BaseUtil.scenarioDef.fail("getFluentElement: Unable to find element");
		} 
		finally {
			
		}
		return webelement;
	}	

	/* Action Engine Methods */

	/**
	 * selectDropdownByIndex Selects the option at the given index in the dropdown
	 * specified by the given locator and logs the selection
	 * 
	 * @param locator     of (By) - the specification of the location of the
	 *                    dropdown selector element
	 * @param index       of (int) the index of the option that's being selected
	 *                    from the dropdown Here index starts with Zero(0)
	 * @param locatorName of (String) label, or short description of the dropdown
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean selectDropdownByIndex(By locator, int index, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			LOG.info("Class name" + Selenide.class + "Method name : selectDropdownByIndex" );
			LOG.info("Method : selectDropdownByIndex ::  Locator : " + locatorName);
			Select s = new Select(Driver.browser.findElement(locator));
			s.selectByIndex(index);
			flag = true;
			return true;
		} catch (Exception e) {
			LOG.info("Class name" + Selenide.class + "Method name : selectDropdownByIndex" );
			throw new RuntimeException(e);
		} finally {
			if (!flag) {
				if (reportIndicator) {
					BaseUtil.scenarioDef.pass("Selected Dropdown By index ");
				} 
				
			}
			reportIndicator = true;
		}
	}

	/**
	 * selectDropdownByValue Selects the option with the given value in the dropdown
	 * specified by the given locator and logs the selection
	 *
	 * @param locator     of (By)
	 * @param value       of (String) - the 'value' name of the option that's being
	 *                    selected from the dropdown
	 * @param locatorName of (String) - label or short description of the dropdown
	 * @return boolean
	 * @throws Throwable the throwable
	 */

	protected boolean selectDropdownByValue(By locator, String value, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			LOG.info("Class name: Selinide "+ "Method name : selectDropdownByValue" );
			LOG.info("Method : selectDropdownByValue  ::  Locator : " + locatorName);
			Select s = new Select(Driver.browser.findElement(locator));
			s.selectByValue(value);
			flag = true;
			LOG.info("Successfully selected the value" + locatorName);
			return true;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (!flag) {
				BaseUtil.scenarioDef.fail("Option with value attribute : " + value + " is Not Select from the DropDown : " + locatorName);
			} else {
				BaseUtil.scenarioDef.pass("Option with value attribute : " + value + " is  Selected from the DropDown : " + locatorName);
			}
		}
	}

	/**
	 * selectDropdownByVisibleText - Selects the option with the given displayed
	 * name in the dropdown specified by the given locator
	 *
	 * @param locator     of (By)
	 * @param visibleText of (String) - the displayed name of the option that's
	 *                    being selected from the dropdown
	 * @param locatorName of (String) - label or short description of the dropdown
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean selectDropdownByVisibleText(By locator, String visibleText, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.browser.findElement(locator));
			s.selectByVisibleText(visibleText.trim());
			flag = true;
			return true;
		} catch (Exception e) {
			// return false;

			throw new RuntimeException(e);
		} finally {
			if (!flag) {
				BaseUtil.scenarioDef.fail("Select "+ visibleText + " is Not Select from the DropDown" + locatorName);
			} else {
				BaseUtil.scenarioDef.pass("Select "+ visibleText + "  is Selected from the DropDown" + locatorName);
			}
		}
	}
    

	/**
	 * waitForVisibilityOfElement provides an explicit wait of 60 seconds until the
	 * element is visible before throwing an exception
	 *
	 * @param by          of (By)
	 * @param locatorName of (String) - Name of the Locator
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean waitForVisibilityOfElement(By by, String locatorName) throws Throwable {
		boolean flag = false;
		LOG.info("Class name:Selinide Method name : waitForVisibilityOfElement" );
		
		WebDriverWait wait = new WebDriverWait(Driver.browser, 30);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			return true;
		} catch (Exception e) {
			LOG.info("Class name Selinide and Method name : waitForVisibilityOfElement" );
			return false;
		} finally {
			if (!flag) {
				BaseUtil.scenarioDef.fail("Visible of element is false :: Element :: " + locatorName + " is not visible");
			} else {
				BaseUtil.scenarioDef.pass("Visible of element is true :: , Element :: " + locatorName + "  is visible");
			}
		}
	}

	/**
	 * waitForInVisibilityOfElement provides an explicit wait of 25 seconds until
	 * the element is visible before throwing an exception
	 *
	 * @param by          of (By)
	 * @param locatorName of (String) - Name of the Locator
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean waitForInVisibilityOfElement(By by, String locatorName) throws Throwable {
		boolean flag = false;
		LOG.info("Class name:Selinide Method name : waitForInVisibilityOfElement" );
		//LOG.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locatorName);
		WebDriverWait wait = new WebDriverWait(Driver.browser, 15);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			flag = true;
			return true;
		} catch (Exception e) {
			LOG.info("Class name Selinide and Method name :waitForInVisibilityOfElement ");
			return false;
		} finally {
			if (!flag) {
				BaseUtil.scenarioDef.fail("InVisible of element is false ::, Element :: " + locatorName + " is visible");
			} else {
				BaseUtil.scenarioDef.pass("InVisible of element is true :: ,Element :: " + locatorName + "  is not visible");
			}
		}
	}

	/**
	 * waitForInVisibilityOfElement provides an explicit wait of 25 seconds until
	 * the element is visible before throwing an exception
	 *
	 * @param by of (By)
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean waitForInVisibilityOfElement(By by) throws Throwable {
		boolean flag = false;
		LOG.info("Class name Selinide Method name : waitForInVisibilityOfElement" );
		WebDriverWait wait = new WebDriverWait(Driver.browser, 15);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			flag = true;
			return true;
		} catch (Exception e) {
			LOG.info("Class name: Selinide and Method name : waitForInVisibilityOfElement");
			return false;
		}
	}
	
	/**
	 * assertTextMatching verifies whether actual text using locator and getText
	 * method matches to the text provided
	 *
	 * @param by          of (By)
	 * @param text        of (String)
	 * @param locatorName of (String) - Name of the element/locator
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected void assertText(By by, String expected, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			LOG.info("Class name : Selenide and Method name : ");
			LOG.info("Method : assertText  ::  Locator : " + locatorName);
			String ActualText = getText(by, locatorName).trim();
			LOG.info("ActualText is : " + ActualText);
			Assert.assertEquals(ActualText, expected);
			flag = true;			
		} catch (Exception e) {
			flag = false;
			
		}finally {
			if(flag) {
				BaseUtil.scenarioDef.pass("CheckPoint ::  expected  is  present  : " + locatorName);
			}
			else {
				BaseUtil.scenarioDef.fail("CheckPoint :: expected  is not present  : " + locatorName);
			}
		}
	}
	
	
	/**
	 * getText -- Get text of the given locator
	 *
	 * @param locator     of (By)
	 * @param locatorName of (String) - Name of the locator
	 * @return String - Returns text from given locator
	 * @throws Throwable the throwable
	 */
	protected String getText(By locator, String locatorName) throws Throwable {
		String text = "";
		boolean flag = false;
		LOG.info("Class name Selinide Method name : getText");
		try {
			waitTime();
			boolean value = isElementDisplayed(locator, locatorName);
			if (value) {
				text = Driver.browser.findElement(locator).getText();
				LOG.info("Locator is Visible and text is retrieved :: " + text);
				flag = true;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			if (!flag) {				
				BaseUtil.scenarioDef.fail("GetText ::  Unable to get Text from ::" + locatorName);
			} else {
				BaseUtil.scenarioDef.pass("GetText ::" + locatorName + " is: "+text);
				LOG.info("Locator is Visible and text is retrieved :: " + text);
			}
		}
		return text;
	}

	/**
	 * isElementVisibleOnly
	 *
	 * @param locator     of (By)
	 * @param locatorName of (String)
	 * @return boolean
	 * @throws Throwable the throwable
	 */
	protected boolean isElementDisplayed(By locator, String locatorName) throws Throwable {
		boolean flag;
		try {
			//LOG.info("Class name :: " + getCallerClassName() + " Method name :: " + getCallerMethodName());
			//LOG.info("Method : " + getCallerMethodName() + "  ::  Locator : " + locatorName);
			WebDriverWait wait = new WebDriverWait(Driver.browser, 3);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			flag = Driver.browser.findElement(locator).isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * waitTime - waits the execution time
	 *
	 * @throws Throwable the throwable
	 */
	// TODO
	private void waitTime() throws Throwable {
		String time = "10";
		long timeValue = Long.parseLong(time);
		Thread.sleep(timeValue);
		LOG.info("Time out value is : " + timeValue);
	}


     
}

