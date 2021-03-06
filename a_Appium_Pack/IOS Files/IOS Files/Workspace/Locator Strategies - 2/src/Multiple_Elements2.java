import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class Multiple_Elements2 {

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
		
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]
		//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[2]

		List<WebElement> cells = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell"));
		System.out.println(cells.size());
		for(WebElement cell : cells){
			
			List<WebElement> staticTexts = cell.findElements(By.xpath("UIAStaticText"));
			System.out.println(staticTexts.size());
			
			for(WebElement staticText : staticTexts){
				System.out.println(staticText.getText());
				
			}
			System.out.println("----------");
			
		}
		System.out.println("end");
		
		/*
		cells = driver.findElements(By.xpath("//UIATableView/UIATableCell"));
		System.out.println(cells.size());
		cells = driver.findElements(By.xpath("//UIATableCell"));
		System.out.println(cells.size());
		*/
		

	}
	
	
	
	
	@AfterTest
	public void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
}
