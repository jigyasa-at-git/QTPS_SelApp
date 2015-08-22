package com.qtpselenium.mobile.flipkart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.mobile.flipkart.pages.common.Menu;

public class HomePage {

	public Menu menu;
	public WebDriver driver;
	
	
	public HomePage(WebDriver driver){
		this.driver=driver;
		menu = PageFactory.initElements(driver, Menu.class);
	}
	
	public void openCart(){
		
	}
	
	
}
