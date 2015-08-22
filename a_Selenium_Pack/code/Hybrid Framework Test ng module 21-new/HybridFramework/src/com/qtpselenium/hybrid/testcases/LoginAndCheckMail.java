package com.qtpselenium.hybrid.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.hybrid.util.Keywords;
import com.qtpselenium.hybrid.util.TestUtil;

public class LoginAndCheckMail {
	
	
	@Test(dataProvider="getLoginData")
	public void LoginTest(Hashtable<String,String> data){
		
		if(!TestUtil.isTestCaseExecutable("LoginTest", Keywords.xls))
		  throw new SkipException("Skipping the test as Runmode is NO");
		if(!data.get("RunMode").equals("Y"))
			  throw new SkipException("Skipping the test as data set Runmode is NO");

		System.out.println("***LoginTest***");
		Keywords k = Keywords.getKeywordsInstance();
		k.executeKeywords("LoginTest",data);
		
	}
	

	@Test(dependsOnMethods = { "LoginTest" },dataProvider="getCheckMailData")
	public void checkMailTest(Hashtable<String,String> data){
		// log you in app
		if(!TestUtil.isTestCaseExecutable("CheckMail", Keywords.xls))
			  throw new SkipException("Skipping the test as Runmode is NO");
		if(!data.get("RunMode").equals("Y"))
			  throw new SkipException("Skipping the test as data set Runmode is NO");

			
		
		System.out.println("****checkMailTest***");
		Keywords k = Keywords.getKeywordsInstance();
		k.executeKeywords("CheckMail",data);
		
	}
	
	@DataProvider
	public Object[][] getLoginData(){
		return TestUtil.getData("LoginTest", Keywords.xls);
	}
	
	@DataProvider
	public Object[][] getCheckMailData(){
		return TestUtil.getData("CheckMail", Keywords.xls);
	}

}
