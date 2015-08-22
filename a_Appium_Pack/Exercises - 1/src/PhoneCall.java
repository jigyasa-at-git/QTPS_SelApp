import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PhoneCall {
	static WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("deviceName","Nexus 5");
	    capabilities.setCapability("platformVersion", "4.4.4");
	    capabilities.setCapability("platformName","Android");
	    capabilities.setCapability("appPackage",
				"com.android.contacts");
		capabilities.setCapability("appActivity",
				"com.android.contacts.activities.PeopleActivity");
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void closeApp(){
		driver.quit();
	}
	
	
	
	@Test(dataProvider="getData")
	public void call(String contact) throws MalformedURLException{
		
	    driver.findElement(By.id("com.android.contacts:id/menu_search")).click();
	    driver.findElement(By.id("android:id/search_src_text")).sendKeys(contact);
	    driver.findElement(By.id("com.android.contacts:id/cliv_name_textview")).click();
	    driver.findElement(By.id("com.android.contacts:id/data")).click();
	    
	}
	
	@DataProvider
	public Object[][] getData(){
		
		Object[][] data = new Object[3][1];
		data[0][0]="xyz";
		data[1][0]="abc";
		data[2][0]="ijk";
		
		return data;
		
	}

}
