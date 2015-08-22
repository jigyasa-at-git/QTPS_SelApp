package com.qtpselenium.suite.productdisplay;

import org.testng.SkipException;
import org.testng.annotations.BeforeSuite;

import com.qtpselenium.base.TestBase;
import com.qtpselenium.util.TestUtil;

public class TestSuiteBase extends TestBase{

	// check if the suite ex has to be skiped
		@BeforeSuite
		public void checkSuiteSkip() throws Exception{
			initialize();
			APP_LOGS.debug("Checking Runmode of Product Display Suite");
			if(!TestUtil.isSuiteRunnable(suiteXls, "Product Display Suite")){
				APP_LOGS.debug("Skipped Product Display Suite as the runmode was set to NO");
				throw new SkipException("Runmode of Product Display Suite set to no. So Skipping all tests in Suite Product Display");
			}
			
		}
}
