package com.qtpselenium.suite.shop;


import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class AddProductTest extends TestSuiteBase{
	String runmodes[]=null;
	static boolean fail=false;
	static boolean skip=false;
	static boolean isTestPass=true;
	static int count=-1;
	// Runmode of test case in a suite
		@BeforeTest
		public void checkTestSkip(){
			
			if(!TestUtil.isTestCaseRunnable(suite_shop_xls,this.getClass().getSimpleName())){
				APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
				throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
			}
			runmodes=TestUtil.getDataSetRunmodes(suite_shop_xls, this.getClass().getSimpleName());
		}
	
	
	@Test(dataProvider="getTestData")
	public void addProductToBasket(
			String mobileName,
			String color,
			String memory,
			String engraving,
			String quantity
			) throws InterruptedException, IOException{
		count++;
		if(!runmodes[count].equalsIgnoreCase("Y")){
			throw new SkipException("Runmode for test set data set to no "+count);
		}
		APP_LOGS.debug(" Executing TestCase_A2");
		APP_LOGS.debug(mobileName +" -- "+color +" -- "+memory );
		sessionData.put("mobile_"+count, mobileName);
		
		// webdriver
		openBrowser();
		driver.get(CONFIG.getProperty("testSiteName"));
		if(!checkElementPresence("shopLink")){
			// screenshot
			capturescreenshot(this.getClass().getSimpleName()+"_"+count);
			fail=true;
			// quit
			return;
		}
		
		getObject("shopLink").click();
		getObject("mobile_phone_link").click();
		driver.findElement(By.linkText(mobileName)).click();
		getObject("mobile_color_list").sendKeys(color);
		getObject("mobile_memory_list").sendKeys(memory);
		getObject("mobline_phone_engraving").sendKeys(engraving);
		//driver.findElement(By.xpath("")).sendKeys(engraving);
		getObject("mobile_phone_quantity").clear();
		//
		int q= (int)Double.parseDouble(quantity);
	    getObject("mobile_phone_quantity").sendKeys(String.valueOf(q));
		
		// add to cart
		//getObject("add_to_cart_button").click();
		driver.findElement(By.className("addtocart-button")).click();
		Thread.sleep(3000L);
		String x=driver.findElement(By.className("shop_info")).getText();
		System.out.println(x);
		Assert.assertEquals("Info: The product was added to your cart.", x);
        //compareStrings("","");
		//Assert.assertEquals("", "");
		//compareTitle(expectedVal)

//
		
	
	
	
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
	
	
	
	@DataProvider
	public Object[][] getTestData(){
		return TestUtil.getData(suite_shop_xls, this.getClass().getSimpleName()) ;
	}
}
