import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Js_Mobile_commands {
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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();
		HashMap<String,Double> keyCodes = new HashMap<String,Double>();
		keyCodes.put("tapCount", new Double("1.0"));
		keyCodes.put("touchCount", new Double("1.0"));
		keyCodes.put("duration", new Double("0.5"));
		keyCodes.put("x", new Double("73.0"));
		keyCodes.put("y", new Double("155.0"));
		
		
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("mobile: tap", keyCodes);
		
		driver.executeScript("mobile: tap", keyCodes);//buttons
		boolean result=isElementPresent("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]");// false
		Assert.assertTrue(result, "Element not found");
		String actualText  = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAStaticText[1]")).getText();
		Assert.assertEquals(actualText, "Buttons");

		//(JavascriptExecutor)wd.executeScript("mobile: tap", new HashMap<String, Double>() {{ put("tapCount", 1); put("touchCount", 1); put("duration", 0.5); put("x", 73); put("y", 155); }});

	}
	
	
	
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	// true=present
	// false = not present
	public boolean isElementPresent(String xpathElement){
		int total = driver.findElements(By.xpath(xpathElement)).size();
		if(total==0)
			return false;
		else
			return true;
	}
}




