package com.qtpselenium.framework.util;

import java.util.Hashtable;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.testng.SkipException;

public class Utility {
	
	
	public static Object[][]  getData(String testCase,Xls_Reader xls){
		// find the rowNum for the test
				int testCaseRowNum=1;
				while(!xls.getCellData(Constants.TestData_SHEET, 0, testCaseRowNum).trim().toLowerCase().equals(testCase.toLowerCase())){
					testCaseRowNum++;
				}
				System.out.println(testCaseRowNum);
			
				// row for Column and Data
				int colStartRowNum=testCaseRowNum+1;
				int dataStartRowNum=testCaseRowNum+2;
				int rows=0;
				// total rows of data in the test
				while(!xls.getCellData(Constants.TestData_SHEET, 0, dataStartRowNum+rows).trim().equals("")){
					rows++;
				}
				//System.out.println("Total rows "+ rows);

				//total cols
				int cols=0;
				while(!xls.getCellData(Constants.TestData_SHEET, cols, colStartRowNum).trim().equals("")){
					cols++;
				}
				//System.out.println("Total cols "+ cols);
				// print the data
				Object[][] testData = new Object[rows][1];
				int i =0;
				for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
					Hashtable<String,String> table = new Hashtable<String,String> ();
					
					for(int cNum=0;cNum<cols;cNum++){
					String data = xls.getCellData(Constants.TestData_SHEET, cNum, rNum);
					String colName = xls.getCellData(Constants.TestData_SHEET, cNum, colStartRowNum);
					
				//	System.out.println(colName+" --- "+data);
					table.put(colName, data);
					}
					//put the hashtable in object Array
					testData[i][0]=table;
					i++;
				//	System.out.println("------------------------------------");
				}
				
				return testData;
			}

		public static boolean isSuiteRunnable(String suiteName) {
			Xls_Reader xls = new Xls_Reader(Constants.TESTSUITE_XLS_PATH);
			int rows = xls.getRowCount(Constants.TESTSUITE_SHEET);
			
			for(int rNum=2;rNum<=rows;rNum++){
				String testSuiteName=xls.getCellData(Constants.TESTSUITE_SHEET, Constants.SUITENAME_COL, rNum);
				
				if(testSuiteName.toLowerCase().equals(suiteName.toLowerCase())){
					String runMode=xls.getCellData(Constants.TESTSUITE_SHEET, Constants.RUNMODE_COL, rNum);
					if(runMode.equals(Constants.RUNMODE_YES))
						return true;
					else
						return false;
				}
				

			}
			
				return false;
		
		}

		public static boolean isTestCaseRunnable(String testCaseName,Xls_Reader xls) {
			int rows = xls.getRowCount(Constants.TESTCASES_SHEET);
			
			for(int rNum=2;rNum<=rows;rNum++){
				String testName=xls.getCellData(Constants.TESTCASES_SHEET, Constants.TESTCASENAME_COL, rNum);
				if(testName.toLowerCase().equals(testCaseName.toLowerCase())){
					String runMode=xls.getCellData(Constants.TESTCASES_SHEET, Constants.RUNMODE_COL, rNum);
					if(runMode.equals(Constants.RUNMODE_YES))
						return true;
					else
						return false;
				}
				
			}
			return false;

		}

		public static void validateTestExecution(String testCaseName,
												 String testSuiteName,
												 String dataRunmode,
												 Xls_Reader xls) {
			
			if(!Utility.isSuiteRunnable(testSuiteName)){
				throw new SkipException("Skipping the test "+testCaseName+" as runmode of suite was NO" );
			}
			
			if(!Utility.isTestCaseRunnable(testCaseName,xls)){
				throw new SkipException("Skipping the test "+testCaseName+" as runmode of test was NO" );
			}
			
			if(dataRunmode.equals(Constants.RUNMODE_NO)){
				throw new SkipException("Skipping the test "+testCaseName+" as runmode of data set was NO" );
			}
	
		}
		public static Logger initLogs(String append){
			FileAppender appender = new FileAppender();
			// configure the appender here, with file location, etc
			appender.setFile(System.getProperty("user.dir")+"\\executioninfo\\logs\\"+append+".log");
			appender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
			appender.setAppend(false);
			appender.activateOptions();

			
			Logger APPLICATION_LOG = Logger.getLogger(append);
			APPLICATION_LOG.setLevel(Level.DEBUG);
			APPLICATION_LOG.addAppender(appender);
			
			return APPLICATION_LOG;
		}
	

}
