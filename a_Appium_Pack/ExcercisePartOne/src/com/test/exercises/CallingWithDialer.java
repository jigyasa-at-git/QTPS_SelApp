package com.test.exercises;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class CallingWithDialer {

	AppiumDriver driver;

	@Test
	public void setUp() throws MalformedURLException, InterruptedException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Xperia Z1");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage",
				"com.sonyericsson.android.socialphonebook");
		capabilities.setCapability("appActivity",
				"com.sonyericsson.android.socialphonebook.LaunchActivity");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		
		
		
		WebElement frameLayout= driver.findElement(By.className("android.widget.FrameLayout"));
		WebElement horizontalScroll=frameLayout.findElement(By.className("android.widget.HorizontalScrollView"));
		List<WebElement> listOfChildren= horizontalScroll.findElements(By.className("android.app.ActionBar$Tab"));
		WebElement phoneIcon = listOfChildren.get(1);
		phoneIcon.click();
		
		//8968585110
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/eightNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/nineNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/sixNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/eightNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/fiveNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/eightNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/fiveNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/oneNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/oneNum")).click();
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/zeroNum")).click();
		
		driver.findElement(By.id("com.sonyericsson.android.socialphonebook:id/call_button")).click();
		 
		Thread.sleep(10000);
		
		driver.findElement(By.id("com.android.phone:id/endCallButton")).click();
		
		
	}
	
	@AfterTest
	public void quitDriver() throws InterruptedException{
		
		Thread.sleep(10000);
		driver.quit();
	}

}
