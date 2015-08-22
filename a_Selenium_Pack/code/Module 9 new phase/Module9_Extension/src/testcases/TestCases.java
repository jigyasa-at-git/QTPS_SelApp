package testcases;

import org.testng.annotations.Test;

public class TestCases {
	// multiple tests -same data - same dataprovider
	// multiple tests - different data - same dataprovider

	@Test(priority=1,dataProviderClass=Data_Provider.class,dataProvider="sampleProvider")
	public void testA(String u,String p){
		
	}
	
	@Test(priority=2,dataProviderClass=Data_Provider.class,dataProvider="sampleProvider")
	public void testB(String u,String p,String email){
		
	}
	

}
