package com.nqueens;

import java.util.Scanner;

public class Driver {

	public static void printBoard(int[][] board, int dimension) {
		for(int idx=0; idx<dimension; idx++) {
			for (int j = 0; j < dimension; j++) {
				System.out.print(board[idx][j]+" ");
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter dimension of board :");
		int N = sc.nextInt();
		int[][] board = NQueens.solveNQueens(NQueens.createBoard(N));
		
		printBoard(board, N);
		sc.close();
	}
	
}
