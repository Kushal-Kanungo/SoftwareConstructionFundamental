package arrayOperation;

import java.util.Scanner;

/**
 * class = ArrayDriverCode
 * 
 * Desc = This is driver code for ArrayOperartion Class. Implementing All the methods and testing them. 
 * 
 * @author Kushal
 * 
 */
public class ArrayDriverCode {

	public static void displayMenu() {
		System.out.println("===========Array  Operations==========");
		System.out.println("1 => Find Largest Mirror Subarray ");
		System.out.println("2 => Count Number of Clumps ");
		System.out.println("3 => Split The Array in half");
		System.out.println("4 => FixXY Positions in array");
		System.out.println("0 => Exit the Program");
	}

	public static int[] inputArray(Scanner sc) {
		System.out.print("Enter num of elements in array : ");
		int size = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Elements : ");
		int[] array = new int[size];
		for (int idx = 0; idx < size; idx++) {
			array[idx] = sc.nextInt();
		}
		return array;
	}

	public static void printArray(int[] array) {
		for (int num : array) {
			System.out.print(" " + num);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] array;
		loop:
		while (true) {
			try {
				displayMenu();
				System.out.print("Select An Option : ");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					array = inputArray(sc);
					System.out.println("Maximum Mirror Length is " + ArrayOperations.largestMirror(array));
					break;
				case 2:
					array = inputArray(sc);
					System.out.println("No of clumps is " + ArrayOperations.countClumps(array));
					break;
				case 3:
					array = inputArray(sc);
					System.out.println("Array split at index " + ArrayOperations.splitArray(array));
					break;
				case 4:
					array = inputArray(sc);
					System.out.print("Enter X and Y :");
					int X = sc.nextInt();
					int Y = sc.nextInt();
					int[] result = ArrayOperations.fixXY(array, X, Y);
					System.out.println("Fixed Array is ");
					printArray(result);
					System.out.println("");
					break;
				case 0:
					break loop;

				default:
					System.out.println("Invalid Option");
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}
		sc.close();
	}
}
