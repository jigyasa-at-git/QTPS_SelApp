package touchactions;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Temp2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Nexus 5");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\Drag-Sort Demos_0.5.0.apk");
		
		capabilities.setCapability("app", app.getAbsolutePath());

		AndroidDriver  driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElements(By.id("com.mobeta.android.demodslv:id/activity_title")).get(0).click();
		List<WebElement> listItems = driver.findElements(By.id("com.mobeta.android.demodslv:id/drag_handle"));
		List<WebElement> listItemNames = driver.findElements(By.id("com.mobeta.android.demodslv:id/text"));
		
		System.out.println("Total --"+listItems.size());
		TouchAction acts = new TouchAction((MobileDriver)driver);
		//acts.clickAndHold(onElement)
		
		WebElement e1= listItems.get(0);
		WebElement last= listItems.get(listItems.size()-1);
		Thread.sleep(4000);
		acts.longPress(e1).moveTo(last).release().perform();
		
		System.out.println(listItemNames.get(listItemNames.size()-1).getText());
		int x = last.getLocation().x;
		int y = last.getLocation().y;
		Thread.sleep(4000);
		while(true){
	    String topName=listItemNames.get(0).getText();
		acts.longPress(last).moveTo(x, y+100).release().perform();
	    String topName1=listItemNames.get(0).getText();
	    if(topName.equals(topName1))
	    	break;

		}
		
	}

}
