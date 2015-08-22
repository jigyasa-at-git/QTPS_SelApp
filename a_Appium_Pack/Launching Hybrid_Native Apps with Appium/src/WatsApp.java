
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class WatsApp {

	AppiumDriver dr;

	@Test
	public void testApp() throws MalformedURLException, InterruptedException {

		// File app = new
		// File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.google.android.apps.maps-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		// DesiredCapabilities capabilities = DesiredCapabilities.android();
		// capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("app", app.getAbsolutePath());

		capabilities
				.setCapability("appPackage", "com.google.android.apps.maps");
		capabilities.setCapability("appActivity",
				"com.google.android.maps.MapsActivity");

		dr = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
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
