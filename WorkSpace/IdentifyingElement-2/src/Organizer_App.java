import io.appium.java_client.AndroidKeyCode;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

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


public class Organizer_App {
	AppiumDriver driver;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException{

		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.cubereflect.simple.organizer-1.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		    capabilities.setCapability("app", app.getAbsolutePath());
		    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		    
		    // total buttons
		    int t = driver.findElements(By.xpath("//android.widget.Button")).size();
		    System.out.println("Total buttons on page - "+ t);
	       	
	       	
	       	t = driver.findElements(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]")).size();
		    System.out.println("Total scroll views - "+ t);
		    
		    
		    t = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.ScrollView\").className(\"android.widget.LinearLayout\").index(1)").size();
		    System.out.println("From UI Automator - "+t);
		    
		    // Way 1
		    List<WebElement> linearLayouts = driver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.ScrollView\").className(\"android.widget.LinearLayout\").index(1)");
		    WebElement buttonBox = linearLayouts.get(0);
		    
		    // how to find object inside object using AndroidUIAutomator
		    t = buttonBox.findElements(By.className("android.widget.Button")).size();
		    System.out.println("Total buttons - "+t);
		    
		    
		    System.out.println("*************Way 2***************");
		    // way 2
	       	WebElement scrollView = driver.findElement(By.className("android.widget.ScrollView"));
	       	List<WebElement> linearLayouts1 =scrollView.findElements(By.className("android.widget.LinearLayout"));
	       	
	       	System.out.println("Total linear layouts in scroll view - "+linearLayouts1.size());
	       	
	       	for( WebElement e : linearLayouts1){
	       		System.out.println(e.getLocation().getX()+","+e.getLocation().getY());
	       	}
	       	
	       	WebElement box = linearLayouts1.get(2);
	       	t = box.findElements(By.className("android.widget.Button")).size();
		    System.out.println("Total buttons - "+t);
		    System.out.println("***********Way 3************");
		    // way 3
	       	//WebElement scrollView1 = driver.findElement(By.className("android.widget.ScrollView"));
		    
		    String className="android.widget.ScrollView";
	         String jsonString="[[[4,\"" + className + "\"]]]";
	         MobileElement scrollView1=null; 
	         try{
	        	 scrollView1 = driver.complexFind(jsonString);
	         }catch(Exception e){
	        	 e.printStackTrace();
	         }
	         
	         List<WebElement> objs = scrollView1.findElementsByAndroidUIAutomator("UiSelector().index(1)");
	         System.out.println("Total  = "+ objs.size());

	         for(WebElement e : objs){
	        	 System.out.println(e.getAttribute("className"));
	         }
	         WebElement box1= objs.get(1);
	         t = box1.findElements(By.className("android.widget.Button")).size();
			 System.out.println("Total buttons - "+t);
	         
	         
		    
	       
	}
	@AfterTest
	public void quit(){
		if(driver!=null)
			driver.quit();
	}
}
