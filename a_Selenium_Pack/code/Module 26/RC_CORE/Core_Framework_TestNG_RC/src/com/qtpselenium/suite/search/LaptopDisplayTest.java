package com.qtpselenium.suite.search;

import java.util.Random;

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

public class LaptopDisplayTest extends TestSuiteBase{
	String runmodes[]=null;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	static int count=-1;
	// Runmode of test case in a suite
		@BeforeTest
		public void checkTestSkip(){
			
			if(!TestUtil.isTestCaseRunnable(suite_search_xls,this.getClass().getSimpleName())){
				APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
				throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
			}
			runmodes=TestUtil.getDataSetRunmodes(suite_search_xls, this.getClass().getSimpleName());
		}
	
	
	@Test(dataProvider="getTestData")
	public void testcaseA2(
			String brand,
			String priceRange
			
			) throws InterruptedException{
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		APP_LOGS.debug(" Executing TestCase_A2");
		//APP_LOGS.debug(col1 +" -- "+col2 +" -- "+col3 );	
		
		//String brand="HP"; // parameterize
		
		openBrowser();
		selenium.open("/");
		
		selenium.click("//*[@id='fk-header-tab-computer']/div[1]/a/div/div[1]/div");
		selenium.waitForPageToLoad("30000");
		selenium.click("//*[@id='fk-categories-list-id']/ul/li[2]/a");
		selenium.waitForPageToLoad("30000");
		selenium.select("//*[@id='brand']", "label="+brand);
		selenium.select("//*[@id='priceBand']", "label="+priceRange);
		//*[@id='results-data']/div/div/div[1]/div/div[1]/div/a[2]
		//*[@id='results-data']/div/div/div[1]/div/div[2]/div/a[2]
		//*[@id='results-data']/div/div/div[1]/div/div[3]/div/a[2]
		String start="//*[@id='results-data']/div/div/div[1]/div/div[";
		String end="]/div/a[2]";
		Thread.sleep(2000L);
		//Below Rs.25000
		//Rs.25000 - Rs.35000
		//Rs.35000 - Rs.45000
		//Rs.45000 - Rs.60000
		//Above Rs.60000
		//*[@id='results-data']/div/div/div[1]/div/div[1]/div/div[2]/span
		//*[@id='results-data']/div/div/div[1]/div/div[2]/div/div[2]/span
		
		String start_price="//*[@id='results-data']/div/div/div[1]/div/div[";
		String end_price="]/div/div[2]/span";
		int index=1;
		
		while(selenium.isElementPresent(start+index+end)){
			// execute
			String text = selenium.getText(start+index+end);
			System.out.println(text);
			if(text.startsWith(brand)){
				System.out.println("Pass");
			}else{
				System.out.println("Fail");
			}
			
			String p=selenium.getText(start_price + index +end_price);
			System.out.println(p);
			String[] temp = p.split(" ");
			System.out.println(temp[1]); // price in string
			int price = Integer.parseInt(temp[1]);
			String currentValInDropList=selenium.getSelectedLabel("//*[@id='priceBand']");
			if(currentValInDropList.equals("Below Rs.25000") && price>25000){
				fail=true;
				reportFailure("Price is below above 25000");
				
			}else if(currentValInDropList.equals("Rs.25000 - Rs.35000") && (price<25000 || price>35000)){
				fail=true;
				reportFailure("Price is not between 25000 and 35000");
			}else if(currentValInDropList.equals("Rs.35000 - Rs.45000") && (price<35000 || price>45000)){
				System.out.println("FAIL");
			}else if(currentValInDropList.equals("Rs.45000 - Rs.60000") && (price<45000 || price>60000)){
				System.out.println("FAIL");
			}else if(currentValInDropList.equals("Above Rs.60000") && price>65000 ){
				System.out.println("FAIL");
			}else{
				System.out.println("PASS");
			}
			
			index++;
		}
		
	
	
	}
	
	
	
	
	
	
	
	
	
	@DataProvider
	public Object[][] getTestData(){
		return TestUtil.getData(suite_search_xls, this.getClass().getSimpleName()) ;
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
	
	
	
	
	
}

