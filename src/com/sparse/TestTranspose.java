package com.sparse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestTranspose {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[][] { { 1 } }, new int[][] { { 1 } }),
				Arguments.of(new int[][] { { 1, 0 }, { 0, 1 } }, new int[][] { { 1, 0 }, { 0, 1 } }),
				Arguments.of(new int[][] { { 1, 0, 1 }, { 2, 0, 1 } }, new int[][] { { 1, 2 }, { 0, 0 }, { 1, 1 } }),
				Arguments.of(new int[][] { { 1, 0, 1 }, { 2, 0, 1 }, { 3, 0, -1 } },
						new int[][] { { 1, 2, 3 }, { 0, 0, 0 }, { 1, 1, -1 } }),
				Arguments.of(new int[][] {{1, 1}}, new int[][] {{1}, {1}})

		);
	}

	@ParameterizedTest
	@MethodSource
	public void object(int[][] matrix, int[][] excepted) {
		SparseMatrix first = new SparseMatrix(matrix);
		SparseMatrix transposed = first.transposeMatrix();
		assertArrayEquals(excepted, transposed.getInMatrixForm());

	}

}
