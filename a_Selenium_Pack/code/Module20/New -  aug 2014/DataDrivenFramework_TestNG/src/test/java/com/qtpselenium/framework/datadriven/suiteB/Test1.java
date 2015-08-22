package com.qtpselenium.framework.datadriven.suiteB;

import java.util.Hashtable;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;
import com.qtpselenium.framework.datadriven.util.Utility;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class Test1 extends TestBase{
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteBDataProvider")
	public void test1(Hashtable<String,String> table){
		/*
		Xls_Reader xls = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\Suite.xlsx");
		System.out.println(Utility.isSuiteRunnable("SuiteA", xls));
		System.out.println(Utility.isSuiteRunnable("SuiteB", xls));

		System.out.println(Utility.isSuiteRunnable("SuiteC", xls));
		Xls_Reader xls1 = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\SuiteA.xlsx");

		System.out.println(Utility.isTestCaseRunnable("Test1", xls1));
		*/
		validateRunmodes("Test1", Constants.SECOND_SUITE, table.get("Runmode"));
	}
	
	

}
