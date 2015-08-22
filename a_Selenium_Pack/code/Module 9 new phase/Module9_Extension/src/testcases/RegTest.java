package testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegTest {
	
	@Test(dataProviderClass=Data_Provider.class,dataProvider="regTestDataProvider")
	public void doRegister(String username,
			String password,String email){
		
	}
	
	

}
