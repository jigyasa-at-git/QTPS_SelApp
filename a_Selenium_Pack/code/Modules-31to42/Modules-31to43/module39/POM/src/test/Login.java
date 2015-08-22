package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qtpselenium.facebook.base.Page;
import com.qtpselenium.facebook.pages.inbox.FriendList;
import com.qtpselenium.facebook.pages.inbox.LandingPage;
import com.qtpselenium.facebook.pages.inbox.MyProfilePage;
import com.qtpselenium.facebook.pages.login.LoginPage;

public class Login {

// make the navigational structure
// Validations - testng/junit
// reporting part
// parameterize tests
// ant
// Logging
// Mailing reports
	public static void main(String[] args) {

		LoginPage l = new LoginPage();
		LandingPage landingPage = l.doLogin("its.thakur@gmail.com", "confirm123");
		//landingPage.topMenu.Logout();
		MyProfilePage myProfile = landingPage.gotoProfile();
		//myProfile.changePic("H:\\Documents and Settings\\Administrator\\Desktop");
		FriendList friendList = myProfile.loadFriendList();
		boolean r = friendList.searchFriend("Vishnu Prabhakar");
		System.out.println(r);
		//LandingPage p = l.doLogin("", "");
	//	p.gotoProfile();
		
	}

}
