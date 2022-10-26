package com.sparse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestSymmetry {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[][] {{1}}, true),
				Arguments.of(new int[][] {{1,-2},{-2,0}}, true),
				Arguments.of(new int[][] {{1,2,-1},{2,1,3},{-1,3,0}}, true),
				Arguments.of(new int[][] {{0,0,1},{2,0,2}, {-3,0,0}}, false),
				Arguments.of(new int[][] {{0,0},{2,0}, {-3,0}, {0,1}, {6,7}}, false)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(int[][] matrix , boolean target) {
		SparseMatrix newMatrix = new SparseMatrix(matrix);
		assertEquals(target, newMatrix.isSymmetric());
		
	}
	
	
}
