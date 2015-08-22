package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.junit.Rule;
import org.junit.rules.ErrorCollector;
import org.openqa.selenium.server.SeleniumServer;

import com.thoughtworks.selenium.DefaultSelenium;

import datatable.Xls_Reader;

public class TestBase {
	
	public static DefaultSelenium selenium=null;
	public static Properties CONFIG = new Properties();
	public static Properties XPATH_MAP = new Properties();
	public static Xls_Reader datatable_suite1 = null;
	public static Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
	public SeleniumServer server = null;
	@Rule
	public ErrorCollector errCol = new ErrorCollector();
	
	public static void initialize() throws Exception{
		
		if(selenium == null){
			// start the selenium server
			SeleniumServer server = new SeleniumServer();
			server.boot();
			server.start();
			// load the config.properties
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//config//config.properties");
			CONFIG.load(fis);
			APP_LOGS.debug("Loaded config.properties");
			// load the OR.properties
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//config//OR.properties");
			XPATH_MAP.load(fis);
			APP_LOGS.debug("Loaded OR.properties");

			// initialize selenium
			selenium = new DefaultSelenium("localhost"
					,4444,
					CONFIG.getProperty("browserType"),
					CONFIG.getProperty("baseURL"));
			APP_LOGS.debug("Initialized selenium");
			selenium.start();
			selenium.windowMaximize();
			selenium.windowFocus();
			

			// load the xls file
			datatable_suite1 = new Xls_Reader(System.getProperty("user.dir")+"//src//config//TestData.xlsx");
			APP_LOGS.debug("Loaded data from xls files");

			
		}
	
	}
	
	public void stopServer(){
		selenium.stop();
		server.stop();
	}
	

}
