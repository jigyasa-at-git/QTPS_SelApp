package roughwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;


public class Reading_Prop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\project.properties";
		
		Properties prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(path);
			prop.load(fs);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(prop.getProperty("fileLocation"));
	}

}
