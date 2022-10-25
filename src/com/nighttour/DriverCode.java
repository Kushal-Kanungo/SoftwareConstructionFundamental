package com.nighttour;

import java.util.Scanner;

/**
 * 
 * 
 * @author Kushal
 * @since 20 OCT 2022 4:30
 */
public class DriverCode {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Board Dimension");
		int N = sc.nextInt();
		int[][] board = NightTour.createBoard(N);
		board[0][0] = 0;
		NightTour.fillRecursively(board, 1, 0, 0, N);
		NightTour.printBoard(board, N);
		sc.close();
	}
}
