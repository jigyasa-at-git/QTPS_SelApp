package com.mobile.qtpselenium.makemytrip;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;

public class MyArrayList<E> extends ArrayList<E>{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean add(E o){
		System.out.println("Adding "+o);
		super.add(o);
		return true;
	}

}
