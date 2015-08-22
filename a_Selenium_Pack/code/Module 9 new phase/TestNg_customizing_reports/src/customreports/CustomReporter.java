package customreports;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

public class CustomReporter implements IReporter{

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
			String outputDirectory) {
		
		System.out.println("***********INSIDE CUSTOM REPORTER**************");
		for(int suiteNum=0;suiteNum<suites.size();suiteNum++){
			ISuite currentTestSuite = suites.get(suiteNum);
			System.out.println("Test Suite Name -> "+ currentTestSuite.getName());
			//System.out.println(currentTestSuite.getResults());
			Map<String, ISuiteResult>  suiteResults = currentTestSuite.getResults();
			
			Set<String> suiteResultKeys = suiteResults.keySet();
			Iterator<String> suiteResultKeysIter= suiteResultKeys.iterator();
			
			while(suiteResultKeysIter.hasNext()){
				String testName = suiteResultKeysIter.next();
				System.out.println("Test Name -> "+testName);
				ISuiteResult testResult = suiteResults.get(testName);
				
				IResultMap failedTests = testResult.getTestContext().getFailedTests();
				IResultMap passedTests = testResult.getTestContext().getPassedTests();
				IResultMap skippedTests= testResult.getTestContext().getSkippedTests();
				ITestNGMethod[]  allTests = testResult.getTestContext().getAllTestMethods();
				System.out.println("Test Method Names ->");

				for(int testNum=0;testNum<allTests.length;testNum++){
					
					if(failedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println(allTests[testNum].getMethodName() +" -- FAILED");
						Collection<ITestNGMethod> allFailedMethods= failedTests.getAllMethods();
						Iterator<ITestNGMethod> allFailedMethodsIter = allFailedMethods.iterator();
						
						while(allFailedMethodsIter.hasNext()){
							ITestNGMethod meth = allFailedMethodsIter.next();
							if(allTests[testNum].getMethodName().equals(meth.getMethodName())){
								Set<ITestResult> failures = failedTests.getResults(meth);
								Iterator<ITestResult> failuresIter= failures.iterator();
								while(failuresIter.hasNext()){
									System.out.println("Reason = "+failuresIter.next().getThrowable().getMessage());
								}
							}
							
						}
						
						// reason
					}else if(passedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println(allTests[testNum].getMethodName() +" -- PASS");
					}else if(skippedTests.getAllMethods().contains(allTests[testNum])){
						System.out.println(allTests[testNum].getMethodName() +" -- SKIPPED");
						// reason
						Collection<ITestNGMethod> allSkippedMethods= skippedTests.getAllMethods();
						Iterator<ITestNGMethod> allSkippedMethodsIter = allSkippedMethods.iterator();
						
						while(allSkippedMethodsIter.hasNext()){
							ITestNGMethod meth = allSkippedMethodsIter.next();
							if(allTests[testNum].getMethodName().equals(meth.getMethodName())){
								Set<ITestResult> skips = skippedTests.getResults(meth);
								Iterator<ITestResult> skipIter= skips.iterator();
								while(skipIter.hasNext()){
									System.out.println("Reason = "+skipIter.next().getThrowable().getMessage());
								}
							}
							
						}
					}
					
					
					
				}
				
				
			}
			
			
		}
	}

}
