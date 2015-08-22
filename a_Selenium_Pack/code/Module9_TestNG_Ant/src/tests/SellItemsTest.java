package tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SellItemsTest {
	
	@BeforeTest
	public void shouldWeSkip(){
		// check whether the user has logged in or not
		if(! isLoggedin()){
			throw new SkipException("Skipping because user not logged in");
		}
	}
	
	
	@Test
	public void testSellingBooks(){
		System.out.println("testing the sale of books");
	}
	
	public boolean isLoggedin(){
		//return true; // logged in
		return false;
	}
	

}
