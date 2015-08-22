package com.qtpselenium.suite.cart;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.util.TestUtil;

public class CheckTotalPrice extends TestSuiteBase{

	// Runmode of test case in a suite
			@BeforeTest
			public void checkTestSkip(){
				
				if(!TestUtil.isTestCaseRunnable(suite_cart_xls,this.getClass().getSimpleName())){
					APP_LOGS.debug("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//logs
					throw new SkipException("Skipping Test Case"+this.getClass().getSimpleName()+" as runmode set to NO");//reports
				}
			}
			
	@Test
	public void testcaseB2(){
		APP_LOGS.debug("TestCase_B2");
	}
}
