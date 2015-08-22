package testSuiteA;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestA1 {

	
	@Test
	public void testA1_1(){
		throw new SkipException("Skipping the test");
	}
	
	@Test
	public void testA1_2(){
		
	}
	
	
	@Test
	public void testA1_3(){
		Assert.fail("failed test case ");
	}
}
