package tests.suite1;

import java.io.IOException;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import tests.TestBase;
import util.TestUtil;

public class PasswordChangeTest extends TestBase{

	
	@Before
	public void beforeTest() throws IOException{
		initialize();
		// xlsx file
		if(TestUtil.isSkip("PasswordChangeTest"))
			Assume.assumeTrue(false);
		
	}

	
	
	@Test
	public void postAddTest(){
		System.out.println("Post add - HW");
	}

}
