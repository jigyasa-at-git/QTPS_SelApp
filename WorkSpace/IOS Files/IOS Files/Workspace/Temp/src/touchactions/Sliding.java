package touchactions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sliding {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformVersion", "8.1");
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 5s");
		File app = new File(System.getProperty("user.dir")+"//app/UICatalog.app");
		cap.setCapability("app", app.getAbsolutePath());
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int screenwidth = driver.manage().window().getSize().width;
		int screenheight = driver.manage().window().getSize().height;
		System.out.println("Phone screen width-> "+screenwidth);
		System.out.println("Phone screen height-> "+screenheight);
		driver.findElementByIosUIAutomation("UIATarget.localTarget().frontMostApp().navigationBar().leftButton()").click();
		/*
		driver.findElement(By.name("Sliders")).click();
		List<WebElement> sliders = driver.findElements(By.xpath("//UIASlider"));
		
		System.out.println(sliders.size());
		WebElement firstSlider = sliders.get(0);
		System.out.println("Slider width -> " +firstSlider.getSize().width);
		int percentage = Integer.parseInt(firstSlider.getAttribute("value").substring(0,2));
		System.out.println("Percentage covered ->"+percentage);
		int x=(int)(firstSlider.getSize().width * (.01) * percentage);
		System.out.println(x);
		int y=firstSlider.getLocation().y;
		System.out.println(y);
		TouchAction touch = new TouchAction(driver);
		int buffer=(screenwidth-firstSlider.getSize().width)/2;
		System.out.println("Buffer ->"+buffer);
		touch.press(x+buffer, y).moveTo(x+buffer+50, y).release();
		sliders = driver.findElements(By.xpath("//UIASlider"));
		System.out.println(sliders.size());
		firstSlider = sliders.get(0);
		percentage = Integer.parseInt(firstSlider.getAttribute("value").substring(0,2));
		System.out.println("Percentage covered ->"+percentage);
		*/
		TouchAction touch = new TouchAction(driver);
		touch.press(driver.findElement(By.name("Image View")),100,30).moveTo(driver.findElement(By.name("Buttons")),100,30).release().perform();
	}

}
