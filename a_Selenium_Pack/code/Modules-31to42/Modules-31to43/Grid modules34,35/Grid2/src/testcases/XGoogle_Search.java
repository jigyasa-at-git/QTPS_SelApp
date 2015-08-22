package testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XGoogle_Search {
	
	@Parameters("browser")
	@Test
	public void searchTest(String b) throws MalformedURLException{
		System.out.println(b);
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
		
		// give URL of Hub
		RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		driver.get("http://gmail.com");
		driver.findElement(By.id("Email")).sendKeys("username");
		driver.findElement(By.id("Passwd")).sendKeys("xxxxxxx");
		
	}

}
