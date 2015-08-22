package com.qtpselenium.facebook;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebConnector {
	//Initializing Properties file
	WebDriver driver = null;
	Properties OR=null;
	
	// default constructor
	public WebConnector(){
		// initialize properties
		System.out.println("***************Initializing Properties file*******************");
		try{
			OR = new Properties();
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\OR.properties");
			OR.load(fs);
		}catch(Exception e){
			System.out.println("Error in initializing Properties file");
		}
		
	}
	
	public void openBrowser(String bType){
		if(bType.equals("Mozilla"))
			driver = new FirefoxDriver();
		else if(bType.equals("Chrome")){
		 System.setProperty("user.dir", System.getProperty("user.dir")+"//chromedriver//chromedriver.exe");
		    driver = new ChromeDriver();   
		}else if(bType.equals("IE")){
			// set path to exe
			driver= new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void navigate(String URL){
		driver.get(URL);
	}
	
	// click on any object
	public void click(String object){
		driver.findElement(By.xpath(OR.getProperty(object))).click();
	}

	// writing in a text field / select value from a list
	public void input(String object, String data){
		driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(data);
	}
	
	public void verifyTitle(){
		
	}
	
	// checking the presence of a particular element
	public boolean isElementPresent(String object){
		int count = driver.findElements(By.xpath(OR.getProperty(object))).size();
		if(count==0)
			return false;
		else 
			return true;
					
		
	}
	
	public void verifyText(){
		
	}
	
}
