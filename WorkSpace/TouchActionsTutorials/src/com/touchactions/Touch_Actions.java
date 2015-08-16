package com.touchactions;

import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Touch_Actions {
	AppiumDriver driver;

	@Test
	public void xxx() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "XPERIA Z1");
		capabilities.setCapability("platformVersion", "4.4.4");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage",
				"com.javacodegeeks.android.dragndroptest");
		capabilities.setCapability("appActivity",
				"com.javacodegeeks.android.dragndroptest.MainActivity");

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);	}
}
