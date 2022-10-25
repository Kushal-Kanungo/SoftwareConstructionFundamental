package com.nighttour;

import java.util.Arrays;

public class NightTour {

	/**
	 * To create a 2D Matrix pre-filled with 0
	 * 
	 * @param dimensions
	 * @return
	 */
	public static int[][] createBoard(int dimensions) {
		int[][] board = new int[dimensions][dimensions];
		for (int[] row : board)
			Arrays.fill(row, -1);
		return board;
	}

	/**
	 * To check a position is valid or not 
	 * 
	 * @param usedPlaces
	 * @param dimension
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isValidPostion(int[][] board, int dimension, int row, int col) {
		if (row >= 0 && col >= 0 && row < dimension && col < dimension && board[row][col] == -1)
			return true;
		return false;
	}

	/**
	 * Fill the board recursively
	 * 
	 * @param board
	 * @param blockVisitedNumber
	 * @param row
	 * @param col
	 * @param N
	 * @return
	 */
	public static boolean fillRecursively(int[][] board, int blockVisitedNumber, int row, int col,
			int N) {
		if (blockVisitedNumber==N*N) {
			if (row==0 && col==0)
				System.out.println("Closed Loop");
			else
				System.out.println("Open Loop");
			return true;
		}
		int[][] rowCol = { { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 }, { 1, 2 }, { -1, 2 }, { 1, -2 }, { -1, -2 } };

		for (int idx = 0; idx < rowCol.length; idx++) {
			int newRow = row + rowCol[idx][0];
			int newCol = col + rowCol[idx][1];
			if (isValidPostion(board, N, newRow, newCol)) {
				board[newRow][newCol] = blockVisitedNumber;
				if (fillRecursively(board, blockVisitedNumber + 1, newRow, newCol, N))
					return true;
				board[newRow][newCol] = -1;
			}
		}
		return false;
	}

	/**
	 * To print a 2d matrix
	 * 
	 * @param board
	 * @param dimension
	 */
	public static void printBoard(int[][] board, int dimension) {
		for (int idx = 0; idx < dimension; idx++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(board[idx][j] + "\t");
			}
			System.out.println("\n");
		}
	}

}
