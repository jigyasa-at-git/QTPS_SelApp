package pages;

import io.appium.java_client.android.AndroidDriver;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase{
	
	@FindBy(id="android:id/up")
	public WebElement navigation;
		
	public HomePage(WebDriver driver){
		super.driver=driver;
	}
	
	public void gotoNavigation(){
		navigation.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.flipkart.android:id/multiwidgetScrollView")));
	}
		
	public Object clickOnMenu(String text){
		System.out.println("Clicking on "+text);
		AndroidDriver androidDriver =(AndroidDriver) driver;
		
		
		while(androidDriver.findElements(By.xpath("//android.widget.TextView[@text='"+text+"']")).size() !=1){
			androidDriver.swipe(100, 850, 100, 700, 2000);
		}
		androidDriver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isElementPresent(filterButton))
			return PageFactory.initElements(driver, ProductDisplayPage.class);
		else if(isElementPresent(saveBig))
			return PageFactory.initElements(driver, ProductSelectionPage.class);
		//else if(isElementPresent(home)){
		else{
			return PageFactory.initElements(driver, HomePage.class);
		}


	}

	

	

}
