import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TouchEvents1 {
	
	WebDriver driver;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\Drag-Sort Demos_0.5.0.apk");
		
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		
		List<WebElement> dragSections = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		List<WebElement> allNames = driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
		WebElement e1=dragSections.get(0);
		WebElement e2=dragSections.get(3);
		
		for(WebElement name:allNames){
			System.out.println(name.getText());
		}
		
		TouchAction act = new TouchAction((MobileDriver)driver);
		act.longPress(e1).moveTo(e2).release().perform();
		
		Thread.sleep(5000);
		
		System.out.println("----------");
		// updated List
		for(WebElement name:allNames){
			System.out.println(name.getText());
		}
	}
	
	@AfterTest
	public void quit(){
		driver.quit();
	}

}
