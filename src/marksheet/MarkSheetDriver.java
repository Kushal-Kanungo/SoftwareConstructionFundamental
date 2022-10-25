package marksheet;

import java.util.Scanner;

/**
 * class = "MarksheetDriver"
 * @author Kushal
 *
 */
public class MarkSheetDriver {

	/**
	 * It Displays the menu
	 * 
	 */
	public static void displayMenu() {
		System.out.println("==========MARKSHEET===========");
		System.out.println("1 => Average Grade Of Class");
		System.out.println("2 => Maximum Grade Of Class");
		System.out.println("3 => Minimum Grade Of Class");
		System.out.println("4 => Percent of Students Passed");
	}

	/**
	 * It is the main method of driver code. Implementation of each method of our class.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int totalStudents;
		int[] gradesArray;
		System.out.println("Enter Number Of Students");

		totalStudents = sc.nextInt();
		System.out.println("Enter Grades Seperated By Space");
		gradesArray = new int[totalStudents];
		for (int index = 0; index < totalStudents; index++) {
			gradesArray[index] = sc.nextInt();
		}

		try {
		Marksheet marksheet = new Marksheet(totalStudents, gradesArray);
		
		
		loop: while (true) {
				displayMenu();
				System.out.println("Select the Option : ");
				int option = sc.nextInt();
				
				switch (option) {
				case 1:
					System.out.println("Average Grade of Class is : " + marksheet.calculateAverageGrade());
					break;
				case 2:
					System.out.println("Maximum Grade in Class is : " + marksheet.calculateMaxGrade());
					break;
				case 3:
					System.out.println("Minimum Grade in Class is : " + marksheet.calculateMinGrade());
					break;
				case 4:
					System.out.println("Percent Of Students Passed : " + marksheet.calculatePassedPercent() + "%");
					break;
				default:
					break loop;
				}
			
			System.out.println("Press Enter To Continue");
			sc.nextLine();
			sc.nextLine();

		}
		} catch (ArithmeticException e1) {
			System.out.println("Arithmatic Exception Catched.");
		}
		sc.close();
	}
}
