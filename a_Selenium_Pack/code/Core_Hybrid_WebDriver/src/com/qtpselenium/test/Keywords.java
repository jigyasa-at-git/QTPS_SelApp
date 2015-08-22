package com.qtpselenium.test;
import static com.qtpselenium.test.DriverScript.APP_LOGS;
import static com.qtpselenium.test.DriverScript.CONFIG;
import static com.qtpselenium.test.DriverScript.OR;
import static com.qtpselenium.test.DriverScript.currentTestSuiteXLS;
import static com.qtpselenium.test.DriverScript.currentTestCaseName;
import static com.qtpselenium.test.DriverScript.currentTestDataSetID;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qtpselenium.xls.read.Xls_Reader;
public class Keywords {
	
	public WebDriver driver;
	
	
	public String openBrowser(String object,String data){		
		APP_LOGS.debug("Opening browser");
		if(data.equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(data.equals("IE"))
			driver=new InternetExplorerDriver();
		else if(data.equals("Chrome"))
			driver=new ChromeDriver();
		
		long implicitWaitTime=Long.parseLong(CONFIG.getProperty("implicitwait"));
		driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		return Constants.KEYWORD_PASS;

	}
	
	public String navigate(String object,String data){		
		APP_LOGS.debug("Navigating to URL");
		try{
		driver.navigate().to(data);
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to navigate";
		}
		return Constants.KEYWORD_PASS;
	}
	
	public String clickLink(String object,String data){
        APP_LOGS.debug("Clicking on link ");
        try{
        driver.findElement(By.xpath(OR.getProperty(object))).click();
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Not able to click on link"+e.getMessage();
        }
     
		return Constants.KEYWORD_PASS;
	}
	public String clickLink_linkText(String object,String data){
        APP_LOGS.debug("Clicking on link ");
        driver.findElement(By.linkText(OR.getProperty(object))).click();
     
		return Constants.KEYWORD_PASS;
	}
	
	
	
	public  String verifyLinkText(String object,String data){
        APP_LOGS.debug("Verifying link Text");
        try{
        	String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
        	String expected=data;
        	
        	if(actual.equals(expected))
        		return Constants.KEYWORD_PASS;
        	else
        		return Constants.KEYWORD_FAIL+" -- Link text not verified";
        	
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+" -- Link text not verified"+e.getMessage();

        }
        
	}
	
	
	public  String clickButton(String object,String data){
        APP_LOGS.debug("Clicking on Button");
        try{
            driver.findElement(By.xpath(OR.getProperty(object))).click();
            }catch(Exception e){
    			return Constants.KEYWORD_FAIL+" -- Not able to click on Button"+e.getMessage();
            }
        
        
		return Constants.KEYWORD_PASS;
	}
	
	public  String verifyButtonText(String object,String data){
		APP_LOGS.debug("Verifying the button text");
		try{
		String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
    	String expected=data;

    	if(actual.equals(expected))
    		return Constants.KEYWORD_PASS;
    	else
    		return Constants.KEYWORD_FAIL+" -- Button text not verified "+actual+" -- "+expected;
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
		}
		
	}
	
	public  String selectList(String object, String data){
		APP_LOGS.debug("Selecting from list");
		try{
			if(!data.equals(Constants.RANDOM_VALUE)){
			  driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
			}else{
				// logic to find a random value in list
				WebElement droplist= driver.findElement(By.xpath(OR.getProperty(object))); 
				List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
				Random num = new Random();
				int index=num.nextInt(droplist_cotents.size());
				String selectedVal=droplist_cotents.get(index).getText();
				
			  driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(selectedVal);
			}
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

		}
		
		return Constants.KEYWORD_PASS;	
	}
	
	public String verifyAllListElements(String object, String data){
		APP_LOGS.debug("Verifying the selection of the list");
	try{	
		WebElement droplist= driver.findElement(By.xpath(OR.getProperty(object))); 
		List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
		
		// extract the expected values from OR. properties
		String temp=data;
		String allElements[]=temp.split(",");
		// check if size of array == size if list
		if(allElements.length != droplist_cotents.size())
			return Constants.KEYWORD_FAIL +"- size of lists do not match";	
		
		for(int i=0;i<droplist_cotents.size();i++){
			if(!allElements[i].equals(droplist_cotents.get(i).getText())){
					return Constants.KEYWORD_FAIL +"- Element not found - "+allElements[i];
			}
		}
	}catch(Exception e){
		return Constants.KEYWORD_FAIL +" - Could not select from list. "+ e.getMessage();	

	}
		
		
		return Constants.KEYWORD_PASS;	
	}
	
	public  String verifyListSelection(String object,String data){
		APP_LOGS.debug("Verifying all the list elements");
		try{
			String expectedVal=data;
			//System.out.println(driver.findElement(By.xpath(OR.getProperty(object))).getText());
			WebElement droplist= driver.findElement(By.xpath(OR.getProperty(object))); 
			List<WebElement> droplist_cotents = droplist.findElements(By.tagName("option"));
			String actualVal=null;
			for(int i=0;i<droplist_cotents.size();i++){
				String selected_status=droplist_cotents.get(i).getAttribute("selected");
				if(selected_status!=null)
					actualVal = droplist_cotents.get(i).getText();			
				}
			
			if(!actualVal.equals(expectedVal))
				return Constants.KEYWORD_FAIL + "Value not in list - "+expectedVal;

		}catch(Exception e){
			return Constants.KEYWORD_FAIL +" - Could not find list. "+ e.getMessage();	

		}
		return Constants.KEYWORD_PASS;	

	}
	
	public  String selectRadio(String object, String data){
		APP_LOGS.debug("Selecting a radio button");
		try{
			String temp[]=object.split(Constants.DATA_SPLIT);
			driver.findElement(By.xpath(OR.getProperty(temp[0])+data+OR.getProperty(temp[1]))).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button";	

		}
		
		return Constants.KEYWORD_PASS;	

	}
	
	public  String verifyRadioSelected(String object, String data){
		APP_LOGS.debug("Verify Radio Selected");
		try{
			String temp[]=object.split(Constants.DATA_SPLIT);
			String checked=driver.findElement(By.xpath(OR.getProperty(temp[0])+data+OR.getProperty(temp[1]))).getAttribute("checked");
			if(checked==null)
				return Constants.KEYWORD_FAIL+"- Radio not selected";	

				
		}catch(Exception e){
			return Constants.KEYWORD_FAIL +"- Not able to find radio button";	

		}
		
		return Constants.KEYWORD_PASS;	

	}
	
	
	public  String checkCheckBox(String object,String data){
		APP_LOGS.debug("Checking checkbox");
		try{
			// true or null
			String checked=driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("checked");
			if(checked==null)// checkbox is unchecked
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbo";
		}
		return Constants.KEYWORD_PASS;
		
	}
	
	public String unCheckCheckBox(String object,String data){
		APP_LOGS.debug("Unchecking checkBox");
		try{
			String checked=driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("checked");
			if(checked!=null)
				driver.findElement(By.xpath(OR.getProperty(object))).click();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbox";
		}
		return Constants.KEYWORD_PASS;
		
	}
	
	
	public  String verifyCheckBoxSelected(String object,String data){
		APP_LOGS.debug("Verifying checkbox selected");
		try{
			String checked=driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("checked");
			if(checked!=null)
				return Constants.KEYWORD_PASS;
			else
				return Constants.KEYWORD_FAIL + " - Not selected";
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" - Could not find checkbox";

		}
		
		
	}
	
	
	public String verifyText(String object, String data){
		APP_LOGS.debug("Verifying the text");
		try{
			String actual=driver.findElement(By.xpath(OR.getProperty(object))).getText();
	    	String expected=data;

	    	if(actual.equals(expected))
	    		return Constants.KEYWORD_PASS;
	    	else
	    		return Constants.KEYWORD_FAIL+" -- text not verified "+actual+" -- "+expected;
			}catch(Exception e){
				return Constants.KEYWORD_FAIL+" Object not found "+e.getMessage();
			}
		
	}
	
	public  String writeInInput(String object,String data){
		APP_LOGS.debug("Writing in text box");
		
		try{
			driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to write "+e.getMessage();

		}
		return Constants.KEYWORD_PASS;
		
	}
	
	public  String verifyTextinInput(String object,String data){
       APP_LOGS.debug("Verifying the text in input box");
       try{
			String actual = driver.findElement(By.xpath(OR.getProperty(object))).getAttribute("value");
			String expected=data;

			if(actual.equals(expected)){
				return Constants.KEYWORD_PASS;
			}else{
				return Constants.KEYWORD_FAIL+" Not matching ";
			}
			
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+" Unable to find input box "+e.getMessage();

		}
	}
	
	public  String clickImage(){
	       APP_LOGS.debug("Clicking the image");
			
			return Constants.KEYWORD_PASS;
	}
	
	public  String verifyFileName(){
	       APP_LOGS.debug("Verifying inage filename");
			
			return Constants.KEYWORD_PASS;
	}
	
	
	
	
	public  String verifyTitle(String object, String data){
	       APP_LOGS.debug("Verifying title");
	       try{
	    	   String actualTitle= driver.getTitle();
	    	   String expectedTitle=data;
	    	   if(actualTitle.equals(expectedTitle))
		    		return Constants.KEYWORD_PASS;
		    	else
		    		return Constants.KEYWORD_FAIL+" -- Title not verified "+expectedTitle+" -- "+actualTitle;
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Error in retrieving title";
			   }		
	}
	
	public String exist(String object,String data){
	       APP_LOGS.debug("Checking existance of element");
	       try{
	    	   driver.findElement(By.xpath(OR.getProperty(object)));
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Object doest not exist";
			  }
	       
	       
			return Constants.KEYWORD_PASS;
	}
	
	public  String click(String object,String data){
	       APP_LOGS.debug("Clicking on any element");
	       try{
	    	   driver.findElement(By.xpath(OR.getProperty(object))).click();
			   }catch(Exception e){
					return Constants.KEYWORD_FAIL+" Not able to click";
			  }
			return Constants.KEYWORD_PASS;
	}
	
	public  String synchronize(String object,String data){
		APP_LOGS.debug("Waiting for page to load");
		((JavascriptExecutor) driver).executeScript(
        		"function pageloadingtime()"+
        				"{"+
        				"return 'Page has completely loaded'"+
        				"}"+
        		"return (window.onload=pageloadingtime());");
        
		return Constants.KEYWORD_PASS;
	}
	
	public  String waitForElementVisibility(String object,String data){
		APP_LOGS.debug("Waiting for an element to be visible");
		int start=0;
		int time=(int)Double.parseDouble(data);
		try{
		 while(time == start){
			if(driver.findElements(By.xpath(OR.getProperty(object))).size() == 0){
				Thread.sleep(1000L);
				start++;
			}else{
				break;
			}
		 }
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+"Unable to close browser. Check if its open"+e.getMessage();
		}
		return Constants.KEYWORD_PASS;
	}
	
	public  String closeBroswer(String object, String data){
		APP_LOGS.debug("Closing the browser");
		try{
			driver.quit();
		}catch(Exception e){
			return Constants.KEYWORD_FAIL+"Unable to close browser. Check if its open"+e.getMessage();
		}
		return Constants.KEYWORD_PASS;

	}
	
	public String pause(String object, String data) throws NumberFormatException, InterruptedException{
		long time = (long)Double.parseDouble(object);
		Thread.sleep(time*1000L);
		return Constants.KEYWORD_PASS;
	}
	
	
	/************************APPLICATION SPECIFIC KEYWORDS********************************/
	
	public String validateLogin(String object, String data){
	// object of the current test XLS
	// name of my current test case
		System.out.println("xxxxxxxxxxxxxxxxxxxxx");
        String data_flag=currentTestSuiteXLS.getCellData(currentTestCaseName, "Data_correctness",currentTestDataSetID );
		while(driver.findElements(By.xpath(OR.getProperty("image_login_process"))).size() !=0 ){
			try{
				String visiblity=driver.findElement(By.xpath(OR.getProperty("image_login_process"))).getAttribute("style");
			    System.out.println("System Processing request - "+ visiblity);
			    if(visiblity.indexOf("hidden") != -1){
			    	// error message on screen
			    	// YOUR WORK
			    	String actualErrMsg=driver.findElement(By.xpath(OR.getProperty("error_login"))).getText();
			    	//String expected=OR;
			    	if(data_flag.equals(Constants.POSITIVE_DATA))
			    	 return Constants.KEYWORD_FAIL;
			    	else
			    	 return Constants.KEYWORD_PASS;
			    }
			
			}catch(Exception e){
				
			}
		}
		
		// check for page title
		if(data_flag.equals(Constants.POSITIVE_DATA))
	    	 return Constants.KEYWORD_PASS;
	    else
	         return Constants.KEYWORD_FAIL;
	}
	
	
	
	
	public  String verifyLaptops(String object, String data){
        APP_LOGS.debug("Verifying the laptops in app");
		// brand
        String brand=currentTestSuiteXLS.getCellData(currentTestCaseName, "Brand", currentTestDataSetID).toLowerCase();
        for(int i=1 ; i<=4;i++){
        	String text = driver.findElement(By.xpath(OR.getProperty("laptop_name_link_start")+i+OR.getProperty("laptop_name_link_end"))).getText().toLowerCase();
        	if(text.indexOf(brand) == -1){
        		return Constants.KEYWORD_FAIL+" Brand not there in - "+text;
        	}
        	
        }
        
        
		return Constants.KEYWORD_PASS;
	}
	
	
	public String verifySearchResults(String object,String data){
        APP_LOGS.debug("Verifying the Search Results");
        try{
        	data=data.toLowerCase();
        	for(int i=3;i<=5;i++){
        		String text=driver.findElement(By.xpath(OR.getProperty("search_result_heading_start")+i+OR.getProperty("search_result_heading_end"))).getText().toLowerCase();
        		if(text.indexOf(data) == -1){
        			return Constants.KEYWORD_FAIL+" Got the text - "+text;
        		}
        	}
        	
        }catch(Exception e){
			return Constants.KEYWORD_FAIL+"Error -->"+e.getMessage();
		}
        
		return Constants.KEYWORD_PASS;


	}
	
	
	// not a keyword
	
	public void captureScreenshot(String filename, String keyword_execution_result) throws IOException{
		// take screen shots
		if(CONFIG.getProperty("screenshot_everystep").equals("Y")){
			// capturescreen
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
			
		}else if (keyword_execution_result.startsWith(Constants.KEYWORD_FAIL) && CONFIG.getProperty("screenshot_error").equals("Y") ){
		// capture screenshot
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") +"//screenshots//"+filename+".jpg"));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
