package com.mobile.qtpselenium.makemytrip;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class MakeMyTripTest {
	
	AndroidDriver driver;
	@Test
	public void testApp() throws MalformedURLException, ParseException, InterruptedException{
		
		String fromCity="GOI";
		String toCity="CCU";
		String date="05/04/2015";
		File app = new File("F:\\Whizdom-Trainings\\Tools\\Appium\\apps\\com.makemytrip-1.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
	    capabilities.setCapability("deviceName","Nexus 5");
	    capabilities.setCapability("platformVersion", "4.4.4");
	    capabilities.setCapability("platformName","Android");
		capabilities.setCapability("app", app.getAbsolutePath());

		WebDriver dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver = (AndroidDriver)dr;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.makemytrip:id/menuItemText1")).click();
		/*
		driver.findElement(By.id("com.makemytrip:id/from_code")).click();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		selectCity(fromCity);
		driver.findElement(By.id("com.makemytrip:id/to_code")).click();
		driver.sendKeyEvent(AndroidKeyCode.BACK);
		selectCity(toCity);
		*/
		
		driver.findElement(By.id("com.makemytrip:id/from_day")).click();
		selectDate(date);
		driver.findElement(By.id("com.makemytrip:id/search_flights")).click();
		
		// prices
		List<WebElement> prices = driver.findElements(By.id("com.makemytrip:id/intl_fate_txt"));
		
		
	}
	
	// select the date
	public void selectDate(String date) throws ParseException {
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected = df.parse(date);
		Date currentDate = new Date();
		df = new SimpleDateFormat("MMMM");
		String monthToBeSelected = df.format(dateToBeSelected);
		df = new SimpleDateFormat("yyyy");
		String yearToBeSelected = df.format(dateToBeSelected);
		String expectedMonthYear=monthToBeSelected +" "+yearToBeSelected;
		
		df = new SimpleDateFormat("dd");
		String day=df.format(dateToBeSelected);
		System.out.println(day);//05
		if(day.startsWith("0"))
			day=day.substring(1);
		System.out.println(day);//5
		if(dateToBeSelected.after(currentDate)){
			
			String actualMonthYear=driver.findElement(By.id("com.makemytrip:id/title")).getText();
			while(!actualMonthYear.equals(expectedMonthYear)){
				System.out.println(actualMonthYear +"---"+expectedMonthYear);
				driver.findElement(By.id("com.makemytrip:id/calViewNextMonth")).click();
				actualMonthYear=driver.findElement(By.id("com.makemytrip:id/title")).getText();
			}
			
			
			
		}else if(dateToBeSelected.before(currentDate)){
			
		}
		//select day
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+day+"']")).click();

		
	}

	//select the city
	public void selectCity(String cityName){
		//driver.findElement(By.id("com.makemytrip:id/editCitySearch")).sendKeys(cityName);
		//driver.findElement(By.xpath("//android.widget.TextView[@text='"+cityName+"']")).click();
		
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"com.makemytrip:id/editCitySearch\")").sendKeys(cityName);
		driver.findElementsByAndroidUIAutomator("UiSelector().text(\""+cityName+"\")").get(1).click();
		
		

	}

}
