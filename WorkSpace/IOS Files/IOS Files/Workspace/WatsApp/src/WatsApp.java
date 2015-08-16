//

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WatsApp {

	static AndroidDriver dr;
	public static void main(String arg[]) throws MalformedURLException{
		
		File app = new File("/Users/ashish/Documents/Ashish/Apk_Files/WhatsApp_2.12.5.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		 capabilities.setCapability("app", app.getAbsolutePath());

	    //   capabilities.setCapability("appPackage", "com.whatsapp");
	      // capabilities.setCapability("appActivity", "com.whatsapp.Main");

	       dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	       dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	      
	       // clicking
	      // dr.quit();
	       	}
	
	
}

