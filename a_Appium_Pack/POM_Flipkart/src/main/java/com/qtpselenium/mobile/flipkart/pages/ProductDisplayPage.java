package com.qtpselenium.mobile.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.mobile.flipkart.pages.common.Menu;

public class ProductDisplayPage {

	@FindBy(xpath="//android.widget.TextView[starts-with(@text,'FILTER')]")
	public WebElement filterProd;
	String currentProduct;
	
	public Menu menu;
	
	public WebDriver driver;
	
	
	public ProductDisplayPage(WebDriver driver){
		this.driver=driver;
		menu = PageFactory.initElements(driver, Menu.class);
	}


	public FilterPage gotoFilters() {
		filterProd.click();
		return PageFactory.initElements(driver, FilterPage.class);
		
	}
	
	public void verifyProductNames(){
		// compare
		
	WebElement firstProduct = driver.findElement(By.id("com.flipkart.android:id/product_list_product_item_main_text"));
	System.out.println("****Matches ***");
	System.out.println(firstProduct.getText().startsWith(getCurrentProduct()));
						
	}
	
	
	public void setCurrentProduct(String currentProduct){
		this.currentProduct=currentProduct;
	}
	
	public String getCurrentProduct(){
		return currentProduct;
	}
	
	
	
	
}
