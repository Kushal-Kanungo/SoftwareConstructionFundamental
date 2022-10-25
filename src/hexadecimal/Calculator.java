package hexadecimal;

import java.util.Scanner;

/**
 * 
 * class: Calculator
 * Driver Code 
 * 
 * @author Kushal
 * 
 *
 */
public class Calculator {
	/**
	 * This method just displays the menu
	 * 
	 * @author Kushal
	 */
	public static void displayMenu() {
		System.out.println("=============Hexa Convertor============\n");
		System.out.println(" 1 => Convert Decimal To HexaDecimal");
		System.out.println(" 2 => Convert HexaDecimal To Decimal");
		System.out.println(" 3 => Add Two HexaDecimals");
		System.out.println(" 4 => Subtract Two HexaDecimals");
		System.out.println(" 5 => Multiply Two HexaDecimals");
		System.out.println(" 6 => Divide Two HexaDecimals");
		System.out.println(" 7 => Compare Two HexaDecimal");
		System.out.println(" 0 => To Exit The Program");
		System.out.print("\nEnter Action You Want To Perform : ");
	}

	/**
	 * This method we just to take an hexadecimal String input 
	 * 
	 * @param sc
	 * @return
	 * @throws Exception
	 */
	public static String takeHexaInput(Scanner sc) throws Exception {
		System.out.print("Enter HexaDecimal Value : ");
		String num = sc.next();
		return num;
	}

	/**
	 * This method will just used to take Integer input
	 * 
	 * @param sc
	 * @return
	 */
	public static int takeIntegerInput(Scanner sc) {

		System.out.print("Enter Positive Integer Value : ");
		int num = Integer.parseInt(sc.next());
		return num;
	}

	/**
	 * This is driver code for the assignment. Here we implemented all the functions of HexCalculator 
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		HexCalc calc = new HexCalc();
		int choice;
		String num1;
		String num2;

		while (true) {
			displayMenu();
			try {
				choice = Integer.parseInt(sc.next());
				switch (choice) {
				case 0:
					System.out.println("Program Exited Successfully");
					System.exit(0);
				case 1:
					
					int decimalVal = takeIntegerInput(sc);
					System.out.println("\nHexaDecimal is : " + calc.toHexaDecimal(decimalVal));
					break;
				case 2:
					num1 = takeHexaInput(sc);
					System.out.println("\nDecimal value is : " + calc.toDecimal(num1));
					break;
				case 3:
					num1 = takeHexaInput(sc);
					num2 = takeHexaInput(sc);
					System.out.println("\nAddition is : " + calc.hexAdd(num1, num2));
					break;
				case 4:
					num1 = takeHexaInput(sc);
					num2 = takeHexaInput(sc);
					System.out.println("\nSubtraction is : " + calc.hexSubtract(num1, num2));
					break;
				case 5:
					num1 = takeHexaInput(sc);
					num2 = takeHexaInput(sc);
					System.out.println("\nMultiplication is : " + calc.hexMultiply(num1, num2));
					break;
				case 6:
					num1 = takeHexaInput(sc);
					num2 = takeHexaInput(sc);
					System.out.println("\nDivision is : " + calc.hexDivide(num1, num2));
					break;
				case 7:
					num1 = takeHexaInput(sc);
					num2 = takeHexaInput(sc);
					if (calc.areEqual(num1, num2)) {
						System.out.println(num1 + " and "+ num2 + "are equal");
					}
					else if(calc.isGreater(num1, num2)) {
						System.out.println(num1 + " is greater than " +num2 );
					}
					else {
						System.out.println(num2 + " is greater than " +num1 );
					}
					break;
				default:
					System.out.println("You Entered an Invalid Choice");
					break;
				}
			} 
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

			System.out.print("\n \nPress Enter to continue...");
			sc.nextLine();
			sc.nextLine();

		}

	}
}
