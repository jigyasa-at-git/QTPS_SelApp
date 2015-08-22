package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTest {

	/**
	 * @param args
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ReflectionTest t =  new ReflectionTest();
		//t.abc();
		
		Method method[] = t.getClass().getMethods();
		
		for(int i=0;i<method.length;i++){
			//System.out.println(method[i].getName());
			
			if(method[i].getName().equals("abc")){
				method[i].invoke(t);
			}
		}

	}
	
	
	public void abc(){
		System.out.println("ABC");
	}
	
	public void xyz(){
		System.out.println("XYZ");
	}

}
