package rough.businessclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.qtpselenium.facebook.pages.FriendList;
import com.qtpselenium.facebook.pages.LandingPage;
import com.qtpselenium.facebook.pages.LoginPage;
import com.qtpselenium.facebook.pages.PersonalProfile;

public class FindFriend {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
		LandingPage landingPage = lp.doLogin("its.thakur@gmail.com","engineer");
		PersonalProfile personalProfile = landingPage.gotoProfile();
		FriendList frdList = personalProfile.loadFriendList();
		boolean b = frdList.findAfriend("Sadil Katoch");
		if(b)
			System.out.println("found friend");
		else
			System.out.println("not found");
	}

}
