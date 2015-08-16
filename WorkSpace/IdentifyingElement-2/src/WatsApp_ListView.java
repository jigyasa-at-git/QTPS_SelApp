import io.appium.java_client.AppiumDriver;

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


public class WatsApp_ListView {
	AppiumDriver driver;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{

		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.whatsapp-2.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		    capabilities.setCapability("app", app.getAbsolutePath());
		    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    WebElement listView = driver.findElement(By.id("android:id/list"));
		    List<WebElement> allChats = listView.findElements(By.className("android.widget.RelativeLayout"));
		    System.out.println("Total - "+allChats.size());
		    
		    WebElement secondChat = allChats.get(1);
		    System.out.println("Text - "+ secondChat.getText());
	       	
	       	
	       	
	       
	}
	@AfterTest
	public void quit(){
		if(driver!=null)
			driver.quit();
	}

}
