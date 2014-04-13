
package com.github.triara.quantilator;

import static junit.framework.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class QuantilatorTest {

	@Test
	public void shouldReceiveArrayListAndReturnDoubles() {
		ArrayList<Double> receivedList = createNewList(0.0);
    
		Double expectedResult = 0.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.5, 8);
    
		assertEquals("Quantilator should receive an array list and return a double", expectedResult, actualResult);
	}

	@Test
	public void shouldBeAbleToHandleNullValues() {
		ArrayList<Double> receivedList = createNewList((Double)null);
		
		assertNull("If an array with one null value is received method should return another null",Quantilator.calculateQuantile(receivedList, 0.5, 8));
	}
	
	@Test
	public void shouldCalculatePercentilesForType8Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 82.9;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 8);
		
		assertEquals("Should calculate quantile for type 8 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType7Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 79.3;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 7);
		
		assertEquals("Should calculate quantile for type 7 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType6Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 84.7;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 6);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType5Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 82.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 5);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType4Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 77.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 4);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType9Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 82.675;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 9);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType1Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 80.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 1);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}

	@Test
	public void shouldCalculatePercentilesForType2Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 80.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 2);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldCalculatePercentilesForType3Definition() {
		ArrayList<Double> receivedList = createNewList(10.0,20.0,30.0,40.0,50.0,60.0,70.0,80.0,90.0,100.0);
		
		Double expectedResult = 80.0;
		Double actualResult = Quantilator.calculateQuantile(receivedList, 0.77, 3);
		
		assertEquals("Should calculate quantile for type 6 definition", expectedResult, actualResult);
	}
	
	@Test
	public void shouldTellIfGivenNumberIsEvenOrOdd() {
		assertFalse("7 is odd", Quantilator.isEven(7));
		assertTrue("6 is even", Quantilator.isEven(6));
	}
	
	private ArrayList<Double> createNewList(Double ... values){
		ArrayList<Double> list = new ArrayList<Double>();
		for (Double value : values) {
			list.add(value);
		}
		return list;
		
	}
  
}
