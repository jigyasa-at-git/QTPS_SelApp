package com.qtpselenium.framework.util;

public class Constants {
	// paths
	public static final String SUITEA_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\SuiteA.xlsx";
	public static final String SUITEB_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\SuiteB.xlsx";
	public static final String TESTSUITE_XLS_PATH = System.getProperty("user.dir")+"\\executioninfo\\input-data\\TestSuite.xlsx";
	public static final String PROPERTIES_FILE_PATH = System.getProperty("user.dir")+"//src//test//resources//project.properties";
	
	
	// sheet names
	public static final String TESTSUITE_SHEET = "TestSuite";
	public static final String TestData_SHEET = "TestData";
	public static final String TESTCASES_SHEET = "TestCases";
	public static final String KEYWORDS_SHEET = "Keywords";


	// col names
	public static final String SUITENAME_COL = "SuiteName";
	public static final String RUNMODE_COL = "Runmode";
	public static final String TESTCASENAME_COL = "TestCaseName";
	public static final Object BROWSER_COL = "Browser";;

	
	
	// runmodes
	public static final String RUNMODE_YES="Y";
	public static final String RUNMODE_NO="N";
	public static final Object ITERATION_COL = "Iteration";
	
	
	public static final String PASS = "PASS";
	public static final String MOZILLA = "mozilla";
	public static final String CHROME = "chrome";
	
	//error message
	public static final String OPENBROWSER_ERROR = "ERROR - FAILED TO OPEN BROWSER - ";
	public static final String NAVIGATE_ERROR = "ERROR - FAILING TO NAVIGATE - ";
	public static final String LOCATOR_ERROR = "ERROR - INVALID LOCATOR - ";
	public static final String FIND_ELEMENT_ERROR = "ERROR - UNABLE TO FIND ELEMET -  ";

	// failure
	public static final String ELEMENT_NOT_FOUND_FAILURE = "FAIL - ELEMENT NOT FOUND - ";
	public static final String TITLE_NOT_MATCHES_FAILURE = "FAIL - Titles do not match. Expected -  ";
	public static final String DEFAULT_LOGIN_FAILURE = "FAIL - Not able to Login with Deault Username/password ";

	

}
