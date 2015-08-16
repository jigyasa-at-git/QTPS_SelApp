
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WatsApp {

	AndroidDriver dr;

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		// File app = new
		// File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.google.android.apps.maps-1.apk");
		// capabilities.setCapability("app", app.getAbsolutePath());
		// DesiredCapabilities capabilities = DesiredCapabilities.android();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "samsung-sgh_m919d38db9f6");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");

		capabilities.setCapability("appPackage", "com.whatsapp");
		capabilities.setCapability("appActivity", "com.whatsapp.Main");

		dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),	capabilities);
		Thread.sleep(5000);

		System.out.println(dr.isAppInstalled("com.google.android.email"));
		System.out.println(dr.isAppInstalled("com.google.android.apps.maps"));
		System.out.println(dr.isAppInstalled("com.whatsapp"));

		// clicking
		/*
		 * When to use what What the advantage of using each of these
		 * 
		 * 
		 * WebDriver d1 = new AppiumDriver(new
		 * URL("http://127.0.0.1:4723/wd/hub"), capabilities); WebDriver d2 =
		 * new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		 * capabilities);
		 * 
		 * AppiumDriver d3 = new AppiumDriver(new
		 * URL("http://127.0.0.1:4723/wd/hub"), capabilities); RemoteWebDriver
		 * d4 = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"),
		 * capabilities);
		 * 
		 * WebDriver x = new RemoteWebDriver(new
		 * URL("http://127.0.0.1:4723/wd/hub"), capabilities); AppiumDriver
		 * y=(AppiumDriver)x;
		 */

	}

	@AfterTest
	public void quit() {
		if (dr != null)
			dr.quit();
	}

}
