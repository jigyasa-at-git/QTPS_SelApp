package com.qtpselenium.framework.suiteA;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class TestA3 {

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void testA3(Hashtable<String,String> data){
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution("TestA3","SUITEA",data.get(Constants.RUNMODE_COL),xls);
		
	}
}
