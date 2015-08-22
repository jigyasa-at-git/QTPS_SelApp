package com.qtpselenium.framework.datadriven.suiteB;

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
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteBDataProvider")
	public void test2(Hashtable<String,String> table){
		validateRunmodes("Test2", Constants.SECOND_SUITE, table.get(Constants.RUNMODE_COL));
		
	}
}
