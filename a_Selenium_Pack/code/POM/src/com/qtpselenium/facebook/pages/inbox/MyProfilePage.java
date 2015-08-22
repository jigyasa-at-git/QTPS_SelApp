package com.qtpselenium.facebook.pages.inbox;

import com.qtpselenium.facebook.base.Page;

public class MyProfilePage extends Page{
	
	
	// change your pic on facebook
	public void changePic(String newPicPath){
		click("edit_profile_pic");
		input("file_upload", newPicPath);
	}
	
	// loads the friendList
	public FriendList loadFriendList(){
		click("friends_link");
		return new FriendList();
	}

}
