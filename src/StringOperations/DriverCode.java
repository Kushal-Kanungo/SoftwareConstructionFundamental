package StringOperations;

import java.util.Scanner;

/**
 * 
 * class = "Driver Code"
 * 
 * @author Kushal
 *
 */
public class DriverCode {
	public static void displayMenu() {
		System.out.println("===========String Operations============");
		System.out.println("1 => Check Two Strings Equal Or Not");
		System.out.println("2 => Reverse Of The String");
		System.out.println("3 => Invert the cases of a string");
		System.out.println("4 => Largest word in a string");
		System.out.println("0 => Exit The Program");
		System.out.print("\nSelect an option : ");
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringClass stringOperations = new StringClass();
		String word;
		
		loop:
		while (true) {
			
			try {
				displayMenu();
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.println("Enter First Word : ");
					sc.nextLine();
					String word1 = sc.nextLine();
					System.out.println("Enter Second Word : ");
					String word2 = sc.nextLine();
					if (stringOperations.areEqual(word1, word2)) {
						System.out.println("Both Strings Are Equal");
					}
					else {
						System.out.println("Both Strings Are Unequal");
					}
					
					break;
				case 2:
					System.out.println("Enter the string : ");
					sc.nextLine();
					word = sc.nextLine();
					System.out.println("Reverse is : "+ stringOperations.reverseString(word));
					break;
				case 3:
					System.out.println("Enter the string : ");
					sc.nextLine();
					word = sc.nextLine();
					System.out.println("Invert cases string is : "+ stringOperations.invertStringCase(word));
					break;
				case 4:
					System.out.println("Enter the string : ");
					sc.nextLine();
					word = sc.nextLine();
					System.out.println("Largest Word is : "+ stringOperations.longestWord(word));
					break;
				case 0:
					break loop;
				default:
					break;
				}
				System.out.println("Press Enter to continue...");
				sc.nextLine();
			} catch (Exception e) {
				System.out.println("Please enter a valid option");
				System.out.print("\n \nPress Enter to continue...");
				sc.nextLine();
				continue;
			}
		}
		
		System.out.println("Program Exited Successfully");
		sc.close();
	}
}
