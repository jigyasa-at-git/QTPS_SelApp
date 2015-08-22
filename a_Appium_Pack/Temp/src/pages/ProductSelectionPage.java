package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSelectionPage extends TestBase{
	
	
	@FindBy(id="android:id/up")
	public WebElement navigation;
	

	
	public ProductSelectionPage(WebDriver driver){
		super.driver=driver;
	}

	public HomePage iterateProductCategories() {
		AndroidDriver androidDriver=(AndroidDriver)driver;
		List<WebElement> allElements= androidDriver.findElementsByAndroidUIAutomator("UiSelector().className(\"android.widget.TextView\").index(0)");
		
		System.out.println("Testing - " +allElements.get(0).getText());
		/*
		List<WebElement> listItems =driver.findElements(By.id("com.flipkart.android:id/expandable_cat_cell_text"));
		
		for(int itemNum=0;itemNum<allElements.size();itemNum++){
			listItems.get(itemNum).click();
		}
		*/
		androidDriver.sendKeyEvent(AndroidKeyCode.BACK);
		return PageFactory.initElements(driver, HomePage.class);

		
	}


}
