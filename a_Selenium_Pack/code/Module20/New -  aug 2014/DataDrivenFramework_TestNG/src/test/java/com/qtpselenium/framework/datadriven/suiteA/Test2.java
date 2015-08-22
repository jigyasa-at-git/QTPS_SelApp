package com.qtpselenium.framework.datadriven.suiteA;

import java.util.Hashtable;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;

public class Test2 extends TestBase{

	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public void test2(Hashtable<String,String> table){
		APPLICATION_LOG.debug("Executing test2");

		validateRunmodes("Test2", Constants.FIRST_SUITE, table.get(Constants.RUNMODE_COL));
		
	}
}
