package com.github.triara.quantilator;

import java.util.ArrayList;
import java.util.Collections;

public class Quantilator {
private static double m;
private static int n;
private static int j;
private static double gamma;
	
	public static Double calculateQuantile(ArrayList<Double> list, Double quantile, Integer type) {
		list.removeAll(Collections.singleton(null));
		if (list.size() == 0){
			return null;
		}
		
		Collections.sort(list);
		n = list.size();
		
		if (type == 1) {
			m = 0.0;
		}else if (type == 2){
			m = 0.0;
		}else if (type == 3) {
			m = -0.5;
		}else if (type == 4) {
			m = 0.0;
		}else if (type == 5) {
			m = 0.5;
		}else if (type == 6) {
			m = quantile;
		}else if (type == 7) {
			m = 1.0 - quantile;
		}else if (type == 8) {
			m = (quantile + 1)/3;
		}else if (type == 9) {
			m = 0.25*quantile + 0.375;
		}
		
		
		j = (int) (quantile*n + m);
		
		if (type == 1) {
			gamma = ((quantile*n + m - j) > 0)? 1.0 : 0.0;
		}else if (type == 2) {
			gamma = ((quantile*n + m - j) > 0)? 1.0 : 0.5;
		}else if(type == 3) {
			gamma = ((quantile*n + m - j) == 0 && isEven(j))? 0.0 : 1.0;
		}else {
			gamma = quantile*n + m - j;			
		}
		
		int lowerElement = (j - 1 < 0) ? 0 : j - 1;
		int upperElement = (j == n) ? j - 1 : j;
		
		return (((1.0 - gamma)*list.get(lowerElement)) + gamma*list.get(upperElement));
	}
	
	public static boolean isEven(int number){
		if ((number/2.0) == (int)Math.ceil(number/2.0)) {
			return true;
		}
		return false;
	}
	
}
