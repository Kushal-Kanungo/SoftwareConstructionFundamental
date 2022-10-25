package com.searchAlgos;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestBinarySearch {

	public static Stream<Arguments> testBinarySearch() {
		return Stream.of(Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, 3, 2),
				Arguments.of(new int[] { 1, 2, 4, 6 }, 6, 3), 
				Arguments.of(new int[] { 1, 2, 3, 4, 5, 6 }, 1, 0),
				Arguments.of(new int[] { 1, 3, 5, 8, 9, 10 }, 9, 4),
				Arguments.of(new int[] { 1, 2, 2, 2, 2, 5, 6, 7 }, 2, 1));
	}

	@ParameterizedTest
	@MethodSource
	public void testBinarySearch(int arr[], int target, int excepted) {
		int result = SearchingAlgorithm.binarySearch(arr, target);
		assertEquals(excepted, result);

	}

	@Test
	void testEmptyArray() {
		assertThrows(InvalidParameterException.class, () -> {
			SearchingAlgorithm.binarySearch(new int[] {}, 3);
		});
	}
}
