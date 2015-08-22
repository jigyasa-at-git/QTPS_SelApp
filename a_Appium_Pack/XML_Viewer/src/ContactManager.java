import io.appium.java_client.AppiumDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ContactManager {
	AppiumDriver dr;
	@Test
	public void testApp() throws InterruptedException, Exception{

		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\ContactManager.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("deviceName","Nexus 5");
         capabilities.setCapability("platformVersion", "4.4.4");
         capabilities.setCapability("platformName","Android");
	     capabilities.setCapability("app", app.getAbsolutePath());
         dr = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         Thread.sleep(5000);
         String src = dr.getPageSource();
         
         System.out.println(src);
         // save src as xml
        
        	 
         String fileLocation="F:\\Whizdom-Trainings\\Tools\\Appium\\Modules\\XML View\\contactmanager.xml";
         File file = new File(fileLocation);
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(src);
			bw.close();
			
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///"+fileLocation);
  
  
 		int s = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.example.android.contactmanager:id/contactEntryText']")).size();
 		System.out.println("Total - "+ s);
         
	}
	
	@AfterTest
	public void quit(){
		if(dr!=null)
			dr.quit();
	}
}
