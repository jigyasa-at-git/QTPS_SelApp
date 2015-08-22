package com.qtpselenium.mobile.flipkart.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.mobile.flipkart.pages.common.Menu;

public class ProductSelectionPage {
	
	
	
	public Menu menu;
	
	public WebDriver driver;
	
	public ProductSelectionPage(WebDriver driver){
		this.driver=driver;
		menu = PageFactory.initElements(driver, Menu.class);
	}

	public ProductDisplayPage randomSelectItem() {
		
		while(driver.findElements(By.xpath("//android.widget.TextView[starts-with(@text,'FILTER')]")).size() ==0){
			List<WebElement> items = driver.findElements(By.id("com.flipkart.android:id/expandable_cat_cell"));
			Random r = new Random();
			int x = r.nextInt(items.size());
			System.out.println(items.size() +" --- "+ x);
			System.out.println("Clicking on item - "+ items.get(x).getText());
			items.get(x).click();
		}
		
		 return PageFactory.initElements(driver, ProductDisplayPage.class);
		
	}
	
	
}
