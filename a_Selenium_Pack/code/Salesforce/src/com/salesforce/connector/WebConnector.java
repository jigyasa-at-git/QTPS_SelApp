package com.salesforce.connector;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebConnector {
	Properties prop;
	WebDriver driver;
	public WebConnector(){
		try{
		prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\salesforce\\config\\config.properties");
		prop.load(fs);
		}catch(Exception e){}
	}
	
	public void openBrowser(String browser){
		if(browser.equals("Mozilla")){
			driver = new FirefoxDriver();
		}
		// extend for chrome and IE here
	}
	
	public void navigate(String url){
		driver.get(prop.getProperty(url));
	}
	
	public void click(String xpathKey){
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	

	public void input(String xpathKey,String value){
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(value);
	}
	
	
	
	
	
	
	
	
	
	

}
