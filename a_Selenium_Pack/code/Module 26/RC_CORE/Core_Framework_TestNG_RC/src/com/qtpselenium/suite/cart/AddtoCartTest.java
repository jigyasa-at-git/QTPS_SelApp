package com.qtpselenium.suite.cart;

import java.util.Random;

import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;


public class AddtoCartTest extends TestSuiteBase{
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	String runmodes[]=null;
	static int count=-1;
	// Runmode of test case in a suite
			@BeforeTest
			public void checkTestSkip(){
				
				if(!TestUtil.isTestCaseRunnable(suite_cart_xls,this.getClass().getSimpleName())){
					APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
					throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
				}
	runmodes=TestUtil.getDataSetRunmodes(suite_cart_xls, this.getClass().getSimpleName());	
			}
	@Test(dataProvider="getTestData")
	public void testcaseA(				
					String category
						  ) throws InterruptedException{
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		APP_LOGS.debug(" Executing TestCase_B1");
		//APP_LOGS.debug(col1 +" -- "+col2 +" -- "+col3 +" -- "+col4);
		openBrowser();
		selectRandomItem(OR.getProperty(category+"_category"),
				OR.getProperty(category+"_start"),
				OR.getProperty(category+"_mid"),
				OR.getProperty(category+"_end"),
				Integer.parseInt(OR.getProperty(category+"_cat_start")),
				1);
		
		selenium.click(OR.getProperty("add_to_cart_button")); // add to cart
		Thread.sleep(2000L);
		
		
	}
	

	@DataProvider
	public Object[][] getTestData(){
		return TestUtil.getData(suite_cart_xls, this.getClass().getSimpleName()) ;
	}
	@AfterMethod
	public void reportDataSetResult(){
		if(skip)
			TestUtil.reportDataSetResult(suite_cart_xls, this.getClass().getSimpleName(), count+2, "SKIP");
		else if(fail){
			isTestPass=false;
			TestUtil.reportDataSetResult(suite_cart_xls, this.getClass().getSimpleName(), count+2, "FAIL");
		}
		else
			TestUtil.reportDataSetResult(suite_cart_xls, this.getClass().getSimpleName(), count+2, "PASS");
		
		skip=false;
		fail=false;
		

	}
	
	@AfterTest
	public void reportTestResult(){
		if(isTestPass)
			TestUtil.reportDataSetResult(suite_cart_xls, "Test Cases", TestUtil.getRowNum(suite_search_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_cart_xls, "Test Cases", TestUtil.getRowNum(suite_search_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	
	public static void selectRandomItem(String productline,// xpath for product
			String start,// starting part
			String mid, //middle part
			String end, // end part
			int cat, // category ID
			int item){ // item id
		
		selenium.open("/");
		selenium.click(productline);
		selenium.waitForPageToLoad("30000");
		
		// find total books
		// random number < total number of books
		// select the book which has ID corres to randum number
		//String start="//*[@id='fk-mainbody-id']/div/div/div[3]/div[2]/div/div[";
		//String mid="]/div/div[2]/div/div[";
		//String end="]/div/a[2]";
		int total_items=0;
		
		int category=cat;
		int item_id=item;
		System.out.println("*************ALL ITEMS************************");
		while(selenium.isElementPresent(start+category+mid+item_id+end)){
			while(selenium.isElementPresent(start+category+mid+item_id+end)){
			   // System.out.println(selenium.getText(start+category+mid+item_id+end));
				item_id++;
				total_items++;
			}
			category++;
			item_id=1;
		}
		
		System.out.println("Total Items are -- "+total_items );
		
		
		
		// Generate random number
		Random number = new Random();
		int n = number.nextInt(24);
		
		if(n==0)
			n= number.nextInt(24);
		
		System.out.println("Randomly generated number is -- "+ n);
		
		
		// Select the book
		System.out.println("**************SELECTING BOOK********************");
		category=cat;
		item_id=item;
		int index=1;
		boolean found=false;
		
		while(selenium.isElementPresent(start+category+mid+item_id+end)){
			while(selenium.isElementPresent(start+category+mid+item_id+end)){
				String item_name=selenium.getText(start+category+mid+item_id+end);
			   // System.out.println(item_name);
			    if(index == n){
			    	// found the book
			    	selenium.click(start+category+mid+item_id+end);
			    	selenium.waitForPageToLoad("30000");
			    	found=true;
			    	break;
			    }
			    	
			    if(found)
			    	break;
			    
				item_id++;
				index++;
			}
			category++;
			item_id=1;
		}
	
	
	
	
	
	
	}
	
	
	
}
