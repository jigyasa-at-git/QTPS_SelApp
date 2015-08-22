import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//http://qtpselenium.com/test/unpredictable.php
public class Popup {
	static WebDriver driver;
	
public static void main(String[] args) throws InterruptedException {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://qtpselenium.com/test/unpredictable.php");
		closePopupIfPresent();
		
	}


	public static void closePopupIfPresent(){
		
		Set<String> winIds = driver.getWindowHandles();
		System.out.println("Total windows -> "+ winIds.size());
		
		if(winIds.size() == 2){
			Iterator<String> iter = winIds.iterator();
			String mainWinID = iter.next();
			String popupWinID = iter.next();
			driver.switchTo().window(popupWinID);
			driver.close();
			driver.switchTo().window(mainWinID);
			
		}
	
	}

}
