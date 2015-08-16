package touchactions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Temp3 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\WhatsApp_2.11.432.apk");
		
		capabilities.setCapability("app", app.getAbsolutePath());

		

		AndroidDriver  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		TouchAction act = new TouchAction((MobileDriver)driver);
		WebElement e=driver.findElement(By.xpath("//android.widget.TextView[@text='Durga Etl']"));
		//e.click();
		act.tap(e).perform();
		//act.longPress(e).perform();
		//act.press(e).waitAction(5000);
		
		MultiTouchAction multiAct = new MultiTouchAction((MobileDriver)driver);
		


	}

}
