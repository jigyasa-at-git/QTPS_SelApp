package testcases;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDisplayPage;
import pages.ProductSelectionPage;

public class CateGoryItemsTest {

	@Test
	public void testCategoryOptions() throws Exception{
		File app = new File(System.getProperty("user.dir")+"//com.flipkart.android-1.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		    capabilities.setCapability("app", app.getAbsolutePath());

	       WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	       Properties prop = new Properties();
	       FileInputStream fs = new FileInputStream("F:\\Whizdom-Trainings\\Tools\\Appium\\WorkSpace\\Temp\\src\\project.properties");
	       prop.load(fs);
	       System.out.println(prop.getProperty("Audio_&_Video"));
	       HomePage hPage=PageFactory.initElements(driver, HomePage.class);
	       hPage.gotoNavigation();
	       
	       //lifestyle,electonicApps
	       String[] menuItemsToTest = prop.getProperty("menutest").split(",");	
	       //l1
	       for(int menuItemNum=0;menuItemNum<menuItemsToTest.length;menuItemNum++){
	    	   String[] subMenuItems = prop.getProperty(menuItemsToTest[menuItemNum]).split(",");
	    	   //l2
	    	   for(int subMenuItem=0;subMenuItem<subMenuItems.length;subMenuItem++){
	    		   String item=subMenuItems[subMenuItem];
	    		   
	    		   Object page = hPage.clickOnMenu(item);
	    		   if(page instanceof HomePage){
	    			   String[] items=prop.getProperty(item).split(",");
	    			   for(int i=0;i<items.length;i++){
	    				   page = hPage.clickOnMenu(items[i]);
	    				   
	    				   if(page instanceof ProductDisplayPage){
	    					   ProductDisplayPage proSelectionPage = (ProductDisplayPage)page;
	    					   hPage = proSelectionPage.iterate();
	    				   }else if(page instanceof ProductSelectionPage){
	    					   ProductSelectionPage proSelectionPage = (ProductSelectionPage)page;
	    					   hPage = proSelectionPage.iterateProductCategories();
	    				   }
	    				   hPage.gotoNavigation();
	    				   
	    			   }
	    			   hPage.clickOnMenu(item);
	    		   }else{
	    			   ProductSelectionPage proSelectionPage = (ProductSelectionPage)page;
					   hPage = proSelectionPage.iterateProductCategories();
					   hPage.gotoNavigation();
	    		   }
	    		   
	    		   
	    		   
	    	   }
	       }
	     
	       
	       
	}
}
