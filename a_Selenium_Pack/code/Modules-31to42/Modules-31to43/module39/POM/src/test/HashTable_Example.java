package test;

import java.util.Hashtable;

public class HashTable_Example {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Hashtable<String,String> table = new Hashtable<String,String> ();
		table.put("name", "Selenium");
		table.put("purpose", "automation");
		
		System.out.println(table.get("name"));
		
		
		
	}

}
