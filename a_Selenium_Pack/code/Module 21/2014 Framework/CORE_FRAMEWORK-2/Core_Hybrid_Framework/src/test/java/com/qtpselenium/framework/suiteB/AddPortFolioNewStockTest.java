package com.qtpselenium.framework.suiteB;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.Keywords;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class AddPortFolioNewStockTest {

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteB")
	public void addPortFolioNewStockTest(Hashtable<String,String> data){
		Xls_Reader xls = new Xls_Reader(Constants.SUITEB_XLS_PATH);

		String testName ="addPortFolioNewStockTest";
		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Executing  "+ testName+" - "+data.toString());
		Utility.validateTestExecution(testName,"SUITEB",data.get(Constants.RUNMODE_COL),xls);
		
		Keywords app = Keywords.getInstance();
		app.setLogger(log);
		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

		
	}
}
