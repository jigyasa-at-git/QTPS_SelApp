package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SendMailTest {
	// to
	// subject
	// mail body
	
	@Test(dataProvider="getData")
	public void testMailSending(String to , Integer sub, String msg){
		System.out.println(to +" --- " + sub + "  ---  " + msg);
	}
	
	@DataProvider
	public Object[][] getData(){
		
		// Selenium framework - read the data from xls file and put it in Object array
		// rows - number of time test has to be repeated
		// cols - number of parameters in test data
		Object[][] data = new Object[2][3];
		// 1st row
		data[0][0] = "xyz@gmail.com";
		data[0][1] = 123;
		data[0][2]  = "howzz life";
		
		// 2nd row 
		data[1][0] = "abc@gmail.com";
		data[1][1] = 444;
		data[1][2]  = "life is good";
		
		return data;		
	}

}
