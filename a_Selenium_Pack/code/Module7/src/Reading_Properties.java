import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class Reading_Properties {

	
	public static void main(String[] args) throws IOException {
	
	FileInputStream fs = new FileInputStream("F:\\Workspaces\\Selenium Online Training Videos\\Module7\\src\\student.properties");
	Properties prop = new Properties();
	prop.load(fs);
	
	System.out.println(prop.getProperty("name"));
	System.out.println(prop.getProperty("age"));
	System.out.println(prop.getProperty("browser"));
		

	}

}
