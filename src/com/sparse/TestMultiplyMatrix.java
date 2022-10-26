package com.sparse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestMultiplyMatrix {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new int[][] { { 3, 7 }, { 4, 9 } }, new int[][] { { 6, 2 }, { 5, 8 } },
						new int[][] { { 53, 62 }, { 69, 80 } }),
				Arguments.of(new int[][] { { 1 } }, new int[][] { { -1 } }, new int[][] { { -1 } }),
				Arguments.of(new int[][] { { 12, 8, 4 }, { 3, 17, 14 }, { 9, 8, 10 } },
						new int[][] { { 5, 19, 3 }, { 6, 15, 9 }, { 7, 8, 16 } },
						new int[][] { { 136, 380, 172 }, { 215, 424, 386 }, { 163, 371, 259 } }),
				Arguments.of(new int[][] { { 1, 0, 1 }, { 0, 2, 0 }, { 1, 0, 3 } },
						new int[][] { { 2, 0, 0 }, { 0, 0, 0 }, { 1, 0, 3 } },
						new int[][] { { 3, 0, 3 }, { 0, 0, 0 }, { 5, 0, 9 } })

		);
	}

	@ParameterizedTest
	@MethodSource
	public void object(int[][] first, int[][] second, int[][] target) {
		SparseMatrix firstMatrix = new SparseMatrix(first);
		SparseMatrix secondMatrix = new SparseMatrix(second);
		SparseMatrix result = firstMatrix.multiplyWith(secondMatrix);
		assertArrayEquals(target, result.getInMatrixForm());

	}

}
