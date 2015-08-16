import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class MultiToch_Ex {

	WebDriver driver;
	AndroidDriver androidDriver;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\ScaleImageView.apk");	
		capabilities.setCapability("app", app.getAbsolutePath());

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		WebElement catImage=driver.findElement(By.id("com.matabii.dev.scaleimageview:id/image"));
		System.out.println(catImage.getLocation().x);//0
		System.out.println(catImage.getLocation().y);//150
		int centerX = catImage.getLocation().x+ (catImage.getSize().width/2) ;
		int centerY = catImage.getLocation().y+ (catImage.getSize().height/2) ;
		System.out.println(centerX+" --- "+centerY );//0
	
		
		MultiTouchAction multiTouch = new MultiTouchAction((MobileDriver)driver);
		
		Thread.sleep(3000);
		TouchAction act1 = new TouchAction((MobileDriver)driver);
		act1.press(centerX, centerY-10).moveTo(centerX, centerY-500).release();
		TouchAction act2 = new TouchAction((MobileDriver)driver);
		act2.press(centerX, centerY+10).moveTo(centerX, centerY+500).release();
		
		multiTouch.add(act1).add(act2).perform();
	}
	
	
	@AfterTest
	public void quit(){
		//driver.quit();
	}

}
