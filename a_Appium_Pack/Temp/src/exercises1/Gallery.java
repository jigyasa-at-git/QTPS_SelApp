package exercises1;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Gallery {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("deviceName","Nexus 5");
	    capabilities.setCapability("platformVersion", "4.4.4");
	    capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage",
				"com.google.android.GoogleCamera");
		capabilities.setCapability("appActivity",
				"com.android.camera.CameraLauncher");

		WebDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    

	}

}