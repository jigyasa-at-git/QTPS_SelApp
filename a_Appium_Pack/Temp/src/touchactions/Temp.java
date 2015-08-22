package touchactions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Temp {

	WebDriver driver;

		@Test
		public void testApp() throws MalformedURLException, InterruptedException {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", "Nexus 5");
			capabilities.setCapability("platformVersion", "4.4.4");
			capabilities.setCapability("platformName", "Android");
			File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\Drag-Sort Demos_0.5.0.apk");
			
			capabilities.setCapability("app", app.getAbsolutePath());

			driver = new TouchAndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					capabilities);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
			List<WebElement> listItems = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
			List<WebElement> listItemNames = driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
			
			System.out.println("Total --"+listItems.size());
			TouchAction acts = new TouchAction((MobileDriver)driver);
			//acts.clickAndHold(onElement)
			for(WebElement e:listItemNames ){
				System.out.println(e.getText());
			}
			WebElement e1= listItems.get(0);
			WebElement e2= listItems.get(4);
			Thread.sleep(4000);
			System.out.println(e1.getLocation().getX());
			System.out.println(e1.getLocation().getY());
			System.out.println(acts);
			acts.longPress(e1).moveTo(e2).release().perform();
			System.out.println("---------------------");
			
			for(WebElement e:listItemNames ){
				System.out.println(e.getText());
			}
			
			
		}

	

}
