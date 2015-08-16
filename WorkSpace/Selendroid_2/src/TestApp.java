import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;


public class TestApp {

	WebDriver driver;

	@Test
	public void test() throws Exception {
		//com.rflsnchz.led.flashlight.plus:3.3
	//	SelendroidCapabilities capa = new SelendroidCapabilities(
	//			"com.whatsapp:2.11.399");
		SelendroidCapabilities capa = new SelendroidCapabilities(
				"com.rflsnchz.led.flashlight.plus:3.3");
		driver = new SelendroidDriver(capa);
		System.out.println("testing123");
		Thread.sleep(5000);
	}

	@AfterTest
	public void close() {

		driver.quit();

	}

}
