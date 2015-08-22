package com.qtpselenium.facebook.testCases;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.base.Page;
import com.qtpselenium.facebook.pages.inbox.LandingPage;
import com.qtpselenium.facebook.pages.inbox.MyProfilePage;
import com.qtpselenium.facebook.pages.login.LoginPage;
import com.qtpselenium.util.TestUtil;

public class ChangePicTest {
	
	
	@Test
	public void changePic(){
		
		if(!TestUtil.isExecutable("ChangePicTest",Page.xls1))
			 throw new SkipException("Runmode set to NO");
		LandingPage landingPage=null;
		// logged in
		if(!Page.isLoggedIn){
			LoginPage loginPage = new LoginPage();
			landingPage= loginPage.doLogin();
		}else{
		// i am logged in
			landingPage =  Page.topMenu.gotoLandingPage();
		}
		
		MyProfilePage profilePage = landingPage.gotoProfile();
		//profilePage.changePic("");
	}

}
