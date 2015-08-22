package com.qtpselenium.facebook.testCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qtpselenium.facebook.base.Page;
import com.qtpselenium.facebook.pages.inbox.FriendList;
import com.qtpselenium.facebook.pages.inbox.LandingPage;
import com.qtpselenium.facebook.pages.inbox.MyProfilePage;
import com.qtpselenium.facebook.pages.login.LoginPage;
import com.qtpselenium.util.TestUtil;

public class FindaFriendTest {
	
	
	@Test
	public void findFriend(){
		String friendName="xxxxxx";//"Vishnu Prabhakar"; // read from xls
		System.out.println("findFriend");
		if(!TestUtil.isExecutable("FindaFriendTest",Page.xls1))
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
		MyProfilePage prof = landingPage.gotoProfile();
		FriendList fs = prof.loadFriendList();
		Assert.assertTrue(fs.searchFriend(friendName), friendName +" - Friend Not Present");
	}
	
	
	@Test(dependsOnMethods = { "findFriend" })
	public void messageFriend(){
		System.out.println("messageFriend");

	}

}
