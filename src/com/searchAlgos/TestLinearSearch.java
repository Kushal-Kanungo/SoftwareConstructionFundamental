package com.searchAlgos;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestLinearSearch {

	public static Stream<Arguments> object() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, 3, 2),
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, 1, 0), 
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, 8, -1),
				Arguments.of(new int[] { 45, 67, 89, 100 }, 100, 3),
				Arguments.of(new int[] { 1, 2, 2, 2, 2, 2, 4 }, 2, 1),
				Arguments.of(new int[] { -4, -3, -2, -1, 1, 2, 2, 2, 2, 2, 4 }, -3, 1));
	}

	@ParameterizedTest
	@MethodSource
	public void object(int[] arr, int target, int excepted) {
		int result = SearchingAlgorithm.LinearSearch(arr, target, 0);
		assertEquals(excepted, result);
	}

	@Test
	void testEmptyArray() {
		assertThrows(InvalidParameterException.class, () -> {
			SearchingAlgorithm.LinearSearch(new int[] {}, 0, 0);
		});
	}
}
