package com.qtpselenium.framework.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Keywords {
	Logger Application_Log;
	Properties prop;
	WebDriver driver;
	HashMap<String,WebDriver> map;
	String currentTestCaseName;
	String currentIteration;
	String currentBrowser;
	
	//static Keywords k;
	static HashMap<String,Keywords> instanceMap = new HashMap<String,Keywords>();
	
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
		currentTestCaseName=testName;
		currentIteration=data.get(Constants.ITERATION_COL);
		currentBrowser=data.get(Constants.BROWSER_COL);
		int rows = xls.getRowCount(Constants.KEYWORDS_SHEET);
		for(int rNum=2;rNum<=rows;rNum++){
			String tcid = xls.getCellData(Constants.KEYWORDS_SHEET, 0, rNum);
			if(tcid.equalsIgnoreCase(testName)){
				String keyword = xls.getCellData(Constants.KEYWORDS_SHEET, 2, rNum);
				String object = xls.getCellData(Constants.KEYWORDS_SHEET, 3, rNum);
				String dataCol = xls.getCellData(Constants.KEYWORDS_SHEET, 4, rNum);
				log(keyword +" --- "+object+" --- "+dataCol);
				
				switch (keyword) {
				case "openBrowser":
					openBrowser(data.get(dataCol));
					break;
					
				case "navigate":
					navigate();
					break;
					
				case "input":
					input(object,data.get(dataCol));
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
				case "clickAndWait":
					clickAndWait(object);	
					break;	
				case "clearTextField":
					clearTextField(object);	
					break;		
				case "verifyPortFolio":
					verifyPortFolio(data);	
					break;
				case "selectPortFolio":
					selectPortFolio(data);	
					break;	
				case "clickAndAcceptAlert":
					clickAndAcceptAlert(object);	
					break;	
				case "selectAjaxCompanyName":
					selectAjaxCompanyName(object,data.get(dataCol));	
					break;	
				case "selectDate":
					selectDate(data.get(dataCol));	
					break;	
				case "verifyNewStock":
					verifyNewStock(data);	
					break;		
				case "selectStock":
					selectStock(data.get(dataCol));	
					break;	
				case "verifyStockModification":
					verifyStockModification(data);	
					break;	
				
						
				default:
					break;
				}
				
				//takeScreenShot();	
				
			}
		}
		
		
		
		
		
	}
	
	//error and failure
	




	public String openBrowser(String browserType){
		log("Starting function openBrowser - "+ browserType);
		try{
			/*
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
			*/
			
			/* Grid start */
			 DesiredCapabilities cap = null;
			 log(map.toString());
			 if(map.get(browserType)==null){ // browser not opened
				 log("Opening fresh browser");
				if(browserType.equalsIgnoreCase(Constants.MOZILLA))
				{
				  cap = DesiredCapabilities.firefox();
				  cap.setBrowserName("firefox");
				  cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				}
				
				if(browserType.equalsIgnoreCase(Constants.CHROME))
				{
				  
		          // browser.add(setupDriver(new ChromeDriver()));
				  cap = DesiredCapabilities.chrome();
				  cap.setBrowserName("chrome");
				  cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
				}
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
					map.put(browserType, driver);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 }else{
				 log("Using existing browser");
				 driver = map.get(browserType);
			 }
			 /* Grid end */
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
	
	public void wait(String time){
		try {
			System.out.println("WAITING------");
			Thread.sleep(Integer.parseInt(time)*1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public String clearTextField(String objectKey){
		log("Starting function clearTextField"+ objectKey);
		element(objectKey).clear();
		log("Ending  function clearTextField with status "+Constants.PASS);
		return Constants.PASS;
	}
	
	public void closeBrowser(String browserName) {

			driver.quit();
			map.put(browserName.toLowerCase(), null);
	}

	public String clickAndWait(String object){
		log("Starting function clickAndWait"+ object);
		
		try{
			Thread.sleep(3000);
			String temp[] = object.split(",");
			String elementToBeClicked=temp[0];
			String elementToBeVisible=temp[1];
			
			for(int i=0;i<5;i++){
				element(elementToBeClicked).click();
				if(isElementPresent(elementToBeVisible,5) && element(elementToBeVisible).isDisplayed()){
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				return Constants.PASS;
				}else{
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
		}
		}catch(Exception e){
			reportError(Constants.GENERAL_ERROR +"clickAndWait" );
		}
		
		reportFailureAndStop(Constants.CLICKANDWAIT_FAILURE+ object);
		return null;
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
				//reportError(Constants.LOCATOR_ERROR+objectKey);
				return driver.findElement(By.xpath(objectKey));
				
			}
		}
		catch(NoSuchElementException e){//failure
			reportFailureAndStop(Constants.ELEMENT_NOT_FOUND_FAILURE + objectKey);
		}catch(Exception e){ // error
			reportError(Constants.FIND_ELEMENT_ERROR + objectKey);
		}
		
		return null;
	}
	
	public String clickAndAcceptAlert(String objectKey) {
		try{
			waitForPageToLoad();
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty(objectKey))));
			Thread.sleep(3000);
			element(objectKey).click();
			
			Alert al = driver.switchTo().alert();
			al.accept();
			driver.switchTo().defaultContent();
			
			
		}catch(Exception e){ // error
			e.printStackTrace();
			reportError(Constants.GENERAL_ERROR +" acceptAlert");
		}
		return Constants.PASS;
		
	}
	
	public int getTableRowNumWithText(String xpathExp,String text){
		int rowNum=0;
		//parse the table
		List<WebElement> rows = driver.findElements(By.xpath(prop.getProperty(xpathExp)+"/tr"));
		
		for(int rNum=0;rNum<rows.size();rNum++){
			WebElement row = rows.get(rNum);
			List<WebElement> cells =row.findElements(By.tagName("td"));
			
			for(int cNum=0;cNum<cells.size();cNum++){
				//System.out.println(cells.get(cNum).getText());
				if(!(cells.get(cNum).getText().toLowerCase().equals("")) && text.toLowerCase().startsWith(cells.get(cNum).getText().toLowerCase())){
					rowNum=rNum+1;
					return rowNum;
				}
			}
			
		
	    }
		
		return -1;
		
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
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("createPortfolio_xpath"))));
		/*
		if(isElementPresent("createPortfolio_xpath",20)){
			reportFailureAndStop(Constants.DEFAULT_LOGIN_FAILURE);
		}
		*/
		log("Exiting function loginIfNotLoggedIn");
	}
	
	
	
	public String verifyPortFolio(Hashtable<String,String> data){
		log("Entering function verifyPortFolio");
		
		String condition = data.get(Constants.CASE_COL);
		String portfolioName=data.get(Constants.PORTFOLIONAME_COL);
		switch(condition){ 
		
			case "CASE_OK":
					
					boolean present=isElementPresent("//select[@id='portfolioid']/option[text()='"+portfolioName+"']",5);
					
					if(!present){
					reportFailureAndStop(Constants.PORTFOLIONAMENOTPRESENT_FAILURE+ portfolioName);
					}
			break;
			
			case "CASE_DUPLICATE_NAME":
				boolean duplicate=isElementPresent("duplicatePortFolioName_xpath",5);
				
				if(!duplicate){
				reportFailureAndStop(Constants.DUPLICATE_FAILURE+ portfolioName);
				}
			
			break;
			
			case "CASE_INVALID_NAME":
				
			break;
		}
			
		
		log("Exiting function verifyPortFolio");
		return Constants.PASS;
	}
	
	public String selectPortFolio(Hashtable<String,String> data) {
		log("Entering function selectPortFolio "+data);
		waitForPageToLoad();
		// TODO Auto-generated method stub
		input("portfolioid_xpath",data.get(Constants.PORTFOLIONAME_COL));
		//if(data.get(Constants.BROWSER_COL).equalsIgnoreCase(Constants.CHROME))
			element("portfolioid_xpath").sendKeys(Keys.ENTER);
		
		waitForPageToLoad();
		log("Exiting function selectPortFolio");

		
		return Constants.PASS;
	}
	
	public String selectAjaxCompanyName(String object, String companyName) {
		for(int i=0;i<companyName.length();i++){
			char character=companyName.charAt(i);
			element(object).sendKeys(String.valueOf(character));
			if(isElementPresent("//div[@id='ajax_listOfOptions']/div[text()='"+companyName+"']",5)){
				driver.findElement(By.xpath("//div[@id='ajax_listOfOptions']/div[text()='"+companyName+"']")).click();
				return Constants.PASS;
			}
		}
		reportFailureAndStop(Constants.AJAX_COMAPNY_ERR+companyName);
		return null;
		
	}
	
	
	

	public void selectDate(String date) {

		Date currentDate = new Date();// get current date
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected =null;
		try {
			 dateToBeSelected = formatter.parse(date); // date object of the date to be selected
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String month=new SimpleDateFormat("MMMM").format(dateToBeSelected);		
		String day=new SimpleDateFormat("dd").format(dateToBeSelected);		
		String year=new SimpleDateFormat("yyyy").format(dateToBeSelected);		
	    String month_yearExpected = month+" "+year;
	    
		while(true){
			
			String month_yearDisplayed = driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[3]/div")).getText();
			if(month_yearDisplayed.equals(month_yearExpected))
				break; // correct month
			
			if(currentDate.after(dateToBeSelected))
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
			else
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
				
		}
		// fill company details
		driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		
	}

	public String verifyNewStock(Hashtable<String,String> data) {
		log("Starting function verifyNewStock");
		
		wait("10");
		waitForPageToLoad();
		int rNum=getTableRowNumWithText("stockTable_xpath",data.get(Constants.STOCKNAME_COL));
		//Assert.assertFalse(rNum==-1, Constants.ADD_NEW_STOCK_FAILURE+data.get("StockName"));
		if(rNum==-1){
			reportFailureAndStop(Constants.ADD_NEW_STOCK_FAILURE+data.get("StockName"));
		}
			
		//table[@id='stock']/tbody/tr[1]/td[2]/span/a

		String name=element(prop.getProperty("stockTable_xpath")+"/tr["+rNum+"]/td[2]/span/a").getText();
		String quantity=element(prop.getProperty("stockTable_xpath")+"/tr["+rNum+"]/td[3]/span").getText();
		String price=element(prop.getProperty("stockTable_xpath")+"/tr["+rNum+"]/td[4]/span").getText();
		log(name+"  "+ quantity + "  "+ price);
		
		Assert.assertEquals(quantity, data.get(Constants.QUANTITY_COL));
		
		log("Ending function verifyNewStock");
		return Constants.PASS;
		

	}
	
	public void selectStock(String stockName) {
		log("Starting function selectStock");
		wait("10");
		waitForPageToLoad();
		
		
		int	rNum=getTableRowNumWithText("stockTable_xpath",stockName);
		
		log("Stock "+stockName+" found in row - "+rNum);
		//Assert.assertFalse(rNum==-1, Constants.ADD_NEW_STOCK_FAILURE+data.get("StockName"));
		if(rNum==-1){
			reportFailureAndStop(Constants.STOCK_NOT_PRESENT_FAILURE+stockName);
		}
		
		element(prop.getProperty("stockTable_xpath")+"/tr["+rNum+"]/td[1]/input").click();
		
	}

	public void verifyStockModification(Hashtable<String, String> data) {
		log("Starting function verifyStockModification");
		String acutualTransactionQuantity = element("firstTranasctionQuantity_xpath").getText();
		String action = data.get(Constants.ACTION_COL);
		String expectedTranasctionQuantity = data.get(Constants.QUANTITY_COL);
		
		if(action.equals("Sell"))
			expectedTranasctionQuantity="-"+expectedTranasctionQuantity;
		
		log("Actual transaction quantity - "+acutualTransactionQuantity);
		log("Expected transaction quantity - "+expectedTranasctionQuantity);
		
		if(!acutualTransactionQuantity.equals(expectedTranasctionQuantity))
			reportFailureAndStop(Constants.TRANSACTION_QUANTITY_FAILURE);
		
		log("Ending function verifyStockModification");

		
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
		else 
			size= driver.findElements(By.xpath(objectKey)).size();
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		if(size!=0)
			return true;
		else
		return false;
	}

	public void reportError(String msg){
		takeScreenShot();
		log(msg);
		closeBrowser(currentBrowser); // node browser becomes available again
		Assert.fail(msg);
	}
	
	public void reportFailureAndStop(String Errmsg) {
		takeScreenShot();
		log(Errmsg);
		closeBrowser(currentBrowser);// node browser becomes available again
		Assert.fail(Errmsg);		
	}
	
	public void takeScreenShot(){
		//testcasename_iteration.jpg
		String filePath=Constants.SCREENSHOT_PATH+currentTestCaseName+"-"+currentIteration+".png";
		File targetFile= new File(filePath);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   
		
		try {
			FileUtils.copyFile(srcFile, targetFile);
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
	
	
	public void waitForPageToLoad(){
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println(js.executeScript("return document.readyState").toString());
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


	public static Keywords getInstance(String instanceName) {
		if(instanceMap.get(instanceName) == null){
			instanceMap.put(instanceName, new Keywords());
		}
		return instanceMap.get(instanceName);
	}
	


}
