package rough;

import java.io.FileInputStream;
import java.util.Properties;

public class Reading_prop {


	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"\\src\\com\\qtpselenium\\hybrid\\config\\OR.properties");
			prop.load(fs);
			System.out.println(prop.getProperty("login_username"));
			System.out.println(prop.getProperty("XXXXX"));

		} catch (Exception e) {
			// Error is found
			e.printStackTrace();
		}
	}

}
