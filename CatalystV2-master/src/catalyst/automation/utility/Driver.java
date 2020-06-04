package catalyst.automation.utility;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.kohsuke.rngom.util.Uri;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Driver {
	private static WebDriverWait browserWait;
	public static RemoteWebDriver browser=null;
	static DesiredCapabilities dc = new DesiredCapabilities();
    public RemoteWebDriver getWebDriver() { return this.browser; }
    public void setWebDriver(RemoteWebDriver browser) { Driver.browser = browser; }
    public WebDriverWait getWebDriverWait() { return this.browserWait; }
    public void setWebDriverWait(WebDriverWait browserWait) { this.browserWait = browserWait; }
    public static void StartBrowser(BrowserTypes browserType,int defaultTimeOut) throws MalformedURLException
    {    
    	try {
		if(browser == null) {		
        switch (browserType)
        {
            case Firefox:
                Driver.browser = new FirefoxDriver();  
                browserWait = new WebDriverWait(Driver.browser, defaultTimeOut);
                browser.manage().deleteAllCookies();
        		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        		browser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        		browser.manage().window().maximize();	
                break;
            case InternetExplorer:
                break;
            case Chrome:
            	System.setProperty("webdriver.chrome.driver", "C:\\Walmart\\chromedriver_win32\\chromedriver.exe");
            	Driver.browser = new ChromeDriver();
            	browserWait = new WebDriverWait(Driver.browser, defaultTimeOut);
                browser.manage().deleteAllCookies();
        		browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        		browser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        		browser.manage().window().maximize();	
                break;
            case Windows:
            	//System.setProperty("webdriver.chrome.driver", "C:\\Walmart\\chromedriver_win32\\chromedriver.exe");
            	
            	//DesiredCapabilities appCapabilities = new DesiredCapabilities();
            	dc.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            	dc.setCapability("platformName", "Windows");
            	//dc.setCapability("appArguments", "MyTestFile.txt");
            	//dc.setCapability("appWorkingDir", "C:\\MyTestFolder\\");
            	Driver.browser =  new WindowsDriver<WindowsElement>(new URL("http://127.0.0.1:4727"), dc);
            	Driver.browser.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
            	Driver.browser.findElementByName("Nine").click();
            	Driver.browser.findElementByName("Seven").click();
            	Driver.browser.findElementByName("Multiply by").click();
            	//Driver.browser.
            //	Driver.browser = new ChromeDriver();
                break;
            case Andriod:
            	dc.setCapability(MobileCapabilityType.UDID, "52039761c0eaa3c9");
            	dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.experitest.ExperiBank");
            	dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".LoginActivity");
            	Driver.browser = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), dc);
            	//.browser.getKeyboard().sendKeys("admin");
            	//Driver.browser.findElement(By.xpath("//*[@id='passwordTextField']")).click();
            	//Driver.browser.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("admin");
            	//Driver.browser.findElement(By.xpath("//*[@text='Login']")).click();
            	
            default:
                break;
        }
        
		}
    	}
    	catch(Exception ex) {
    		String s = ex.getMessage();
    	}
    	
		
    	
    }
    public static void StopBrowser()
    {    
    	browser.quit();
    	browser = null;
    	browserWait = null;
    }
	
}
