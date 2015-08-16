import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class UiCatalog {

	
	
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
		// name, customized xpath
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIANavigationBar[1]/UIAButton[1]")).click();
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[3]/UIAStaticText[1]")).click();

		//scroll down
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[13]/UIAStaticText[1]")).click();

	//	driver.findElement(By.name("UICatalog")).click();
	//	driver.findElement(By.name("Buttons")).click();
		
		//UIAButton[@name='UICatalog']
		//UIANavigationBar[@name='UIView']/UIAButton[1]
		//UIANavigationBar[@name='UIView']/UIAButton[@name='UICatalog']
		
		driver.findElement(By.xpath("//UIANavigationBar[@name='UIView']/UIAButton[1]")).click();
	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
