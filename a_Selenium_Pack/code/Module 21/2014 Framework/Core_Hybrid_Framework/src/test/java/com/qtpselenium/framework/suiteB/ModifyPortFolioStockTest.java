package com.qtpselenium.framework.suiteB;

import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import com.qtpselenium.framework.util.Constants;
import com.qtpselenium.framework.util.Keywords;
import com.qtpselenium.framework.util.TestCaseDataProvider;
import com.qtpselenium.framework.util.Utility;
import com.qtpselenium.framework.util.Xls_Reader;

public class ModifyPortFolioStockTest {

	@Test(dataProviderClass=TestCaseDataProvider.class,dataProvider="getDataForSuiteB")
	public void modifyPortFolioStockTest(Hashtable<String,String> data){
		String testName ="modifyPortFolioStockTest";
		Xls_Reader xls = new Xls_Reader(Constants.SUITEB_XLS_PATH);
		Utility.validateTestExecution(testName,"SUITEB",data.get(Constants.RUNMODE_COL),xls);


		Logger log = Utility.initLogs(testName+" - "+data.get(Constants.ITERATION_COL));
		log.debug("Starting "+testName);

		log.debug("Executing  "+ testName+" - "+data.toString());
		
		Keywords app = Keywords.getInstance("ModifyPortFolioStockTest_"+data.get(Constants.ITERATION_COL));

		app.setLogger(log);

		app.executeKeywords(testName,xls,data);
		log.debug("Ending "+testName);

	}
}
