package com.mobile.qtpselenium.makemytrip;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_Java {

	public static void main(String[] args) throws ParseException {
		Date d = new Date();
		System.out.println(d);
		
		SimpleDateFormat df = new SimpleDateFormat("dd");
		System.out.println(df.format(d));
		df = new SimpleDateFormat("MMMM");
		System.out.println(df.format(d));
		df = new SimpleDateFormat("yyyy");
		System.out.println(df.format(d));
		
		String date="05/01/2015";
		df = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = df.parse(date);
		df = new SimpleDateFormat("MMMM");
		System.out.println(df.format(d1));
		
		

	}

}
