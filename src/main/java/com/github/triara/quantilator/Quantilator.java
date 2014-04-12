package com.github.triara.quantilator;

import java.util.ArrayList;
import java.util.Collections;

public class Quantilator {

	public static Double calculateQuantile(ArrayList<Double> list, Double quantile) {
		list.removeAll(Collections.singleton(null));
		if (list.size() == 0){
			return null;
		}
		return 0.0;
	}
}
