import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class ContactManager {
	AppiumDriver dr;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{

		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\ContactManager.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
         capabilities.setCapability("deviceName","Nexus 5");
         capabilities.setCapability("platformVersion", "4.4.4");
         capabilities.setCapability("platformName","Android");
	     capabilities.setCapability("app", app.getAbsolutePath());
         dr = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
         dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         
         String name="Abhik Lodh";
         
         String className="android.widget.Button";
         String jsonString="[[[4,\"" + className + "\"]],[[10,\"" + className + "\"]]]";
        // String jsonString="[[[1,\"" + name + "\"]]]";
         try{
        	 MobileElement obj = dr.complexFind(jsonString);
        	 obj.click();
         }catch(Exception e){
        	 e.printStackTrace();
         }
         
        dr.findElement(By.id("com.example.android.contactmanager:id/contactPhoneTypeSpinner")).click();
        jsonString="[[[1,\"" + "Work" + "\"]]]";
        dr.complexFind(jsonString).click();
        
        
        WebElement s = dr.findElement(By.id("com.example.android.contactmanager:id/contactPhoneTypeSpinner"));
        String t = s.findElement(By.className("android.widget.TextView")).getText();
        System.out.println(t);
        
        
        dr.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).sendKeys("hello");
        Thread.sleep(3000);
        dr.findElement(By.id("com.example.android.contactmanager:id/contactNameEditText")).clear();
        Thread.sleep(3000);
        
         
	}
	
	@AfterTest
	public void quit(){
		if(dr!=null)
			dr.quit();
	}
}
