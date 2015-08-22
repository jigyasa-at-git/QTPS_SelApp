import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;



public class Simple_Test {


	public static void main(String[] args) {

		
		/*FirefoxProfile fp = new FirefoxProfile();
		
		fp.setPreference("general.useragent.override", "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; sdk Build/JB_MR1.1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30");
		WebDriver driver = new FirefoxDriver(fp);
		*/
		WebDriver driver = new AndroidDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://gmail.com");
		
		driver.findElement(By.id("Email")).sendKeys("qtpselenium@gmail.com");
		driver.findElement(By.id("Passwd")).sendKeys("whizdomtrainings");
		driver.findElement(By.id("signIn")).click();
		
		List<WebElement> allSenders = driver.findElements(By.xpath("//div[@class='Ki Mn']"));
		System.out.println("Total emails -> "+ allSenders.size());
		
		/*
		for(int i =0;i<allSenders.size();i++){
			System.out.println(allSenders.get(i).getText());
			if(allSenders.get(i).getText().equals("Slik SVN")){
				allSenders.get(i).click();
				break;
			}
		}
		
		*/
		//driver.getTouch().scroll(0, 50);
		//driver.getTouch().doubleTap(arg0)
		//driver.getTouch().flick(arg0, arg1)
		
		
		
		
		
		
		
		
		
		
		//WebDriver driver = new FirefoxDriver();
		
		/*WebDriver driver = new AndroidDriver();
		driver.get("http://facebook.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		System.out.println(js.executeScript("return navigator.userAgent"));
		*/
		
		
		
		//driver.get("http://facebook.com");
		
		//System.out.println(driver.getPageSource());
		
	}

}
