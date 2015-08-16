import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class DatePicker {
	AppiumDriver driver;
	@Test
	public void testApp() throws MalformedURLException, InterruptedException, ParseException{

		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.cubereflect.simple.organizer-1.apk");
		 DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("deviceName","Nexus 5");
	        capabilities.setCapability("platformVersion", "4.4.4");
	        capabilities.setCapability("platformName","Android");
		    capabilities.setCapability("app", app.getAbsolutePath());
		    driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		 
		    driver.findElement(By.id("com.cubereflect.simple.organizer:id/createEvent")).click();
		    driver.findElement(By.id("com.cubereflect.simple.organizer:id/eventFromDate")).click();
		    
		    String d="14/10/2017";//dd//mm/yyyy
		    
		    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		    Date date = formatter.parse(d);
			System.out.println(date);
			
			
		    String month=new SimpleDateFormat("MMM").format(date);
		    String date1=new SimpleDateFormat("dd").format(date);
		    int yearToBeSelected=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
		    int s = driver.findElements(By.id("android:id/numberpicker_input")).size();
		    System.out.println("Total fields - "+ s);
		    WebElement yearObj = driver.findElements(By.id("android:id/numberpicker_input")).get(2);
		    int currentYear = Integer.parseInt(yearObj.getText());
		    System.out.println(currentYear);
		    System.out.println(driver.findElements(By.id("android:id/increment")).size());
		    WebElement incrementYear=driver.findElements(By.id("android:id/increment")).get(2);
		    WebElement decrementYear=driver.findElements(By.id("android:id/decrement")).get(2);
		    
		    while(!(currentYear == yearToBeSelected)){
		    	if(currentYear>yearToBeSelected){
		    		// -
		    		decrementYear.click();
		    	}else{
		    		//+
		    		incrementYear.click();
		    	}
		    	//crashes
		    	if(!(driver.findElements(By.id("com.cubereflect.simple.organizer:id/eventFromDate")).size()==0))
			    driver.findElement(By.id("com.cubereflect.simple.organizer:id/eventFromDate")).click();
		    	
		    	currentYear = Integer.parseInt(yearObj.getText());
		    }
	       
	}
	@AfterTest
	public void quit(){
		if(driver!=null)
			driver.quit();
	}
}
