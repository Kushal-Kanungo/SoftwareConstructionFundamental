package com.assignment_5;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestIsSubSet {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[] {1,2,3,4,5,6}, new int[] {4,5,6}, true),
				Arguments.of(new int[] {1,2,3}, new int[] {1,2,3}, true),
				Arguments.of(new int[] {4,6,8}, new int[] {5,7,9}, false),
				Arguments.of(new int[] {1,1,1,1,5,5}, new int[] {1,5}, true),
				Arguments.of(new int[] {1,1,1,1,5,5}, new int[] {1,5,6}, false),
				Arguments.of(new int[] {100,100,100,100}, new int[] {101,100}, false)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(int[] firstSetArray ,int[] secondSetArray, boolean expected) {
		
		List<Integer> firstValues = new ArrayList<Integer>();
		List<Integer> secondValues = new ArrayList<Integer>();
		for (Integer intVal : firstSetArray) {
			firstValues.add(intVal);
		}
		for (Integer intVal : secondSetArray) {
			secondValues.add(intVal);
		}
		InSetClass firstSet = new InSetClass(firstValues);
		InSetClass secondSet = new InSetClass(secondValues);
		
		assertEquals(expected, firstSet.isSubSet(secondSet));
		
	}
}
