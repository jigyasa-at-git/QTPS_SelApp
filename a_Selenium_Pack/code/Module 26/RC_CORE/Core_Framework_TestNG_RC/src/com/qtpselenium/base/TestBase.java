package com.qtpselenium.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import junit.framework.Assert;

import org.apache.log4j.Logger;

import com.qtpselenium.util.ErrorUtil;
import com.qtpselenium.util.Xls_Reader;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class TestBase {
	public static Logger APP_LOGS=null;
	public static Properties CONFIG=null;
	public static Properties OR=null;
	public static Xls_Reader suiteXls=null;
	public static Xls_Reader suite_search_xls=null;
	public static Xls_Reader suite_cart_xls=null;
	public static Xls_Reader suiteCxls=null;
	public static boolean isInitalized=false;
	public static Selenium selenium=null;
	public static boolean isBrowserOpened=false;
	
	
	// initializing the Tests
	public void initialize() throws Exception{
		// logs
		if(!isInitalized){
		APP_LOGS = Logger.getLogger("devpinoyLogger");
		// config
		APP_LOGS.debug("Loading Property files");
		CONFIG = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//src//com//qtpselenium//config/config.properties");
		CONFIG.load(ip);
			
		OR = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+"//src//com//qtpselenium//config/OR.properties");
		OR.load(ip);
		APP_LOGS.debug("Loaded Property files successfully");
		APP_LOGS.debug("Loading XLS Files");

		// xls file
		suite_search_xls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//Search Suite.xlsx");
		suite_cart_xls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//Cart Suite.xlsx");
		suiteCxls = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//C suite.xlsx");
		suiteXls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\xls\\Suite.xlsx");
		APP_LOGS.debug("Loaded XLS Files successfully");
		isInitalized=true;
		}
		// selenium RC/ Webdriver
		
	}
	
	public void openBrowser(){
		if(!isBrowserOpened){
	     selenium = new DefaultSelenium("localhost",4444,
				"*"+CONFIG.getProperty("browserType"),"http://www.flipcart.com");
		selenium.start();
		selenium.windowMaximize();
		selenium.windowFocus();
	   //selenium.setSpeed("2000");
	    isBrowserOpened=true;
		}
	}
	
	
	public void closeBrowser(){
		selenium.close();
		selenium.stop();
		isBrowserOpened=false;
	}
	
	public boolean compareTitles(String expected){
		try{
			Assert.assertEquals(expected, selenium.getTitle());			
		}catch(Throwable t){
			// report error - testng results
			ErrorUtil.addVerificationFailure(t);
			return false;
		}
		
		return true;
		
	}
	
	public boolean compareNumbers(int expected, int actual){
		try{
			Assert.assertEquals(expected, actual);			
		}catch(Throwable t){
			// report error - testng results
			ErrorUtil.addVerificationFailure(t);
			return false;
		}
		
		return true;
	}
	
	public boolean compareStrings(String expected, String actual) throws InterruptedException{
		try{
			Assert.assertEquals(expected, actual);			
		}catch(Throwable t){
			// report error - testng results
			ErrorUtil.addVerificationFailure(t);
			return false;
			
		}
		// dummy  
		waitforElement("login_link",8);
		return true;
	}
	
	public boolean waitforElement(String xpathKey, long maxTime) throws InterruptedException{
		long l=0;
		while(!selenium.isElementPresent(OR.getProperty(xpathKey))){
			Thread.sleep(1000L);
			l++;
			
			if(l == maxTime)
				return false;
		}
		
		return true;
	}
	
	public void catureScreenShot(String fileName){
		selenium.captureScreenshot(System.getProperty("user.dir")+"//screenshots//"+fileName+".jpg");
	}
	
	public void reportFailure(String errormessage){
		try{	
			Assert.assertTrue(errormessage, false);
			}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
				
			}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
