package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TestBase {
	WebDriver driver;
	
	
	@FindBy(id="com.flipkart.android:id/filter_button")
	public WebElement filterButton;
	
	@FindBy(xpath="//android.widget.TextView[@text='Home']")
	public WebElement home;
	
	@FindBy(xpath="//android.widget.TextView[@text='Save Big!!']")
	public WebElement saveBig;
	
	
	
	public boolean isElementPresent(WebElement element) {
		try{
			element.getTagName();
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
}
