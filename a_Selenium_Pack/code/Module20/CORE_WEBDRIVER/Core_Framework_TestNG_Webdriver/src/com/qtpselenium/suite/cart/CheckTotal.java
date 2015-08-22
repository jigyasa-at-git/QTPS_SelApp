package com.qtpselenium.suite.cart;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;


public class CheckTotal extends TestSuiteBase{
	String runmodes[]=null;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
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
	@Test
	public void testcaseCartTotal() throws InterruptedException{
		// test the runmode of current dataset
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		APP_LOGS.debug(" Executing testcaseCartTotal");
	    getObject("body").sendKeys(Keys.F5); // refresh page
		driver.findElement(By.linkText("Show Cart")).click();
	    
		//driver.findElement(By.linkText("Show Cart")).click();
		
		int numberOfmobiles=sessionData.size();
		double sum=0;
		for(int i=0;i<numberOfmobiles ;i++){
			System.out.println("***** "+sessionData.get("mobile_"+i));
			
			System.out.println(driver.findElement(By.xpath(OR.getProperty("price_start") + (i+2) + OR.getProperty("price_end"))).getText());
			String text=driver.findElement(By.xpath(OR.getProperty("price_start") + (i+2) + OR.getProperty("price_end"))).getText();
			String[] r =text.split("€");
			r[0]=r[0].replaceAll(" ", "");
			double price =Double.parseDouble(r[0]); //price
			System.out.println(price);
			sum=sum+price;
			// exercise
			
		}
		
		System.out.println("Sum is -- "+ sum);
		
		// assertion for checking total
		// capturescreenshot(this.getClass().getSimpleName()+"_"+count);

		
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
			TestUtil.reportDataSetResult(suite_cart_xls, "Test Cases", TestUtil.getRowNum(suite_cart_xls,this.getClass().getSimpleName()), "PASS");
		else
			TestUtil.reportDataSetResult(suite_cart_xls, "Test Cases", TestUtil.getRowNum(suite_cart_xls,this.getClass().getSimpleName()), "FAIL");
	
	}
	
	

}
