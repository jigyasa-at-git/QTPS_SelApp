package com.qtpselenium.mobile.flipkart.pages.common;

import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qtpselenium.mobile.flipkart.pages.HomePage;
import com.qtpselenium.mobile.flipkart.pages.ProductDisplayPage;
import com.qtpselenium.mobile.flipkart.pages.ProductSelectionPage;

public class Menu {
	
	@FindBy(id="android:id/up")
	WebElement backIcon;
	
   public WebDriver driver;
	
	
	public Menu(WebDriver driver){
		this.driver=driver;
	}
	
	
	public void swipeAndOpenMenu(){
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("com.flipkart.android:id/menu_search")));
		
		
		AndroidDriver androidDriver  =(AndroidDriver) driver;
		androidDriver.swipe(50, 600, 900, 600, 2000);
	}
	
	public Object clickOnMenuItem(String text) throws InterruptedException{
		System.out.println("Clicking on menu item - "+text);
		// element is in the view
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		AndroidDriver androidDriver  =(AndroidDriver) driver;
		while(driver.findElements(By.xpath("//android.widget.TextView[@text='"+text+"']")).size() ==0){
			androidDriver.swipe(300, 1600, 300, 1200, 2000);
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+text+"']")).click();
		Thread.sleep(3000);
		
		int s = driver.findElements(By.id("com.flipkart.android:id/expandable_cat_cell")).size();
		//System.out.println("Total - "+s);
		
		int width=driver.findElement(By.id("com.flipkart.android:id/multiwidgetScrollView")).getSize().width;
		//System.out.println("Width of scrollview - "+width);
		
		if(width ==1080  & s > 0){
			ProductSelectionPage psPage = PageFactory.initElements(driver, ProductSelectionPage.class);
			return psPage;
		}if(driver.findElements(By.xpath("//android.widget.TextView[@text='FILTERS']")).size() >0){
			ProductDisplayPage  pdPage=PageFactory.initElements(driver, ProductDisplayPage.class);
			return pdPage;
		}else{
			HomePage   homePage=PageFactory.initElements(driver, HomePage.class);
			return homePage;
		}

		
		
	}
	
	public void clickOnBackIcon(){
		backIcon.click();
	}

}
