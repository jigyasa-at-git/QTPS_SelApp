import java.util.Hashtable;
import java.util.List;


public class Client2 {

	public static void main(String[] args) {
		
		XMLReader xml = new XMLReader(System.getProperty("user.dir")+"//Suite.xml");
	//	xml.getDataAsList("LoginTest");
		List<Hashtable<String,String>> data = xml.getDataAsList("ChangePasswd");
		System.out.println(data);

		
		Object[][] data1 = xml.getDataAsArray("LoginTest");
		System.out.println(data1);
	}

}
