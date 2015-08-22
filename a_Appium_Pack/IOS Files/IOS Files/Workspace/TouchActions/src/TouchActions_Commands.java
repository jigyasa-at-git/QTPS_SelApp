import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TouchActions_Commands {
	IOSDriver driver;
	@Test
	public void launchApp() throws IOException{
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//UIANavigationBar[@name='UIView']/UIAButton[1]")).click();
		
		TouchAction act = new TouchAction(driver);
		WebElement datePicker= driver.findElement(By.name("Date Picker"));
		WebElement steppers= driver.findElement(By.name("Steppers"));
		int startY=steppers.getLocation().y;
		int endY=datePicker.getLocation().y;
		System.out.println(startY +" -- "+ endY);
		//act.press(datePicker, 30, 10).release().perform();
		
		//act.press(150, startY).moveTo(150, endY).release().perform();
		act.press(steppers, 30, 10).moveTo(datePicker).release().perform();
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);           

	    FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//screenshot//temp.jpg"));       
	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}
