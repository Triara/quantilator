package com.github.triara.quantilator;

import java.util.ArrayList;
import java.util.Collections;

public class Quantilator {
private static double m;
private static int n;
private static int j;
private static double gamma;
	
	public static ArrayList<Double> calculateQuantile(ArrayList<Double> receivedList, ArrayList<Double> quantilesValues,int type) {
		ArrayList<Double> percentiles = new ArrayList<Double>();
		for (Double quantile : quantilesValues) {
			percentiles.add(calculateQuantile(receivedList, quantile, type));
		}
		return percentiles;
	}
	public static Double calculateQuantile(ArrayList<Double> list, Double quantile, Integer type) {
		list.removeAll(Collections.singleton(null));
		if (list.size() == 0) return null;		
		Collections.sort(list);
		
		n = list.size();
		m = calculateAuxiliarConstantM(quantile, type);
		j = (int) (quantile*n + m);
		gamma = calculateAuxiliarConstantGamma(quantile, type);
		
		int lowerElement = (j - 1 < 0) ? 0 : j - 1;
		int upperElement = (j == n) ? j - 1 : j;
		
		return (((1.0 - gamma)*list.get(lowerElement)) + gamma*list.get(upperElement));
	}

	private static double calculateAuxiliarConstantGamma(Double quantile, Integer type) {
		if (type == 1) return ((quantile*n + m - j) > 0)? 1.0 : 0.0;
		else if (type == 2) return ((quantile*n + m - j) > 0)? 1.0 : 0.5;
		else if(type == 3) return ((quantile*n + m - j) == 0 && isEven(j))? 0.0 : 1.0;
		else return quantile*n + m - j;			
	}

	private static double calculateAuxiliarConstantM(Double quantile, Integer type) {
		if (type == 1 || type == 2 || type == 4) return 0.0;
		else if (type == 3) return -0.5;
		else if (type == 5) return 0.5;
		else if (type == 6) return quantile;
		else if (type == 7) return 1.0 - quantile;
		else if (type == 9) return 0.25*quantile + 0.375;
		else return (quantile + 1)/3;
	}
	
	private static boolean isEven(int number){
		if ((number/2.0) == (int)Math.ceil(number/2.0)) return true;
		return false;
	}

}