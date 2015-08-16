package com.qtpselenium.mobile.flipkart;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.mobile.flipkart.pages.HomePage;
import com.qtpselenium.mobile.flipkart.pages.ProductDisplayPage;
import com.qtpselenium.mobile.flipkart.pages.ProductSelectionPage;

public class Sample {

	public static void main(String[] args) throws Exception {
		
		Properties prop = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\scr\\test\\resources\\project.properties");
		prop.load(fs);
		
		
		File app = new File(System.getProperty("user.dir")+"//com.flipkart.android-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("deviceName","Nexus 5");
	    capabilities.setCapability("platformVersion", "4.4.4");
	    capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	    // open the menu
	    homePage.menu.swipeAndOpenMenu();
	    
	   String level1Menu[]=prop.getProperty("menutest").split(",");
	   System.out.println("Total level 1 items - "+ level1Menu.length);
	   
	   for(int l1=0;l1<level1Menu.length;l1++){
		   System.out.println(level1Menu[l1]);
		   String level2Menu[] = prop.getProperty(level1Menu[l1]).split(",");
		   
		   for(int l2=0;l2<level2Menu.length;l2++){		   
			   Object page = homePage.menu.clickOnMenuItem(level2Menu[l2]);
			   
			   if(page instanceof HomePage){
				   System.out.println("in homepage");
				   // furthur select items
				   String[] level3Menu = prop.getProperty(level2Menu[l2]).split(",");
				   for(int l3=0;l3<level3Menu.length;l3++){	
					   page = homePage.menu.clickOnMenuItem(level3Menu[l3]);
					   
					   if(page instanceof ProductSelectionPage){
						   System.out.println("in productselection page");
						   ((ProductSelectionPage) page).menu.clickOnBackIcon();
					   }else if(page instanceof ProductDisplayPage){
						   System.out.println("in productdisplay page");
						   //((ProductSelectionPage) page).menu.clickOnBackIcon();
					   }
				   }
				  // homePage.menu.clickOnMenuItem(level2Menu[l2]);  
			   }else if(page instanceof ProductSelectionPage){
				   System.out.println("in productselection page");
				   ((ProductSelectionPage) page).menu.clickOnBackIcon();
			   }else if(page instanceof ProductDisplayPage){
				   System.out.println("in productdisplay page");
				  // ((ProductSelectionPage) page).menu.clickOnBackIcon();
			   }
			   
			   
			   
		   }
		   
	   }
	   
	   
	   Thread.sleep(5000);
	   driver.quit();

	}

}
