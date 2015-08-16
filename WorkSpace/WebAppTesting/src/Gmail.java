import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Gmail {

	AppiumDriver driver;

	@Test
	public void testApp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        capabilities.setCapability("deviceName","Nexus 5");
        capabilities.setCapability("platformVersion", "4.4.4");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("app", "chrome");
        driver= new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
        driver.get("http://gmail.com");
        
        JavascriptExecutor js = (JavascriptExecutor)driver;
		String ua = (String)js.executeScript("return navigator.userAgent");
		System.out.println(ua);
		
		
        
	}
	
	@AfterTest
	public void quit(){
		//driver.quit();
	}
}
