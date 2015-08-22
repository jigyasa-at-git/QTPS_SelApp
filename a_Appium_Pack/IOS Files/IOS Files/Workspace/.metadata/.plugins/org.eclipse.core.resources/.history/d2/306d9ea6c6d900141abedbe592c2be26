import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Swiping {
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
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//UIANavigationBar[@name='UIView']/UIAButton[1]")).click();
		/*
		int h=driver.manage().window().getSize().height;
		int w=driver.manage().window().getSize().width;
		System.out.println("Height -> "+ h);
		System.out.println("Width -> "+ w);
		driver.swipe(w/2, h-100, w/2, h-300, 3);
		*/
		HashMap<String, Double> keyCodes = new HashMap<String, Double>();
		keyCodes.put("touchCount", new Double("1"));
		keyCodes.put("touchCount", new Double("1"));
		keyCodes.put("startX", new Double("157"));
		keyCodes.put("startY", new Double("611"));
		keyCodes.put("endX", new Double("157"));
		keyCodes.put("endY", new Double("153"));
		keyCodes.put("duration",  new Double("0.5"));
		
		driver.executeScript("mobile: swipe",keyCodes);
		
		//(JavascriptExecutor)wd.executeScript("mobile: swipe", () {{ put("touchCount", 1); put("startX", 157); put("startY", 611); put("endX", 157); put("endY", 153); put("duration", 0.5); }});

	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
