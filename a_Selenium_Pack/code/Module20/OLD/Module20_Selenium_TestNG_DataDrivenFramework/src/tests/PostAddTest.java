package tests;

import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.TestUtil;

public class PostAddTest {
	@BeforeTest
	public void isSkipped(){
		if(TestUtil.isSkip("PostAddTest"))
			throw new SkipException("Runmode set to No");
	}
	
	@Test
	public static void testPostAdd(){
		// HW
	}

}
