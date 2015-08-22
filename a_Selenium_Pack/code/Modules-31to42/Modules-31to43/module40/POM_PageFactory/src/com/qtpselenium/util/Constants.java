package com.qtpselenium.util;

public class Constants {
	
	
	// PATHS
	public static String CONFIG_FILE_PATH =System.getProperty("user.dir")+"//src//com//qtpselenium//config/config.properties";
	
	// xpaths, ids
	// Login Page
	public static final String username="//*[@id='email']";
	public static final String password="//*[@id='pass']";
	
	// Landingpage
	public static final String profileLink="//*[@id='pagelet_welcome_box']/div/div/div/div[2]/a";
	
	
	// personal profile
	public static final String friendsLink="//div[@class='timelineReportCol titleWithSubtitle']/a";
	public static final String editProfile="//div[@id='fbProfilePicSelector']/div/a/span";
	public static final String uploadPhoto ="//input[@class='fbTimelineSelectorFileInput']";
	
	// friend list
	public static final String friendSearchBox="html/body/div[3]/div/div[1]/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div/div/div/div/div[1]/table/tbody/tr/td[2]/table/tbody/tr/td[2]/div[2]/div/div/input";
	
	
	// Top Menu
	public static final String dropList="//div[@id='userNavigationLabel']";
	public static final String accountSetting="//ul[@id='userNavigation']/li[5]/a";
	public static final String homePage="//*[@id='pageLogo']/a";
	
	// Account settings
	public static final String editPassword="//*[@id='SettingsPage_Content']/ul/li[4]/a/span[2]";
	public static final String oldPassword="//*[@id='password_old']";
	public static final String newPassword="//*[@id='password_new']";
	public static final String confirmPassword="//*[@id='password_confirm']";
	public static final String confirmButton="//label[@class='submit uiButton uiButtonConfirm']/input";
	
	
	
	// Titles/text
	public static final String titleHomePage="Welcome to Facebook - Log In, Sign Up or Learn More";
	
	
	
}
