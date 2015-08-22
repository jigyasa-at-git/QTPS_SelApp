package com.qtpselenium.framework.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;









import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Keywords {
	Logger Application_Log;
	Properties prop;
	WebDriver driver;
	HashMap<String,WebDriver> map;
	static Keywords k;
	
	public Keywords(){
		// init map
		map = new HashMap<String,WebDriver>();
		map.put(Constants.MOZILLA, null);
		map.put(Constants.CHROME, null);

		// initialize properties file
		prop=new Properties();
		try {
			FileInputStream fs = new FileInputStream(Constants.PROPERTIES_FILE_PATH);
			prop.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	public void executeKeywords(String testName, Xls_Reader xls,
			Hashtable<String, String> data) {

		// read the xls
		// call the keyword functions
		// report errors
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, 0, rNum);
			if(tcid.equalsIgnoreCase(testName)){
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, 2, rNum);
				String object = xls.getCellData(Constants.KEYWORDS_SHEET, 3, rNum);
				String dataCol = xls.getCellData(Constants.KEYWORDS_SHEET, 4, rNum);
				log(keyword +" --- "+object+" --- "+dataCol);
				log("Executing the test on browser - "+data.get(dataCol) );
				switch (keyword) {
				case "openBrowser":
					openBrowser(data.get(dataCol));
					break;
					
				case "navigate":
					navigate();
					break;
				
				case "click":
					click(object);
					break;
				case "loginIfNotLoggedIn":
					loginIfNotLoggedIn();
					break;
					
				case "closeBrowser":
					closeBrowser(data.get(Constants.BROWSER_COL));	
					
					break;
				default:
					break;
				}
				
				
				
			}
		}
		
		
		
		
		
	}
	
	//error and failure
	
	


	

	public String openBrowser(String browserType){
		log("Starting function openBrowser - "+ browserType);
		try{
			
			if(map.get(browserType.toLowerCase()) == null){
				
				if(browserType.equalsIgnoreCase(Constants.MOZILLA))
					driver = new FirefoxDriver();
				else if(browserType.equalsIgnoreCase(Constants.CHROME)){
					System.setProperty("webdriver.chrome.driver",prop.getProperty("chromedriverexe") );
					driver = new ChromeDriver();
				}
				map.put(browserType.toLowerCase(), driver);
			}
			else{ // flag
				driver= map.get(browserType.toLowerCase());
			}
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(Exception e){ //error
			e.printStackTrace();
			reportError(Constants.OPENBROWSER_ERROR+browserType);
			return null;
		}
		
		log("Ending  function openBrowser with status "+Constants.PASS);
		return Constants.PASS;
	}
	
	
	public String navigate(){
		log("Starting function navigate");
		try{
			String env = prop.getProperty("env");
			String url = prop.getProperty("url_"+env);
			driver.get(url);
			
			//titles
			String actualTitle=driver.getTitle();
			String expectedTitle=prop.getProperty("homePageTitle");
			if(!actualTitle.equals(expectedTitle))
			reportFailureAndStop(Constants.TITLE_NOT_MATCHES_FAILURE+expectedTitle+". Actual-"+actualTitle);
		}catch(Exception e){ //error
			e.printStackTrace();
			reportError(Constants.NAVIGATE_ERROR+e.getMessage());
		}
		log("Ending  function navigate with status "+Constants.PASS);
		return Constants.PASS;
	}
	
	
	


	public String click(String objectKey){
		log("Starting function click"+ objectKey);
		element(objectKey).click();
		log("Ending  function click with status "+Constants.PASS);
		return Constants.PASS;
	}
	
	public String input(String objectKey,String data){
		log("Starting function input"+ objectKey+" , "+data );
		
		element(objectKey).sendKeys(data);
		
		log("Ending  function click with status "+Constants.PASS);
		return Constants.PASS;
	}
	
	private void closeBrowser(String browserName) {

			driver.quit();
			map.put(browserName.toLowerCase(), null);
			
		
	}

	
	
	public WebElement element(String objectKey){
		
		log("Finding element "+objectKey );
		try{
			if(objectKey.endsWith("_id"))
				return driver.findElement(By.id(prop.getProperty(objectKey)));
			else if(objectKey.endsWith("_name"))
				return driver.findElement(By.name(prop.getProperty(objectKey)));
			else if(objectKey.endsWith("_xpath"))
				return driver.findElement(By.xpath(prop.getProperty(objectKey)));
			else{// error
				reportError(Constants.LOCATOR_ERROR+objectKey);
				
			}
		}
		catch(NoSuchElementException e){//failure
			reportFailureAndStop(Constants.ELEMENT_NOT_FOUND_FAILURE + objectKey);
		}catch(Exception e){ // error
			reportError(Constants.FIND_ELEMENT_ERROR + objectKey);
		}
		
		return null;
	}

	/************************************App Keywords*********************************/
	public void loginIfNotLoggedIn() {
		
		log("Entering function loginIfNotLoggedIn");
		
		if(isElementPresent("createPortfolio_xpath",5)){
			log("Already logged in");
			return;
		}
		
		navigate();
		click("moneyLink_xpath");
		click("myPortfolio_xpath");
		waitForPageToLoad();
		input("username_xpath",prop.getProperty("username"));
		click("emailsubmit_xpath");
		input("password_xpath",prop.getProperty("password"));
		click("loginsubmit_xpath");
		waitForPageToLoad();
		
		if(isElementPresent("createPortfolio_xpath",5)){
			reportFailureAndStop(Constants.DEFAULT_LOGIN_FAILURE);
		}
		
		log("Exiting function loginIfNotLoggedIn");
	}
	
	
	
	
	
	
	

	/*********************************Utility************************************/
	
	
	public boolean isElementPresent(String objectKey,int timeout) {
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		int size=0;
		if(objectKey.endsWith("_id"))
			size= driver.findElements(By.id(prop.getProperty(objectKey))).size();
		else if(objectKey.endsWith("_name"))
			size= driver.findElements(By.name(prop.getProperty(objectKey))).size();
		else if(objectKey.endsWith("_xpath"))
			size= driver.findElements(By.xpath(prop.getProperty(objectKey))).size();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if(size!=0)
			return true;
		else
		return false;
	}

	public void reportError(String msg){
		log(msg);
		Assert.fail(msg);
	}
	
	private void reportFailureAndStop(String Errmsg) {
		log(Errmsg);
		Assert.fail(Errmsg);
		//screenshot
		
	}
	
	
	public void waitForPageToLoad(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		while(!js.executeScript("return document.readyState").toString().equals("complete")){
			try {
				log("Waiting for 2 sec for page to load");
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void setLogger(Logger log){
		Application_Log = log;
	}
	
	
	public void log(String message){
		System.out.println(message);
		Application_Log.debug(message);
	}


	public static Keywords getInstance() {
		if(k==null){
			k = new Keywords();
		}
		return k;
	}

}
