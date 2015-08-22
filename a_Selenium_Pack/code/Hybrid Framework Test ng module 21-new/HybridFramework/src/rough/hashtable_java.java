package rough;

import java.util.Hashtable;

public class hashtable_java {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		Hashtable<String,String> table = new Hashtable<String,String>();
		table.put("name", "Ashish");
		table.put("place", "India");
		
		System.out.println(table.get("name"));
		System.out.println(table.get("place"));
		System.out.println(table.get("xxx"));

	}

}
