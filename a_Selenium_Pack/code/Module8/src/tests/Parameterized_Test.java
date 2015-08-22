package tests;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
// step 1
@RunWith(Parameterized.class)
public class Parameterized_Test {
	// step 2
	// global vars
	String bankName;
	int actNum;
	
	// step 3
	// constructor
	public Parameterized_Test(String bankName , int actNum){
		this.bankName=bankName;
		this.actNum=actNum;
	}
	
	
	@Test
	public void checkBalanceTest(){
		System.out.println("Executing the test with - "+bankName + " -- "+ actNum );
		// selenium code
		// bank name
		// act number
	}
	
	// step 4
	@Parameters
	public static Collection<Object[]> getData(){
		
		Object data[][] = new Object[2][2];
		// first row
		data[0][0]="HSBC";
		data[0][1]=1234;
		
		// 2nd row
		data[1][0]="City";
		data[1][1]=123455;
		
		return Arrays.asList(data);
	}
	

}
