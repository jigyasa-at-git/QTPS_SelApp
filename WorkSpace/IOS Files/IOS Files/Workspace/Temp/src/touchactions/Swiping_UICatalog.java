package touchactions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Swiping_UICatalog {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
	//	File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
        File app = new File(System.getProperty("user.dir")+"//app/NKJPagerViewController.app");
		cap.setCapability("app", app.getAbsolutePath());
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();
		
		MobileElement e = driver.scrollTo("Tab #40");
		Thread.sleep(5000);
		e.swipe(SwipeElementDirection.LEFT, 2);
	}

}
