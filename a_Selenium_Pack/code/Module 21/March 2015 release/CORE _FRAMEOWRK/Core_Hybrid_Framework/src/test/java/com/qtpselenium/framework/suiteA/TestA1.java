package com.qtpselenium.framework.suiteA;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.Keywords;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class TestA1 {
	
	
	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void testA1(Hashtable<String,String> data){
		Logger log = Utility.initLogs("testA1 - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing testA1 "+ data.toString());
		// check the runmodes
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution("TestA1","SUITEA",data.get(Constants.RUNMODE_COL),xls);
		//Keywords app = new Keywords();
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords("testA1",xls,data);
		log.debug("Ending test A1");
	}
	
	/*
	@DataProvider
	public Object[][] getData(){
		String testCase="TestA1";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		return Utility.getData(testCase,xls);
		
	}*/

}
