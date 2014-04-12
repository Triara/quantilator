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
		
		if (type == 6) {
			m = quantile;
		}else if (type == 7) {
			m = 1.0 - quantile;
		}else if (type == 8) {
			m = (quantile + 1)/3;
		}
		
		
		j = (int) (quantile*n + m);
		gamma = quantile*n + m - j;
		
		int lowerElement = (j - 1 < 0) ? 0 : j - 1;
		int upperElement = (j == n) ? j - 1 : j;
		
		return (((1.0 - gamma)*list.get(lowerElement)) + gamma*list.get(upperElement));
	}
}
