package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

public class Runner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// A,B,C
		
		TestNG myTestNG = new TestNG();
		
		XmlSuite mySuite = new XmlSuite();
		mySuite.setName("suiteABC");
		
		
		XmlTest testA = new XmlTest(mySuite);
		testA.setName("test A");
		List<XmlClass> myClasses = new ArrayList<XmlClass> ();
		myClasses.add(new XmlClass("suiteABC.TestA"));
		testA.setXmlClasses(myClasses);
		
		
		XmlTest testB = new XmlTest(mySuite);
		testB.setName("test B");
		myClasses = new ArrayList<XmlClass> ();
		myClasses.add(new XmlClass("suiteABC.TestB"));
		testB.setXmlClasses(myClasses);
		
		
		XmlTest testC = new XmlTest(mySuite);
		testB.setName("test C");
		myClasses = new ArrayList<XmlClass> ();
		myClasses.add(new XmlClass("suiteABC.TestC"));
		testC.setXmlClasses(myClasses);
		
		
		 List<XmlTest> myTests = new ArrayList<XmlTest>();
		 myTests.add(testA);
		 myTests.add(testB);
		 myTests.add(testC);
		 
		 mySuite.setTests(myTests);
		 
		 List<XmlSuite> mySuites = new ArrayList<XmlSuite>();
		 mySuites.add(mySuite);
		
		 myTestNG.setXmlSuites(mySuites);
		 myTestNG.run();

		

	}

}
