package com.qtpselenium.framework.suiteA;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.Keywords;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class PortFolioTest {
	Xls_Reader xls = new Xls_Reader(Constants.SUITEA_XLS_PATH);

	
	@Test(priority=1,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void createPortFolioTest(Hashtable<String,String> data){
		String testName ="createPortFolioTest";
		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		// check the runmodes
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		//Keywords app = new Keywords();
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);
	}
	
	@Test(priority=2,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void renamePortFolioTest(Hashtable<String,String> data){
		String testName ="renamePortFolioTest";
		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

	}
	
	@Test(priority=3,dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteA")
	public void deletePortFolioTest(Hashtable<String,String> data){
		String testName ="deletePortFolioTest";
		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		Utility.validateTestExecution(testName,"SUITEA",data.get(Constants.RUNMODE_COL),xls);
		
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

	}


}
