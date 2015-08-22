package com.qtpselenium.app.salesforce.util;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebConnector {
	// initialize properties file
	// logging
	// selenium/webdriver layer -  selenium commands
	
	Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	Properties OR = null;
	Properties CONFIG=null;
	WebDriver driver =null;
	WebDriver mozilla=null;
	WebDriver chrome=null;
	WebDriver ie=null;
	static WebConnector w;
	
	private WebConnector(){
		
		if(OR==null){
			try{
				// initialize OR
				OR = new Properties();
				FileInputStream fs  = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qtpselenium\\app\\salesforce\\config\\OR.properties");
				OR.load(fs);
				
				// initialize CONFIG to corresponding env
				CONFIG= new Properties();
				fs  = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qtpselenium\\app\\salesforce\\config\\"+OR.getProperty("testEnv")+"_config.properties");
				CONFIG.load(fs);
				
				//System.out.println(OR.getProperty("loginusername"));
				//System.out.println(CONFIG.getProperty("loginURL"));
				
				
			}catch(Exception e){
				System.out.println("Error on intializing properties files");
			}
			
			
			
		}
		
	}
	
	/// ****************Application Independent functions************************ ///

	// opening the browser
	public void openBrowser(String browserType){
		log("Opening browser "+browserType);
		if(browserType.equals("Mozilla") && mozilla==null){
			driver = new FirefoxDriver();
			mozilla=driver;
		}else if(browserType.equals("Mozilla") && mozilla!=null){
			driver=mozilla;
		}else if(browserType.equals("Chrome") && chrome==null){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//chrome//chromedriver.exe");
			driver=new ChromeDriver();
			chrome=driver;
		}else if(browserType.equals("Chrome") && chrome==null){
			driver=chrome;
		}
		
		else if(browserType.equals("IE")){
			// set the IE server exe path and initialize
		}
		// max
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	// navigates to a URL
	public void navigate(String URL){
		log("Naviating to "+CONFIG.getProperty(URL));
		driver.get(CONFIG.getProperty(URL));
	}
	// clicking on any object
	public void click(String objectName){
		log("Clicking on " + objectName);
		driver.findElement(By.xpath(OR.getProperty(objectName))).click();
	}
	
	public void type(String text, String objectName){
		log("Typing in " + objectName);
		driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
	}
	
	public void select(String text, String objectName){
		log("Selecting from "+ objectName);
		driver.findElement(By.xpath(OR.getProperty(objectName))).sendKeys(text);
	}
	
	public boolean isElementPresent(String objectName){
		log("Checking object presence "+ objectName);
		int count = driver.findElements(By.xpath(OR.getProperty(objectName))).size();
		if(count==0)
			return false;
		else
			return true;
	}

	
	
	
	/// ****************Application dependent functions************************ ///
	
	public boolean isLoggedIn(){
		
		if(isElementPresent("searchText"))
			return true;
		else
			return false;
	}
	
	public void doDefaultLogin(){
		navigate("loginURL");
		type(CONFIG.getProperty("defaultUsername"), "loginusername");
		type(CONFIG.getProperty("defaultPassword"), "loginpassword");
		click("loginButton");
	}
	
	
	/********Singleton**********/
	public static WebConnector getInstance(){
		if(w==null)
			w= new WebConnector();
		
		return w;
	}
	
	/**************Logging***************/
	public void log(String msg){
		APPLICATION_LOGS.debug(msg);
	}
	
	
	
	
	
	
	
	
}
