package com.qtpselenium.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument.Config;

import com.qtpselenium.xls.read.Xls_Reader;

public class DriverScript {

	public static Logger APP_LOGS;
	//suite.xlsx
	public Xls_Reader suiteXLS;
	public int currentSuiteID;
	public String currentTestSuite;
	
	// current test suite
	public Xls_Reader currentTestSuiteXLS;
	public int currentTestCaseID;
	public String currentTestCaseName;
	public int currentTestStepID;
	public String currentKeyword;
	public int currentTestDataSetID;
	public Method method[];
	public Keywords keywords;
	public String data;
	public String object;
	public String keyword_execution_result;
	public ArrayList<String> resultSet;
	public Properties CONFIG=null;
	public Properties OR=null;

	public DriverScript() throws IOException{
		keywords = new Keywords();
		method = keywords.getClass().getMethods();
		// intitilaize properties
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"//src//com//qtpselenium//config//config.properties");
		CONFIG = new Properties();
		CONFIG.load(ip);
		
		ip = new FileInputStream(System.getProperty("user.dir")+"//src//com//qtpselenium//config//or.properties");
		OR = new Properties();
		OR.load(ip);
		
	}
	
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, IOException {
		DriverScript test = new DriverScript();
	
		
		
		test.start();
	}
	
	
	public void start() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		// initialize the app logs
		APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Hello");
		
		// 1) check the runmode of test Suite
		// 2) Runmode of the test case in test suite
	    // 3) Execute keywords of the test case serially
		// 4) Execute Keywords as many times as
		// number of data sets - set to Y
		APP_LOGS.debug("Intialize Suite xlsx");
		suiteXLS = new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//Suite.xlsx");
		
		
		for(currentSuiteID=2;currentSuiteID<=suiteXLS.getRowCount(Constants.TEST_SUITE_SHEET);currentSuiteID++){
		
			APP_LOGS.debug(suiteXLS.getCellData(Constants.TEST_SUITE_SHEET, Constants.Test_Suite_ID, currentSuiteID)+" -- "+  suiteXLS.getCellData("Test Suite", "Runmode", currentSuiteID));
			// test suite name = test suite xls file having tes cases
			currentTestSuite=suiteXLS.getCellData(Constants.TEST_SUITE_SHEET, Constants.Test_Suite_ID, currentSuiteID);
			if(suiteXLS.getCellData(Constants.TEST_SUITE_SHEET, Constants.RUNMODE, currentSuiteID).equals(Constants.RUNMODE_YES)){
				// execute the test cases in the suite
				APP_LOGS.debug("******Executing the Suite******"+suiteXLS.getCellData(Constants.TEST_SUITE_SHEET, Constants.Test_Suite_ID, currentSuiteID));
				currentTestSuiteXLS=new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//"+currentTestSuite+".xlsx");
				
				// iterate through all the test cases in the suite
				for(currentTestCaseID=2;currentTestCaseID<=currentTestSuiteXLS.getRowCount("Test Cases");currentTestCaseID++){				
					APP_LOGS.debug(currentTestSuiteXLS.getCellData(Constants.TEST_CASES_SHEET, Constants.TCID, currentTestCaseID)+" -- "+currentTestSuiteXLS.getCellData("Test Cases", "Runmode", currentTestCaseID));
					currentTestCaseName=currentTestSuiteXLS.getCellData(Constants.TEST_CASES_SHEET, Constants.TCID, currentTestCaseID);
										
					if(currentTestSuiteXLS.getCellData(Constants.TEST_CASES_SHEET, Constants.RUNMODE, currentTestCaseID).equals(Constants.RUNMODE_YES)){
						APP_LOGS.debug("Executing the test case -> "+currentTestCaseName);
					 if(currentTestSuiteXLS.isSheetExist(currentTestCaseName)){
					  	// RUN as many times as number of test data sets with runmode Y
					  for(currentTestDataSetID=2;currentTestDataSetID<=currentTestSuiteXLS.getRowCount(currentTestCaseName);currentTestDataSetID++)	
					  {
						resultSet= new ArrayList<String>();
						APP_LOGS.debug("Iteration number "+(currentTestDataSetID-1));
						// checking the runmode for the current data set
					   if(currentTestSuiteXLS.getCellData(currentTestCaseName, Constants.RUNMODE, currentTestDataSetID).equals(Constants.RUNMODE_YES)){
						
					    // iterating through all keywords	
						   executeKeywords(); // multiple sets of data
					   }
					   createXLSReport();
					  }
					 }else{
						// iterating through all keywords
						 resultSet= new ArrayList<String>(); //PATCH - Introduced later
						 executeKeywords();// no data with trhe test
						 createXLSReport();

					 }
					}
				}
			}

		}	
	}
	
	
	public void executeKeywords() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		
		// iterating through all keywords	
		for(currentTestStepID=2;currentTestStepID<=currentTestSuiteXLS.getRowCount(Constants.TEST_STEPS_SHEET);currentTestStepID++){
			
			// checking TCID
			if(currentTestCaseName.equals(currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET, Constants.TCID, currentTestStepID))){
				currentKeyword=currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET, Constants.KEYWORD, currentTestStepID);
				APP_LOGS.debug(currentKeyword);
				// code to execute the keywords as well
			    // reflection API
				
				for(int i=0;i<method.length;i++){
					//System.out.println(method[i].getName());
					
					if(method[i].getName().equals(currentKeyword)){
					// finallize the data and object -pass it to function
					// Data Col - XLS
						
					String dataCol = currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET, Constants.Data, currentTestStepID);	
					// config, OR, XLS
					if(dataCol.startsWith(Constants.CONFIG)){
						// data has to be read from config.prop
						String temp[] = dataCol.split(Constants.dataSeparator);
						String key=temp[1];
						data=CONFIG.getProperty(key);
					}else if(dataCol.startsWith(Constants.COL)){
						String temp[] = dataCol.split(Constants.dataSeparator);
						String colName=temp[1];
						
						data= currentTestSuiteXLS.getCellData(currentTestCaseName, colName, currentTestDataSetID);
					}else{
						data=OR.getProperty(dataCol);
					}
					
					// OBJECT
					object=currentTestSuiteXLS.getCellData(currentTestCaseName, Constants.OBJECT, currentTestStepID);
					
				    keyword_execution_result=(String)method[i].invoke(keywords); // pass on the object and data to all functions in Keywords.java
					APP_LOGS.debug(keyword_execution_result);
					resultSet.add(keyword_execution_result);
					// report the result
					}
				}
			}	
		}
	}
	
	
	
	
	public void createXLSReport(){
		
		String colName=Constants.RESULT +(currentTestDataSetID-1);
		boolean isColExist=false;
		
		for(int c=0;c<currentTestSuiteXLS.getColumnCount(Constants.TEST_STEPS_SHEET);c++){
			System.out.println(currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET,c , 2));
			if(currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET,c , 1).equals(colName)){
				isColExist=true;
				break;
			}
		}
		
		if(!isColExist)
			currentTestSuiteXLS.addColumn(Constants.TEST_STEPS_SHEET, colName);
		int index=0;
		for(int i=2;i<=currentTestSuiteXLS.getRowCount(Constants.TEST_STEPS_SHEET);i++){
			
			if(currentTestCaseName.equals(currentTestSuiteXLS.getCellData(Constants.TEST_STEPS_SHEET, Constants.TCID, i))){
				if(resultSet.size()==0)
					currentTestSuiteXLS.setCellData(Constants.TEST_STEPS_SHEET, colName, i, Constants.KEYWORD_SKIP);
				else	
					currentTestSuiteXLS.setCellData(Constants.TEST_STEPS_SHEET, colName, i, resultSet.get(index));
				index++;
			}
			
			
		}
		
		if(resultSet.size()==0){
			// skip
			currentTestSuiteXLS.setCellData(currentTestCaseName, Constants.RESULT, currentTestDataSetID, Constants.KEYWORD_SKIP);
			return;
		}else{
			for(int i=0;i<resultSet.size();i++){
				if(!resultSet.get(i).equals(Constants.KEYWORD_PASS)){
					currentTestSuiteXLS.setCellData(currentTestCaseName, Constants.RESULT, currentTestDataSetID, Constants.KEYWORD_FAIL);
					return;
				}
			}
		}
		currentTestSuiteXLS.setCellData(currentTestCaseName, Constants.RESULT, currentTestDataSetID, Constants.KEYWORD_PASS);
	//	if(!currentTestSuiteXLS.getCellData(currentTestCaseName, "Runmode",currentTestDataSetID).equals("Y")){}
		
	}
	
	
	
	
	

}
