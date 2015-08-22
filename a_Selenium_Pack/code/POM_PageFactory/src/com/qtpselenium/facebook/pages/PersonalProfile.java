package com.qtpselenium.facebook.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.util.Constants;

public class PersonalProfile {
	@FindBy(xpath=Constants.friendsLink)
	WebElement friendsLink;
	@FindBy(xpath=Constants.editProfile)
	WebElement editProfile;
	@FindBy(xpath=Constants.uploadPhoto)
	WebElement uploadPhoto;
	
	
	
	WebDriver driver;
	
	public PersonalProfile(WebDriver dr){
		driver=dr;
	}
	
	public FriendList loadFriendList(){
		friendsLink.click();
		return  PageFactory.initElements(driver, FriendList.class);
	}
	
	
	
	public void changeProfilePic(String newPicPath){
		editProfile.click();
		uploadPhoto.sendKeys(newPicPath);
		
	}
	
	
	
	
	
	

}
