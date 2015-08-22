package com.qtpselenium.mobile.flipkart.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.mobile.flipkart.pages.common.Menu;

public class FilterPage {
	
	@FindBy(xpath="//android.widget.TextView[@text='Brand']")
	public WebElement brand;
	
	@FindBy(id="com.flipkart.android:id/apply_filters")
	public WebElement applyFilter;
	
	@FindBy(id="com.flipkart.android:id/clear_filters")
	public WebElement clearFilter;
	

	public Menu menu;
	public WebDriver driver;
	
	
	public FilterPage(WebDriver driver){
		this.driver=driver;
		menu = PageFactory.initElements(driver, Menu.class);
	}
	
	public ProductDisplayPage filterOnBrand(){
		brand.click();
		Random r = new Random();
		List<WebElement> allOptions = driver.findElements(By.id("com.flipkart.android:id/text"));
		int x = r.nextInt(allOptions.size());
		
		System.out.println("Clicking on Brand - "+allOptions.get(x).getText());
		String productText = allOptions.get(x).getText().split("\\(")[0];
		allOptions.get(x).click();
		ProductDisplayPage pdPage = clickOnApplyFilters();
		pdPage.setCurrentProduct(productText);
		return pdPage;
		
		
	}
	
	public ProductDisplayPage clickOnApplyFilters(){
		applyFilter.click();
		return PageFactory.initElements(driver, ProductDisplayPage.class);
	}

	public void clearFilter() {
		clearFilter.click();
		
	}
	
	
}
