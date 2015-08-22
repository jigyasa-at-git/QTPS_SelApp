package com.qtpselenium.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.util.Constants;

public class LandingPage {
	WebDriver driver;
	
	
	@FindBy(xpath=Constants.profileLink)
	public WebElement profileNameLink;
	
	
	public LandingPage(WebDriver dr){
		driver = dr;
	}
	
	public PersonalProfile gotoProfile(){
		profileNameLink.click();
		return PageFactory.initElements(driver, PersonalProfile.class);
	}

}
