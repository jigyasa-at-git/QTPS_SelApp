import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class MessagingApp {

	
	IOSDriver driver;
	@Test
	public void launchApp() throws MalformedURLException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/SendMessageController.app");
		cap.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.name("new message")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")).sendKeys("hello");
		String typed = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")).getAttribute("value");
		System.out.println(typed);
		System.out.println(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")).getLocation().x);
		System.out.println(driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATextView[1]")).getLocation().y);
		driver.hideKeyboard();
		
		
		
	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
