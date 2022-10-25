package com.assignment_5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestIsMember {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[] {1,2,3,4,5}, 4, true),
				Arguments.of(new int[] {1,2,3}, 4, false),
				Arguments.of(new int[] {}, 4, false),
				Arguments.of(new int[] {4,6,8,8,90}, 91, false),
				Arguments.of(new int[] {1,1,1,1,5,5}, 5, true)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(int[] firstSetArray ,int target, boolean expected) {
		
		List<Integer> firstValues = new ArrayList<Integer>();
		for (Integer intVal : firstSetArray) {
			firstValues.add(intVal);
		}
		InSetClass firstSet = new InSetClass(firstValues);
		
		assertEquals(expected,firstSet.isMember(target));
	}

}
