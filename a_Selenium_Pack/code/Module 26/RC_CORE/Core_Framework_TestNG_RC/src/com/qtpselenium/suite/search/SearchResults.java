package com.qtpselenium.suite.search;

import junit.framework.Assert;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.ErrorUtil;
import com.qtpselenium.util.TestUtil;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class SearchResults extends TestSuiteBase{
	String runmodes[]=null;
	static int count=-1;
	//static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	// Runmode of test case in a suite
	@BeforeTest
	public void checkTestSkip(){
		
		if(!TestUtil.isTestCaseRunnable(suite_search_xls,this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
			throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
		}
		// load the runmodes off the tests
		runmodes=TestUtil.getDataSetRunmodes(suite_search_xls, this.getClass().getSimpleName());
	}
	
	@Test(dataProvider="getTestData")
	public void searchTest(String searchString) throws InterruptedException{
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			skip=true;
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		
		APP_LOGS.debug(" Executing TestCase_A1");
		APP_LOGS.debug(searchString);
		
		// selenium code
        //String searchString="Obama"; // parameterized
		
		openBrowser();
		selenium.open("/");
		//Assert.assertEquals(OR.getProperty("landing_page_title"), selenium.getTitle());
		
		if(!compareTitles(OR.getProperty("landing_page_title"))){
			fail=true; // report error in xls file
			//return; // go back
		}
		
		
		selenium.click("//*[@id='fk-mS']");
		selenium.click("//*[@id='fk-mI']/ul/li[2]/div"); // clicking on books
		selenium.type("//*[@id='fk-top-search-box']", searchString);
		selenium.click("//*[@id='fk-header-search-form']/table/tbody/tr/td[4]/div/input");
		selenium.waitForPageToLoad("30000");
		
		String start="//*[@id='search_results']/div[";
		String end="]/div[2]";
		
		for(int i=3;i<=5;i++){
			
			System.out.println(selenium.getText(start+i+end));
			String text = selenium.getText(start+i+end).toLowerCase();
			try{
				Assert.assertTrue("Search string not found in book text", text.indexOf(searchString.toLowerCase())!=-1);
			}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t); // testng reports
				fail=true; // xls
				return;
			}
			
		}
		
		//Thread.sleep(5000L);
		//selenium.close();
		//selenium.stop();
		
		
	}
	
	@AfterMethod
	public void reportDataSetResult(){
		if(skip)
			TestUtil.reportDataSetResult(suite_search_xls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suite_search_xls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suite_search_xls, this.getClass().getSimpleName(), count+2, "PASS");
		
		skip=false;
		fail=false;
		

	}
	
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suite_search_xls, "Test Cases", TestUtil.getRowNum(suite_search_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_search_xls, "Test Cases", TestUtil.getRowNum(suite_search_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	
	@DataProvider
	public Object[][] getTestData(){
		return TestUtil.getData(suite_search_xls, this.getClass().getSimpleName()) ;
	}
	
	
	

}
