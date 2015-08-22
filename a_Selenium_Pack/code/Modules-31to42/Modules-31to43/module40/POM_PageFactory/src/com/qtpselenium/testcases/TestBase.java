package com.qtpselenium.testcases;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.TopMenu;
import com.qtpselenium.util.Constants;
import com.qtpselenium.util.Xls_Reader;
// parameterize
// ant, exe-bat
// xslt reports
public class TestBase {

	public static Logger APPLICATION_LOGS = null;
	public static Properties CONFIG=null;
	public static WebDriver driver=null;
	public static TopMenu topMenu=null;
	public static boolean isLoggedIn=false;
	Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\data\\Test Cases.xlsx");

	
	public void initConfigurations(){
		if(CONFIG==null){
		// Logging
		APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		// config.prop
		 CONFIG = new Properties();
		try {
			FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
			CONFIG.load(fs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
	public void initDriver(){
		if(driver==null){
		if(CONFIG.getProperty("browser").equals("Mozilla"))
			driver=new FirefoxDriver();
		else if(CONFIG.getProperty("browser").equals("IE"))
			driver=new InternetExplorerDriver();
		else if(CONFIG.getProperty("browser").equals("Chrome"))
			driver=new ChromeDriver();
		}
	}
	
	public void quitDriver(){
		driver.quit();
		driver=null;
	}
	public TopMenu getTopMenu(){
		if(topMenu==null){
			topMenu = PageFactory.initElements(driver, TopMenu.class);
		}
		return topMenu;
	}
	
	
	
	
}
