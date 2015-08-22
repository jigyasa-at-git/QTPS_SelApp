package com.qtpselenium.facebook.pages.inbox;

import org.openqa.selenium.By;

import com.qtpselenium.facebook.base.Page;

public class TopMenu {
	
	// logs you out
	public void Logout(){
	// webdriver
		Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_list"))).click();
		Page.driver.findElement(By.xpath(Page.OR.getProperty("top_menu_logout"))).click();
	}
	
	// Searching
	public void search(String searchText){
		
	}
	
	// goes to landing page
	public LandingPage gotoLandingPage(){
		Page.driver.findElement(By.xpath(Page.CONFIG.getProperty("homePage_link"))).click();
		return new LandingPage();
	}

}
