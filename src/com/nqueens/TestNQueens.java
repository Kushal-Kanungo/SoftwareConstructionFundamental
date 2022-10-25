package com.nqueens;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestNQueens {

	public static Stream<Arguments> testNQueens() {
		return Stream.of(
				Arguments.of(NQueens.createBoard(5),
						new int[][] { { 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 },
								{ 0, 0, 0, 1, 0 } }),
				Arguments.of(NQueens.createBoard(4),
						new int[][] { { 0, 1, 0, 0 }, { 0, 0, 0, 1 }, { 1, 0, 0, 0 }, { 0, 0, 1, 0 } }),
				Arguments.of(new int[][] { { 0 } }, new int[][] { { 1 } }));
	}

	@ParameterizedTest
	@MethodSource
	public void testNQueens(int[][] board, int[][] excepted) {
		int[][] result = NQueens.solveNQueens(board);
		assertArrayEquals(excepted, result);
	}

	@Test
	public void testUnsolvable() {
		assertThrows(InvalidParameterException.class, () -> {
			NQueens.solveNQueens(new int[][] { { 0, 0 }, { 0, 0 } });
		});
	}

	@Test
	public void testUnsolvable1() {
		assertThrows(InvalidParameterException.class, () -> {
			NQueens.solveNQueens(NQueens.createBoard(3));
		});
	}

}
