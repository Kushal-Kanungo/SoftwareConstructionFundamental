package com.sparse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestAddMatrix {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[][] {{0,1},{0, 0}}, new int[][] {{0,0},{7, 0}}, new int[][] {{0,1},{7, 0}}),
				Arguments.of(new int[][] {{9,0},{0, 0}}, new int[][] {{0,0},{0, 0}}, new int[][] {{9,0},{0, 0}}),
				Arguments.of(new int[][] {{1,0,0},{0,2, 0}, {0,0,3}}, new int[][] {{0,0,1},{0, 2,0}, {3,0,0}}, new int[][] {{1,0,1},{0, 4,0}, {3,0,3}})
				);
	}

	@ParameterizedTest
	@MethodSource
	public void object(int[][] firstArray ,int[][] secondArray, int[][] target) {
		SparseMatrix first = new SparseMatrix(firstArray);
		SparseMatrix second = new SparseMatrix(secondArray);
		SparseMatrix addedMatrix = first.addMatrix(second);
		
		assertArrayEquals(target, addedMatrix.getInMatrixForm());
	
}
}
