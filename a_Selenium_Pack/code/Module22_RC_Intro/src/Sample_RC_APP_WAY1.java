
import org.testng.annotations.Test;

import com.thoughtworks.selenium.SeleneseTestCase;

// www.qtpselenium.com/downloads/jars.rar
public class Sample_RC_APP_WAY1 extends SeleneseTestCase {
	
	@Test
	public void testGmail() throws Exception{
		setUp("http://gmail.com", "*firefox"); // initialze DefaultSelenium Class
        selenium.open("/");	
		
	}

	
	

}
