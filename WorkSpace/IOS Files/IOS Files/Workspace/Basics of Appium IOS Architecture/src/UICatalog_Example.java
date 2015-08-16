import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class UICatalog_Example {
	IOSDriver driver;
	@Test
	public void launchApp() throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		boolean appInstalled = driver.isAppInstalled("com.example.apple-samplecode.UICatalog");
		System.out.println("App installed - "+appInstalled);
		Assert.assertTrue(appInstalled, "App not installed Uicatalog");
		
		//System.out.println(driver.getOrientation());
		//driver.rotate(ScreenOrientation.LANDSCAPE);
		//System.out.println(driver.getOrientation());
		//driver.rotate(ScreenOrientation.PORTRAIT);
		
		//driver.closeApp();
		//driver.launchApp();
		//driver.resetApp();
		//driver.lockScreen(5);
		//driver.findElement(By.name("UICatalog")).click();
		//driver.runAppInBackground(5);
		
		//driver.launchApp();// state persist? -  YES
		
		driver.removeApp("com.example.apple-samplecode.UICatalog");
		System.out.println(driver.isAppInstalled("com.example.apple-samplecode.UICatalog"));

		driver.installApp(System.getProperty("user.dir")+"//app/UICatalog.app");
		System.out.println(driver.isAppInstalled("com.example.apple-samplecode.UICatalog"));

		// WebDriver, AppiumDriver, IOSDriver
		/*
		WebDriver dr1 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
	
		WebDriver dr2 = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap); // grid
		IOSDriver dr4 = (IOSDriver)dr2;
		
		
		IOSDriver dr3 = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		*/
		
		
		
		
	}
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		//driver.quit();
	}

}

