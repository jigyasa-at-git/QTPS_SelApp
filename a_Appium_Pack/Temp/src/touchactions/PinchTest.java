package touchactions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class PinchTest {

	AppiumDriver driver;

	@Test
	public void setUpAppium() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Xperia Z1");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\ScaleImageView.apk");
		
		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		WebElement element = driver.findElement(By
				.id("com.matabii.dev.scaleimageview:id/image"));

		Thread.sleep(5000);
		
		driver.zoom(element.getLocation().x+500,element.getLocation().y+800);
		driver.pinch(element.getLocation().x+500,element.getLocation().y+800);

		
		MultiTouchAction multiTouch = new MultiTouchAction((MobileDriver)driver);
		Dimension dimensions = element.getSize();
		Point upperLeft = element.getLocation();
		Point center = new Point(upperLeft.getX() + dimensions.getWidth() / 2, upperLeft.getY() + dimensions.getHeight() / 2);
		TouchAction action0 = new TouchAction((MobileDriver)driver).press(element, center.getX(), center.getY() - 100).moveTo(element).release();
		TouchAction action1 = new TouchAction((MobileDriver)driver).press(element, center.getX(), center.getY() + 100).moveTo(element).release();
		multiTouch.add(action0).add(action1);
		multiTouch.perform();
		
	}
	
	@AfterTest
	public void stopDriver() throws InterruptedException{
		
		Thread.sleep(5000);
		driver.quit();
	}
}
