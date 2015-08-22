package com.qtpselenium.facebook.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.qtpselenium.util.Constants;

public class FriendList {
	@FindBy(xpath=Constants.friendSearchBox)
	WebElement searchBox;
	WebDriver driver;
	
	public FriendList(WebDriver dr){
		driver=dr;
	}
	
	public boolean findAfriend(String friendName){
		searchBox.sendKeys(friendName);
		int friends = driver.findElements(By.linkText(friendName)).size();
		
		if(friends==0)
			return false;
		else
			return true;
		
		
	}

}
