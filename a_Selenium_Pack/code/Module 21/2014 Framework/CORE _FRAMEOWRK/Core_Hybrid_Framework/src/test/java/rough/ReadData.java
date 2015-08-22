package rough;

import java.util.Hashtable;

import com.qtpselenium.framework.util.Xls_Reader;

public class ReadData {

	public static void main(String[] args) {
		String testCase="TestA2";
		Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"\\executioninfo\\input-data\\SuiteA.xlsx");
		
		// find the rowNum for the test
		int testCaseRowNum=1;
		while(!xls.getCellData("TestData", 0, testCaseRowNum).trim().toLowerCase().equals(testCase.toLowerCase())){
			testCaseRowNum++;
		}
		System.out.println(testCaseRowNum);
	
		// row for Column and Data
		int colStartRowNum=testCaseRowNum+1;
		int dataStartRowNum=testCaseRowNum+2;
		int rows=0;
		// total rows of data in the test
		while(!xls.getCellData("TestData", 0, dataStartRowNum+rows).trim().equals("")){
			rows++;
		}
		System.out.println("Total rows "+ rows);

		//total cols
		int cols=0;
		while(!xls.getCellData("TestData", cols, colStartRowNum).trim().equals("")){
			cols++;
		}
		System.out.println("Total cols "+ cols);
		// print the data
		Object testData[][] = new Object[rows][1];
		int i =0;
		for(int rNum=dataStartRowNum;rNum<dataStartRowNum+rows;rNum++){
			Hashtable<String,String> table = new Hashtable<String,String> ();
			
			for(int cNum=0;cNum<cols;cNum++){
			String data = xls.getCellData("TestData", cNum, rNum);
			String colName = xls.getCellData("TestData", cNum, colStartRowNum);
			
		//	System.out.println(colName+" --- "+data);
			table.put(colName, data);
			}
			//put the hashtable in object Array
			testData[i][0]=table;
			i++;
			System.out.println("------------------------------------");
		}
	}

}
