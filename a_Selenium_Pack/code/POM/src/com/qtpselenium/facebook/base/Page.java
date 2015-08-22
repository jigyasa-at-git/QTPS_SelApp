package com.qtpselenium.facebook.base;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qtpselenium.facebook.pages.inbox.TopMenu;
import com.qtpselenium.util.Xls_Reader;

public class Page {
	
	public static WebDriver driver = null;
	public static Properties CONFIG =null;
	public static Properties OR =null;
	public static TopMenu topMenu=null;
	public static Xls_Reader xls1= new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//TestCases.xlsx");
	public static boolean isLoggedIn=false;
	

	public Page(){
		if(driver==null){
		// initialize the properties file
		CONFIG= new Properties();
		OR = new Properties();
		try{
			// config
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties");
			CONFIG.load(fs);
			
			// OR
			fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\OR.properties");
			OR.load(fs);
			}catch(Exception e){
				// error
				return;
		}
		
		System.out.println(CONFIG.getProperty("browser"));
		if(CONFIG.getProperty("browser").equals("Mozilla"))
			  this.driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
		  this.driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver\\chromedriver.exe");
			this.driver=new ChromeDriver();
		}
		// implicit wait for the whole app
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		topMenu = new TopMenu();
		
	}
		
}
	// click
	public void click(String xpathKey){
		try{
	        driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
		}catch(Exception e){
			System.out.println("error");
			e.printStackTrace();
			// report error
		}
	}
	// input
	public void input(String xpathKey, String text){
		try{
		driver.findElement(By.xpath(OR.getProperty(xpathKey))).sendKeys(text);
		}catch(Exception e){
			// report error
			e.printStackTrace();
		}
	}
			// select
	// verification
	public boolean isElementPresent(String xpathKey){
		try{
			driver.findElement(By.xpath(OR.getProperty(xpathKey)));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}			
	// finds the link on page
	public boolean isLinkPresent(String linkText){
		try{
			driver.findElement(By.linkText(linkText));
		}catch(Exception e){
			return false;
		}
		
		return true;
	}
	
	
	public static void takeScreenshot(String fileName) {

		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
	}
	
	
	
	
	
	
}
