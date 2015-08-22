import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class App_MiLB {
	
AndroidDriver dr;
	
	@Test
	public void testApp() throws MalformedURLException, InterruptedException  {

		
		// File app = new
		//File app = new File("C:/Users/agarwal/OneDrive/Personal/006 J/C.Education/001_QtpSelenium/000_apks/com.nnacres.app.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//capabilities.setCapability("app", "C:/Users/agarwal/OneDrive/Personal/006 J/C.Education/001_QtpSelenium/000_apks/com.nnacres.app.apk");
		// DesiredCapabilities capabilities = DesiredCapabilities.android();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "samsung-sgh_m919d38db9f6");
		//capabilities.setCapability("deviceName", "NexusS");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.xe.currency");
		capabilities.setCapability("appActivity", "com.xe.currency.activity.SplashScreen");

		dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),	capabilities);
		Thread.sleep(5000);

/*		System.out.println(dr.isAppInstalled("com.HBO"));
		System.out.println(dr.isAppInstalled("com.google.android.apps.maps"));
		System.out.println(dr.isAppInstalled("com.whatsapp"));
*/		
		
		//dr.findElement(By.id("com.xe.currency:id/base_edit")).click();
		//dr.findElement(By.className("android.widget.FrameLayout")).click();
		int s = dr.findElements(By.className("android.widget.FrameLayout")).size();
		System.out.println("Total # of FrameLayouts: "+s);
		//dr.findElement(By.xpath("//android.widget.FrameLayout[@id='com.xe.currency:id/rate_background']")).click();
		//dr.findElement(By.id("com.xe.currency:id/rate_background")).click();
		
		//int t = dr.findElements(By.xpath("//android.widget.FrameLayout[text()='USD - US Dollar']")).size();
		//System.out.println("Total # of FrameLayouts: "+t);
		
		

		
		Thread.sleep(5000);

	}
	
	@AfterTest
	public void quit() throws InterruptedException{
		
		//Thread.sleep(5000);
		if (dr != null);
		dr.quit();
		
	}

}