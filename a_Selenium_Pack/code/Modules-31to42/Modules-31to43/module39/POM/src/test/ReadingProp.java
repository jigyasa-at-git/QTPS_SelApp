package test;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Properties prop = new Properties();
		String path = System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\config\\config.properties";
		System.out.println(System.getProperty("user.dir"));
		System.out.println(path);
		
		try{
		FileInputStream fs = new FileInputStream(path);
		prop.load(fs);
		}catch(Exception e){
			// error
			return;
		}
			
		System.out.println(prop.getProperty("testSiteLadingPageURL"));
		System.out.println(prop.getProperty("xxxxxxx"));
		
		
	}

}
