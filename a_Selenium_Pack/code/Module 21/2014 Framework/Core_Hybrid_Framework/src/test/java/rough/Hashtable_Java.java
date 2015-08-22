package rough;

import java.util.Hashtable;

public class Hashtable_Java {

	public static void main(String[] args) {
		Hashtable<String,String> hash= new Hashtable<String,String>();
		hash.put("name", "Selenium");
		hash.put("ver", "2.44.0");
		
		System.out.println(hash.get("name"));

	}

}
