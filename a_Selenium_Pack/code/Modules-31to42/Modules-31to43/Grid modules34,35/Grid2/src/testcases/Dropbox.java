package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static Util.Utility.driver;


public class Dropbox {

	
	@Test(dataProvider="getData")
	public void dropBox(String name, String b) throws MalformedURLException{
		System.out.println("Dropbox " + b);
		// RemoteWebdriver
		DesiredCapabilities cap = null;
				
		if(b.equals("firefox")){
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox"); // chrome,iexplore
			cap.setPlatform(Platform.ANY);
		}else if (b.equals("chrome")){
			cap = DesiredCapabilities.chrome(); // no need path of chrome exe
			cap.setBrowserName("chrome");
			cap.setPlatform(Platform.ANY);
		}else if (b.equals("iexplore")){
			cap = DesiredCapabilities.internetExplorer(); // no need path of chrome exe
			cap.setBrowserName("iexplore");
			cap.setPlatform(Platform.WINDOWS);
		}
		cap.setCapability("_important", "1");
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		
		
		driver.get("http://dropbox.com");
		driver.findElement(By.id("fname")).sendKeys(name);
		
		
		driver.quit();
		
	}
	
	
	@DataProvider(parallel=true)
	public Object[][] getData(){
		
		Object data[][] = new Object[2][2];
		// row 1
		data[0][0]="ashish";
		data[0][1]="chrome";
		
		// row 2
		data[1][0]="tom";
		data[1][1]="firefox";
		
		
		return data;
		
	}
	
	
	
	
}
