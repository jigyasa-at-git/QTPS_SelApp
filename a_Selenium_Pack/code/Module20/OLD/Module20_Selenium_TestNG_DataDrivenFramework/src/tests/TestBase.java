package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;

import util.ErrorUtil;
import util.TestUtil;

import datatable.Xls_Reader;

public class TestBase {
	
	public static Properties config =null;
	public static Properties OR =null;
	public static WebDriver wbDv = null;
	public static EventFiringWebDriver driver=null; 
	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public static boolean loggedIn=false;
	public static Xls_Reader datatable=null;

	
	@BeforeSuite
	public void initialize() throws IOException{
		// loading all the configurations from a property file
		APPLICATION_LOGS.debug("Starting the test suite");
		APPLICATION_LOGS.debug("Loading config files");
	    config = new Properties();
		FileInputStream fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		config.load(fp);
		
		// load my xpaths
		APPLICATION_LOGS.debug("Loading Object XPATHS");
		OR = new Properties();
		 fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fp);
		// initilize datatable
		datatable=new Xls_Reader(System.getProperty("user.dir")+"\\src\\config\\Controller.xlsx");
		System.out.println(config.getProperty("browserType"));
		if(config.getProperty("browserType").equals("Firefox")){
			 wbDv = new FirefoxDriver();
		}else if(config.getProperty("browserType").equals("IE")){
			 wbDv = new InternetExplorerDriver();
		}
		APPLICATION_LOGS.debug("Starting the driver");
		// EventFiringWebDriver
		driver = new EventFiringWebDriver(wbDv);
	    driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		
	}
	

	public static WebElement getObject(String xpathKey) throws IOException{
		
    	try{
    	return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
    	}catch(Throwable t){
    		//report error
			TestUtil.takeScreenShot(xpathKey);

    		ErrorUtil.addVerificationFailure(t);
    		APPLICATION_LOGS.debug("Error came "+ t.getLocalizedMessage());;
    		return null;
    	}
    	
    }
	
	
	
	
	
	
}
