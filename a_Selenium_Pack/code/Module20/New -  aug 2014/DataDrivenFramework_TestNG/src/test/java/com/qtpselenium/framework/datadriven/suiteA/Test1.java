package com.qtpselenium.framework.datadriven.suiteA;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.ErrorUtil;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;
import com.qtpselenium.framework.datadriven.util.Utility;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class Test1 extends TestBase{
	
	
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteADataProvider")
	public  void test1(Hashtable<String,String> table){
		APPLICATION_LOG.debug("Executing test1");
		/*
		Xls_Reader xls = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\Suite.xlsx");
		System.out.println(Utility.isSuiteRunnable("SuiteA", xls));
		System.out.println(Utility.isSuiteRunnable("SuiteB", xls));

		System.out.println(Utility.isSuiteRunnable("SuiteC", xls));
		Xls_Reader xls1 = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\SuiteA.xlsx");

		System.out.println(Utility.isTestCaseRunnable("Test1", xls1));
		*/
		validateRunmodes("Test1", Constants.FIRST_SUITE, table.get("Runmode"));
		
		try{
		Assert.assertEquals("A1", "B1");
		}catch(Throwable t){
			ErrorUtil.addVerificationFailure(t);
		}
		
		
		try{
			Assert.assertEquals("A2", "B2");
			}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
		}
		
		
		try{
			Assert.assertEquals("A3", "B3");
			}catch(Throwable t){
				ErrorUtil.addVerificationFailure(t);
		}
		
		
		Assert.assertEquals("A4", "B4");

		
	}
	
}
