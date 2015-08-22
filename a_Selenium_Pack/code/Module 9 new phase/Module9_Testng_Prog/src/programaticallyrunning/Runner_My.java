package programaticallyrunning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner_My {
	public static void main(String args[]) {
		 
		Runner_My sampTest5 = new Runner_My();
		 
		//This Map can hold your testng Parameters.
		 Map<String,String> testngParams = new HashMap<String,String> ();
		 
		sampTest5.runTestNGTest(testngParams);
		 
		}
	
	public void runTestNGTest(Map<String,String> testngParams) {
		
		TestNG myTestNG = new TestNG();
		XmlSuite mySuite = new XmlSuite();
		 mySuite.setName("ASQA Sample Suite");
		 XmlTest myTest = new XmlTest(mySuite);
		 myTest.setName("ASQA Sample Test1");

		 
		 List<XmlClass> myClasses = new ArrayList<XmlClass> ();
		 myClasses.add(new XmlClass("programaticallyrunningX.MyClass",false));
		 

		//Assign that to the XmlTest Object created earlier.
	     myTest.setXmlClasses(myClasses);
		 
		//Create a list of XmlTests and add the Xmltest you created earlier to it.
		 List<XmlTest> myTests = new ArrayList<XmlTest>();
		 myTests.add(myTest);
		 
		//add the list of tests to your Suite.
		 mySuite.setTests(myTests);
		 
		//Add the suite to the list of suites.
		 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		 mySuites.add(mySuite);
		 
		//Set the list of Suites to the testNG object you created earlier.
		 myTestNG.setXmlSuites(mySuites);
		 
		//invoke run() - this will run your class.
		myTestNG.run();
		 
	}
		 
}
