package com.myprioritizer;

import java.util.Map;

import org.openqa.grid.internal.listeners.Prioritizer;

public class CustomPrioritizer implements Prioritizer{

	@Override
	public int compareTo(Map<String, Object> t1, Map<String, Object> t2) {

		String pri1 = (String)t1.get("_important");
		String pri2 = (String)t2.get("_important");
		
		int p1 = Integer.parseInt(pri1);
		int p2 = Integer.parseInt(pri2);
		
		if(p1==p2){
			return 0;
		}else if(p1>p2){
			return -1;
		}else{
			return 1;
		}
		
	}

}
