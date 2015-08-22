package test;

import com.qtpselenium.util.TestUtil;
import com.qtpselenium.util.Xls_Reader;

public class Test_MyData {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestUtil.getData("LoginTest", new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//TestCases.xlsx"));
		TestUtil.getData("ChangePicTest", new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//TestCases.xlsx"));
		TestUtil.getData("FindaFriendTest", new Xls_Reader(System.getProperty("user.dir")+"//src//com//qtpselenium//xls//TestCases.xlsx"));
	}
	

}
