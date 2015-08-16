package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProductDisplayPage extends TestBase{


	public ProductDisplayPage(WebDriver driver){
		super.driver=driver;
	}
	public HomePage iterate() {
		AndroidDriver androidDriver=(AndroidDriver)driver;
		androidDriver.sendKeyEvent(AndroidKeyCode.BACK);
		return PageFactory.initElements(driver, HomePage.class);
	}

}
