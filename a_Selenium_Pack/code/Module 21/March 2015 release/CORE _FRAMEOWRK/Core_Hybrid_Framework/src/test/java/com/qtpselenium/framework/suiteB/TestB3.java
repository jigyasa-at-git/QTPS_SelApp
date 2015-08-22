package com.qtpselenium.framework.suiteB;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class TestB3 {

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteB")
	public void testB3(Hashtable<String,String> data){
		Xls_Reader xls = new Xls_Reader(Constants.SUITEB_XLS_PATH);
		Utility.validateTestExecution("TestB3","SUITEB",data.get(Constants.RUNMODE_COL),xls);
	}
}
