
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;


public class ExecuteFunction {
    //http://appium.wikia.com/wiki/Mobile_Commands
	//https://blog.codecentric.de/en/2014/05/android-ui-testing-appium/
	//http://notes.ericjiang.com/posts/333
	/**
	 * @param args
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();

		//driver.manage().timeouts().implicitlyWait(10, TimeU);
		HashMap<String, Double> map = new HashMap<String, Double>();
		map.put("tapCount", new Double("1.0"));
		map.put("touchCount", new Double("1.0"));
		map.put("duration",  new Double("0.625625")); 
		map.put("x", new Double("49.0")); 
		map.put("y", new Double("279.0"));
		driver.executeScript("mobile: tap", map);
		
		//driver.execute("mobile: tap",map );
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("mobile: tap", map);

	}

}
