package com.qtpselenium.framework.suiteA;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.Keywords;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class PortFolioTest {

	
	@Test(priority=1,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void createPortFolioTest(Hashtable<String,String> data){
		String testName ="createPortFolioTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);

		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		// check the runmodes
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		//Keywords app = new Keywords();
		Keywords app = Keywords.getInstance("PortFolioTest_"+data.get(Constants.ITERATION_COL));
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);
	}
	
	@Test(priority=2,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void renamePortFolioTest(Hashtable<String,String> data){
		String testName ="renamePortFolioTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);

		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		
		Keywords app = Keywords.getInstance("PortFolioTest_"+data.get(Constants.ITERATION_COL));

		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

	}
	
	@Test(priority=3,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void deletePortFolioTest(Hashtable<String,String> data){
		String testName ="deletePortFolioTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);

		
		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		
		Keywords app = Keywords.getInstance("PortFolioTest_"+data.get(Constants.ITERATION_COL));
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

	}
	
	


}
