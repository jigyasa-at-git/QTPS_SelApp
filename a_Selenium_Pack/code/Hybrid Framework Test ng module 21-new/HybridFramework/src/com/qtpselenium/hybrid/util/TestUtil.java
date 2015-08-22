package com.qtpselenium.hybrid.util;

import java.util.Hashtable;

public class TestUtil {
	// true - Y
	// false - N
	public static boolean isTestCaseExecutable(String testCase, Xls_Reader xls){
		
		for(int rNum=2;rNum<=xls.getRowCount("Test Cases");rNum++){
			if(testCase.equals(xls.getCellData("Test Cases", "TCID", rNum))){
				// check runmode
				if(xls.getCellData("Test Cases", "Runmode", rNum).equals("Y"))
					return true;
				else
					return false;
			}
				
		}
		
		return false;
		
	}
	
	
	
	public static Object[][] getData(String testCase,Xls_Reader xls){
		System.out.println("*************");
		// find the test in xls
		// find number of cols in test
		// number of rows in test
		// put the data in hashtable and put hashtable in object array
		// return object array
		
		int testCaseStartRowNum=0;
		for(int rNum=1;rNum<=xls.getRowCount("Test Data");rNum++){
			if(testCase.equals(xls.getCellData("Test Data", 0, rNum))){
				testCaseStartRowNum = rNum;
				break;
			}
		}
		System.out.println("Test Starts from row -> "+ testCaseStartRowNum);
		
		
		// total cols
		int colStartRowNum=testCaseStartRowNum+1;
		int cols=0;
		while(!xls.getCellData("Test Data", cols, colStartRowNum).equals("")){
			cols++;
		}
		System.out.println("Total cols in test -> "+ cols);
		

		// rows
		int rowStartRowNum=testCaseStartRowNum+2;
		int rows=0;
		while(!xls.getCellData("Test Data", 0, (rowStartRowNum+rows)).equals("")){
			rows++;
		}
		System.out.println("Total rows in test -> "+ rows);
		Object[][] data = new Object[rows][1];
		Hashtable<String,String> table=null;
		
		// print the test data
		for(int rNum=rowStartRowNum;rNum<(rows+rowStartRowNum);rNum++){
		table=new Hashtable<String,String>();
			for(int cNum=0;cNum<cols;cNum++){
				table.put(xls.getCellData("Test Data", cNum, colStartRowNum),xls.getCellData("Test Data", cNum, rNum));
				//System.out.print(xls.getCellData("Test Data", cNum, rNum)+" - ");
			}
			data[rNum-rowStartRowNum][0]=table;
			//System.out.println();
		}

		return data;// dummy
		
		
		
		
	}

}
