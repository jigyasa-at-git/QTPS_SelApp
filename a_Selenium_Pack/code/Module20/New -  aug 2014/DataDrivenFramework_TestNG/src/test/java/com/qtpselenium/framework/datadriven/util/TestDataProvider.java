package com.qtpselenium.framework.datadriven.util;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import com.qtpselenium.framework.datadriven.TestBase;

public class TestDataProvider {
	
	@DataProvider(name="suiteADataProvider")
	public static Object[][] getDataSuiteA(Method m){
		TestBase.init();
		System.out.println(TestBase.prop.getProperty("xlsFileLocation"));
		Xls_Reader xls1 = new Xls_Reader(TestBase.prop.getProperty("xlsFileLocation")+Constants.FIRST_SUITE+".xlsx");

		return Utility.getData(m.getName(), xls1);
	}
	
	@DataProvider(name="suiteBDataProvider")
	public static Object[][] getDataSuiteB(Method m){
		TestBase.init();
		Xls_Reader xls1 = new Xls_Reader(TestBase.prop.getProperty("xlsFileLocation")+Constants.SECOND_SUITE+".xlsx");

		return Utility.getData(m.getName(), xls1);
	}
	

}
