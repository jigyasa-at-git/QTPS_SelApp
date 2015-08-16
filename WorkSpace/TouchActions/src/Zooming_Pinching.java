import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Zooming_Pinching {

	WebDriver driver;
	AndroidDriver androidDriver;
	@Test
	public void testApp() throws MalformedURLException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\ScaleImageView.apk");	
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		androidDriver= (AndroidDriver)driver;
		androidDriver.zoom(500,800);
		androidDriver.zoom(500,800);
		androidDriver.zoom(500,800);
		androidDriver.zoom(500,800);
		
		androidDriver.pinch(500,800);
		androidDriver.pinch(500,800);
		
		
	}
	
	
	@AfterTest
	public void quit(){
		//driver.quit();
	}

}
