package com.qtpselenium.facebook.pages.inbox;

import org.openqa.selenium.WebDriver;

import com.qtpselenium.facebook.base.Page;

public class LandingPage extends Page{
	
	
	
	
	public MyProfilePage gotoProfile(){
     click("go_to_profile");
     return new MyProfilePage();
	
	}
	
	
	

}
