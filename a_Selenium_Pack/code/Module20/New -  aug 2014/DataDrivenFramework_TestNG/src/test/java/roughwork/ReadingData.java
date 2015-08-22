package roughwork;

import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class ReadingData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Xls_Reader xls = new Xls_Reader("D:\\Ashish\\Frameworks\\Rediff_Framework\\SuiteA.xlsx");
		String testName="test1";
		int rows = xls.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows - "+ rows);
		
		// row number for testCase
		int testCaseRowNum=1;
		for(testCaseRowNum=1;testCaseRowNum<=rows;testCaseRowNum++){
			String testNameXls = xls.getCellData(Constants.DATA_SHEET, 0, testCaseRowNum);
			if(testNameXls.equalsIgnoreCase(testName))
				break;
		}
		System.out.println("Test Starts from row Number - "+ testCaseRowNum);
		int dataStartRowNum=testCaseRowNum+2;
		int colStartRowNum=testCaseRowNum+1;
		
		// rows of data
		int testRows=1;
		while(!xls.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum+testRows).equals("")){
			testRows++;
		}
		System.out.println("Total rows of data are - "+testRows);
		
		// cols of data
		int testCols=0;
		while(!xls.getCellData(Constants.DATA_SHEET,testCols,colStartRowNum).equals("")){
			testCols++;
		}

		System.out.println("Total cols "+testCols );
		
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			for(int cNum=0;cNum<testCols;cNum++){
				System.out.println(xls.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
			
		}
		
		
		


	}

}
