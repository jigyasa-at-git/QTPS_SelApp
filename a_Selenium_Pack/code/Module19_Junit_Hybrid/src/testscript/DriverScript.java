package testscript;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import reports.ReportUtil;
import util.TestUtil;

import datatable.Xls_Reader;

public class DriverScript {
	
	public static Properties CONFIG;
	public static Properties OR;
	public static Properties APPTEXT;
	public static Xls_Reader controller;
	public static Xls_Reader testData;

	public static String currentTest;
	public static String keyword;
	public static WebDriver wbdv=null;
	public static EventFiringWebDriver driver=null;
	public static String object;
	public static String currentTSID;
	public static String stepDescription;
	public static String proceedOnFail;
	public static String testStatus;
	// temp
	public static String data_column_name;
	public static int  testRepeat;
	public static Logger APPICATION_LOGS = Logger.getLogger("devpinoyLogger");

	
	
	
	@BeforeClass
	public static void startTesting(){
		ReportUtil.startTesting("C://keyword_driven_rep//index.html", 
                TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), 
                "Prod",
                "1.1.3");
		
	}
	
	@Before
	public void initialize() throws IOException{
		// load the property fIles
		// load the config prop
		CONFIG = new Properties();
		FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\config.properties");
		CONFIG.load(fs);
		
		// LOAD OR
		OR = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\OR.properties");
		OR.load(fs);
		// app text prop load
		APPTEXT = new Properties();
		fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\config\\app_text.properties");
		APPTEXT.load(fs);
		// intialize datatable
		controller= new Xls_Reader(System.getProperty("user.dir")+"\\src\\config\\Controller.xlsx");
		testData  =  new Xls_Reader(System.getProperty("user.dir")+"\\src\\config\\TestData.xlsx");
		
	}
	
	@Test
	public void testApp() {
		String startTime=null;
		ReportUtil.startSuite("Suite 1");
		for(int tcid=2 ; tcid<=controller.getRowCount("Suite1");tcid++){
			currentTest = controller.getCellData("Suite1", "TCID", tcid);
			// initilize start time of test
			if(controller.getCellData("Suite1", "Runmode", tcid).equals("Y")){
				// execute the keywords
				// loop again - rows in test data
				int totalSets=testData.getRowCount(currentTest+"1");; // holds total rows in test data sheet. IF sheet does not exist then 2 by default
				if(totalSets<=1){
					totalSets=2; // run atleast once
				}
					
				for( testRepeat=2; testRepeat<=totalSets;testRepeat++){	
					startTime=TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa");

				APPICATION_LOGS.debug("Executing the test "+ currentTest);
				// implement keyword . Reflection API
				System.out.println(controller.getRowCount(currentTest));
				for(int tsid=2;tsid<=controller.getRowCount(currentTest);tsid++){
					// values from xls
					keyword=controller.getCellData(currentTest, "Keyword", tsid);
					object=controller.getCellData(currentTest, "Object", tsid);
					currentTSID=controller.getCellData(currentTest, "TSID", tsid);
					stepDescription=controller.getCellData(currentTest, "Decription", tsid);
					proceedOnFail=controller.getCellData(currentTest, "ProceedOnFail", tsid);
					data_column_name=controller.getCellData(currentTest, "Data_Column_Name", tsid);
					//APPICATION_LOGS.debug(keyword);
					try{
					Method method= Keywords.class.getMethod(keyword);
					String result = (String)method.invoke(method);
					APPICATION_LOGS.debug("***Result of execution -- "+result);
					// take screenshot - every keyword
					String fileName="Suite1_TC"+(tcid-1)+"_TS"+tsid+"_"+keyword+testRepeat+".jpg";
					TestUtil.takeScreenShot(CONFIG.getProperty("screenshotPath")+fileName);
					ReportUtil.addKeyword(stepDescription, keyword, result, fileName);

						if(result.startsWith("Fail")){
							testStatus=result;
							// take screenshot - only on error
							//String fileName="Suite1_TC"+tcid+"_TS"+tsid+"_"+keyword+testRepeat+".jpg";
							//TestUtil.takeScreenShot(CONFIG.getProperty("screenshotPath")+fileName);
							//ReportUtil.addKeyword(stepDescription, keyword, result, fileName);

							if(proceedOnFail.equalsIgnoreCase("N")){
								break;
							}
						
						}
					
					}catch(Throwable t){
						APPICATION_LOGS.debug("Error came");
					}
					
					
				}// keywords
				// report pass or fail
				if(testStatus == null){
					testStatus="Pass";
				}
				APPICATION_LOGS.debug("***********************************"+currentTest+" --- " +testStatus);
				ReportUtil.addTestCase(currentTest, 
										startTime, 
										TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
										testStatus );
				}// test data

				
			}else{
				APPICATION_LOGS.debug("Skipping the test "+ currentTest);
				testStatus="Skip";
				// report skipped
				APPICATION_LOGS.debug("***********************************"+currentTest+" --- " +testStatus);
				ReportUtil.addTestCase(currentTest, 
										TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"), 
										TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"),
										testStatus );
				
			}
			
			testStatus=null;
			
		}
		ReportUtil.endSuite();
	}
	
	@AfterClass
	public static void endScript(){
		
		ReportUtil.updateEndTime(TestUtil.now("dd.MMMMM.yyyy hh.mm.ss aaa"));
			
		

	}

}
