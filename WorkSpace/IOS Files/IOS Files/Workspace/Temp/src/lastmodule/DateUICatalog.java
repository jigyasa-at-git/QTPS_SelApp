package lastmodule;

import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DateUICatalog {
// https://discuss.appium.io/t/unable-to-automate-uipickerwheel/73/19
	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();

		driver.findElement(By.name("Date Picker")).click();
		List<WebElement> wheels = driver.findElements(By.className("UIAPickerWheel"));
		System.out.println(wheels.size());
	//	System.out.println(wheels.get(0).getAttribute("value"));
		//wheels.get(0).click();
		//wheels.get(0).sendKeys("Sun");
	//	wheels.get(2).sendKeys("11");
	//	wheels.get(3).sendKeys("am");
	//	wheels.get(0).click();
	//	System.out.println(wheels.get(0).getAttribute("value"));
		/*
		driver.executeScript("var datePicker = this.popupWindow().pickers()[0]"+
								"for (var i = 0; i < 5; ++i) {"+
									"datePicker.wheels()[0].tapWithOptions({tapOffset:{x:0.81, y:0.30}})"+
									"this.target().delay(.4);"+
								"}");
								*/
		driver.executeScript("UIATarget.localTarget().frontMostApp().mainWindow().pickers()[0].wheels()[0].tapWithOptions({tapOffset:{x:0.55, y:0.61}});");
		System.out.println(wheels.get(0).getAttribute("value"));
		
	}

}
