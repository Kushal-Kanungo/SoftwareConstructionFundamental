package com.nqueens;

import java.security.InvalidParameterException;
import java.util.Arrays;

/**
 * class : NQueens
 * 
 * desc : This class have methods to solve the famous NQueens Problem using
 * recursion and backtracking
 * 
 * @author Kushal
 * @since 19 OCT 2022 2:15 P.M.
 *
 */
public class NQueens {

	/**
	 * desc : It will create a board and fill it with 0's
	 * 
	 * @param dimensions of the board
	 * @return the created board of 0's
	 */
	public static int[][] createBoard(int dimensions) {
		int[][] board = new int[dimensions][dimensions];
		for (int[] row : board)
			Arrays.fill(row, 0);
		return board;
	}

	/**
	 * desc : This method will check if the current position of queen is valid in
	 * board It checks same row, same col, and diagonals
	 * 
	 * @param chessBoard
	 * @param row
	 * @param col
	 * @return
	 */
	private static boolean isValidBoard(int[][] chessBoard, int row, int col) {

		for (int rowCheck = 0; rowCheck <= row; rowCheck++) {
			if (chessBoard[rowCheck][col] == 1)
				return false;
			if (row - rowCheck >= 0 && col - rowCheck >= 0 && chessBoard[row - rowCheck][col - rowCheck] == 1)
				return false;
			if (row - rowCheck >= 0 && col + rowCheck < chessBoard.length
					&& chessBoard[row - rowCheck][col + rowCheck] == 1)
				return false;
		}
		return true;
	}

	/**
	 * desc : This method will recursively fill the board until all rows are filled
	 * 
	 * @param chessBoard 2D Matrix of 0 filled
	 * @param row
	 * @return
	 */
	private static boolean recursiveSolveNQueen(int[][] chessBoard, int row) {
		if (row == chessBoard.length) {
			return true;
		}

		for (int col = 0; col < chessBoard.length; col++) {
			if (isValidBoard(chessBoard, row, col)) {
				chessBoard[row][col] = 1;
				if (recursiveSolveNQueen(chessBoard, row + 1))
					return true;
				chessBoard[row][col] = 0;
			}
		}
		return false;
	}

	/**
	 * 
	 * desc : It just call the function to solve the board and return the solved
	 * board
	 * 
	 * @param chessBoard
	 * @return
	 * @throws InvalidParameterException if board is not solvable
	 */
	public static int[][] solveNQueens(int[][] chessBoard) throws InvalidParameterException {
		int[][] board = chessBoard;
		if (recursiveSolveNQueen(board, 0) == false)
			throw new InvalidParameterException("Board cannot be solved");
		return board;
	}

}
