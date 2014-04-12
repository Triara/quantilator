
package com.github.triara.quantilator;

import static junit.framework.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class QuantilatorTest {

	@Test
	public void shouldReceiveArrayListAndReturnDoubles() {
		ArrayList<Double> receivedList = createNewList(0.0);
    
		Double expectedResult = 0.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.5);
    
		assertEquals("Quantilator should receive an array list and return a double", expectedResult, actualResult);
	}

	@Test
	public void shouldBeAbleToHandleNullValues() {
		ArrayList<Double> receivedList = createNewList((Double)null);
		
		assertNull("If an array with one null value is received method should return another null",Quantilator.calculateQuantile(receivedList, 0.5));
	}
	
	private ArrayList<Double> createNewList(Double ... values){
		ArrayList<Double> list = new ArrayList<Double>();
		for (Double value : values) {
			list.add(value);
		}
		return list;
		
	}
  
}
