package touchactions;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Swiping {

	public static void main(String[] args) throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		//File app = new File(System.getProperty("user.dir")+"//app/NKJPagerViewController.app");
        File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();
		int h = driver.manage().window().getSize().height;
		int w = driver.manage().window().getSize().width;
		System.out.println(h);
		System.out.println(w);
		/*
		HashMap<String,Double> keyCodes = new HashMap<String,Double>();
		
		keyCodes.put("touchCount", new Double("1.0"));
		keyCodes.put("duration", new Double("0.5"));
		keyCodes.put("startX", new Double("287.0"));
		keyCodes.put("startY", new Double("352.0"));
		keyCodes.put("endX", new Double("25.0"));
		keyCodes.put("endY", new Double("352.0"));
		
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("mobile: tap", keyCodes);
		
		driver.executeScript("mobile: swipe", keyCodes);//buttons
		*/
		driver.swipe(160, 450, 160, 150, 1);
	}

}
