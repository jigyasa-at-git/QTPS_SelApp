package com.qtpselenium.hybrid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;

public class Keywords {
	
	public static Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\hybrid\\xls\\Test Suite1.xlsx");
	static Keywords keywords=null;
	public Properties CONFIG=null;
	public Properties OR=null;
	public WebDriver driver= null;
	
	
	private Keywords(){
		System.out.println("Initializing Keywords");
		// initialize properties files
		try {
			// config
			CONFIG = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\hybrid\\config\\config.properties");
			CONFIG.load(fs);
			// OR
			OR = new Properties();
			fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\hybrid\\config\\OR.properties");
			OR.load(fs);

		} catch (Exception e) {
			// Error is found
			e.printStackTrace();
		}
	}
	
	
	public void executeKeywords(String testName,Hashtable<String,String> data){
		System.out.println("Executing - "+testName);
		// find the keywords for the test
		String keyword=null;
		String objectKey=null;
		String dataColVal=null;
		for(int rNum=2;rNum<=xls.getRowCount("Test Steps");rNum++){
			if(testName.equals(xls.getCellData("Test Steps", "TCID", rNum))){
			 keyword=xls.getCellData("Test Steps", "Keyword", rNum);
			 objectKey=xls.getCellData("Test Steps", "Object", rNum);
			 dataColVal=xls.getCellData("Test Steps", "Data", rNum);
			 String result=null;
			// System.out.println(keyword +" -- "+objectKey+" -- "+ dataColName);
			 if(keyword.equals("openBrowser"))
				 result=openBrowser(dataColVal);
			 else if (keyword.equals("click"))
				 result=click(objectKey);
			 else if(keyword.equals("input"))
				 result=input(objectKey,data.get(dataColVal));
			 else if(keyword.equals("navigate"))
				 result=navigate(dataColVal);
			 else if(keyword.equals("verifyText"))
				 result=verifyText();
			 else if(keyword.equals("checkMail"))
				 result= checkMail(data.get(dataColVal));
			 else if(keyword.equals("verifyLogin"))
				 result=verifyLogin(data.get(dataColVal));
			 
			 System.out.println(result);
			 
			 if(!result.equals("Pass")){
				 
				 // screenshot
				 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 String fileName=testName+"_"+keyword+".jpg";
				    try {
						FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"//screenshots//"+fileName));
					} catch (IOException e) {
						System.out.println("***ERR***");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
					 Assert.assertTrue(false, result);


			 }
			 //
			 //
			}
		}
		
		
	}
	
	
	
	public String openBrowser(String browserType){
		System.out.println("Executing openBrowser");
		if(CONFIG.getProperty(browserType).equals("Mozilla"))
			driver= new FirefoxDriver();
		else if(CONFIG.getProperty(browserType).equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "Path to chromedriver exe");
			driver= new ChromeDriver();
		}
		else if ((CONFIG.getProperty(browserType).equals("IE")))
			driver= new InternetExplorerDriver();
			
		return "Pass";
	}
	
	public String navigate(String URLKey){
		System.out.println("Executing navigate");
		try{
		driver.get(CONFIG.getProperty(URLKey));
		}catch(Exception e){
			return "Fail - not able to navigate";
		}
		return "Pass";
	}
	
	public String click(String xpathKey){
		System.out.println("Executing click");
		try{
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		}catch(Exception e){
			return "Fail - not able to click - "+xpathKey;

		}
		return "Pass";	
	}
	
	public String input(String xpathKey,String data){
		System.out.println("Executing input");
		try{
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(data);
		}catch(Exception e){
			return "Fail - not able to enter data in input box -"+xpathKey;
		}
		return "Pass";			
	}
	
	public String verifyText(){
		System.out.println("Executing verifyText");

		return "Pass";					
	}
	
	/**************************Application dependent****************************/
	public String checkMail(String mailName){
		System.out.println("Executing checkMail");

		try{
		driver.findElement(By.linkText(mailName)).click();
		}catch(Exception e){
			return "Fail-Mail not found";
		}
		
		
		
		return "Pass";							
	}
	
	
	
	//******Singleton function*******//
	public static Keywords getKeywordsInstance(){
		if(keywords == null){
			keywords = new Keywords();
		}
		
		
		return keywords;
	}
	
	public String verifyLogin(String verificationText){
		
		int total= driver.findElements(By.xpath(OR.getProperty("login_err_msg"))).size();
		int inboxcount=driver.findElements(By.xpath(OR.getProperty("inbox"))).size();
		if(total!=0){
			// not logged in
			// verify err msg
			if(driver.findElement(By.xpath(OR.getProperty("login_err_msg"))).equals(verificationText))
				return "Pass";
			else 
				return "Fail - Not able to find the error message ";
		}
			
		else if(inboxcount!=0){
		 // logged in
			if(driver.findElement(By.xpath(OR.getProperty("inbox"))).equals(verificationText))
				return "Pass";
			else 
				return "Fail - Not able to find the Inbox link";
		}
		
		return "Fail";
	}
	
	
	
	
	
	
	

}
