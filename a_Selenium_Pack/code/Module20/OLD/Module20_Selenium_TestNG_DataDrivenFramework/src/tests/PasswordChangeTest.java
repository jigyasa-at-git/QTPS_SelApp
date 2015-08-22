package tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestUtil;

public class PasswordChangeTest {
	@BeforeTest
	public void isSkipped(){
		if(TestUtil.isSkip("PasswordChangeTest"))
			throw new SkipException("Runmode set to No");
	}
	@Test
	public void testPasswordChange(){
		//hw
	}

}
