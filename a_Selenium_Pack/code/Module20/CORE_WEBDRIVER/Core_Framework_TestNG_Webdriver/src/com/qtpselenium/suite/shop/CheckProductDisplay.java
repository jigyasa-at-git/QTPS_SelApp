package com.qtpselenium.suite.shop;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.ErrorUtil;
import com.qtpselenium.util.TestUtil;

public class CheckProductDisplay extends TestSuiteBase{
	String runmodes[]=null;
	static int count=-1;
	//static boolean pass=false;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	// Runmode of test case in a suite
	@BeforeTest
	public void checkTestSkip(){
		
		if(!TestUtil.isTestCaseRunnable(suite_shop_xls,this.getClass().getSimpleName())){
			APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
			throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
		}
		// load the runmodes off the tests
		runmodes=TestUtil.getDataSetRunmodes(suite_shop_xls, this.getClass().getSimpleName());
	}
	
	@Test
	public void testcaseA1(	){
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			skip=true;
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		
		APP_LOGS.debug(" Executing TestCase_A1");
		
		// selenium code
		openBrowser();
		driver.get("http://demo.virtuemart.net/");
		if(!checkElementPresence("shopLink"))
		{
			fail=true;
			return; // conditional
		}
		driver.findElement(By.xpath(OR.getProperty("shopLink"))).click();
		
		if(! compareTitle("Shop")){
			fail=true;
			return; // conditional
		}
		// wait
		
		WebElement featured_view = driver.findElement(By.className("featured-view"));
		
		int no_of_imgs= featured_view.findElements(By.tagName("img")).size();
		int no_of_show_links = featured_view.findElements(By.linkText("Show")).size();
		
		if(!compareNumbers(8, no_of_imgs)){
			fail=true;
			//return;
		}
		
		if(!compareNumbers(8, no_of_show_links)){
			fail=true;
			//return;
		}
		
		
		//closeBrowser();
		
	}
	
	@AfterMethod
	public void reportDataSetResult(){
		if(skip)
			TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suite_shop_xls, this.getClass().getSimpleName(), count+2, "PASS");
		
		skip=false;
		fail=false;
		

	}
	
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suite_shop_xls, "Test Cases", TestUtil.getRowNum(suite_shop_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_shop_xls, "Test Cases", TestUtil.getRowNum(suite_shop_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	
	
	
	
	

}
