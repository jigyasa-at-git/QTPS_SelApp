package com.qtpselenium.mobile.flipkart.pages;

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
	
	
}
