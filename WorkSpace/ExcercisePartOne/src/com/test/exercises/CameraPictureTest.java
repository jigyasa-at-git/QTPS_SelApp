package com.test.exercises;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class CameraPictureTest {

	AppiumDriver driver;

	@Test
	public void cameraTestSetup() throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Xperia Z1");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage",
				"com.sonyericsson.android.camera");
		capabilities.setCapability("appActivity",
				"com.sonyericsson.android.camera.CameraActivity");
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);

		
		driver.findElement(By.id("com.sonyericsson.android.camera:id/main_button")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.id("com.sonyericsson.android.camera:id/content_thumbnail_frame")).click();
	
	}
	
	@AfterTest
	public void stopServer() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
}
