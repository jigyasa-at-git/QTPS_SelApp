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

public class CallingFromContactListTest {
	AppiumDriver driver;

	@Test
	public void setUpDriver() throws MalformedURLException,
			InterruptedException {
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

		WebElement list = driver.findElement(By.id("android:id/list"));

		/*
		 * List<WebElement> reLayouts=
		 * list.findElements(By.className("android.widget.RelativeLayout"));
		 * for(int i =0;i<reLayouts.size();i++){ WebElement contactName=
		 * reLayouts.get(i).findElement(By.id(
		 * "com.sonyericsson.android.socialphonebook:id/list_item_name"));
		 * if(contactName.getText().equals("Aadi R")) { contactName.click();
		 * driver.findElement(By.id(
		 * "com.sonyericsson.android.socialphonebook:id/actions_view_container"
		 * )).click(); Thread.sleep(10000);
		 * driver.findElement(By.id("com.android.phone:id/endCallButton"
		 * )).click(); break; } }
		 */
		
		driver.scrollTo("Ashish Thakur Sir");
		List<WebElement> reLayouts = list.findElements(By
				.className("android.widget.RelativeLayout"));
		for (int i = 0; i < reLayouts.size(); i++) {
			WebElement contactName = reLayouts
					.get(i)
					.findElement(
							By.id("com.sonyericsson.android.socialphonebook:id/list_item_name"));
			if (contactName.getText().equals("Ashish Thakur Sir")) {
				contactName.click();
				driver.findElement(
						By.id("com.sonyericsson.android.socialphonebook:id/actions_view_container"))
						.click();
				Thread.sleep(10000);
				driver.findElement(By.id("com.android.phone:id/endCallButton"))
						.click();
				break;
			}
		}

	}

	@AfterTest
	public void stopServer() throws InterruptedException {

		Thread.sleep(10000);
		driver.quit();
	}
}
