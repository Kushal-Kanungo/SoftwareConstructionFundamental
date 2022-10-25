package areaCalc;

import java.util.Scanner;

public class AreaDriverCode {

	public static void displayMenu() {
		System.out.println("Select Option ");
		System.out.println("1 => Find Area of Triangle.");
		System.out.println("2 => Find Area of Square.");
		System.out.println("3 => Find Area of Rectangle.");
		System.out.println("4 => Find Area of Circle.");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		loop:
		while (true) {
			try {
				displayMenu();
				System.out.print("Select option");
				int option = sc.nextInt();
				switch (option) {
				case 1:
					System.out.print("Enter Height of Triangle :");
					double height = sc.nextDouble();
					System.out.print("Enter Base of Triangle :");
					double base = sc.nextDouble();
					System.out.println("Area of Triangle is : " + AreaCalculator.calculateTriangleArea(height, base));
					break;
				case 2:
					System.out.print("Enter Side of Square:");
					double side = sc.nextDouble();
					System.out.println("Area of Square is : " + AreaCalculator.calculateSquareArea(side));
					break;
				case 3:
					System.out.print("Enter Length of Rectangle :");
					double length = sc.nextDouble();
					System.out.print("Enter Width of Rectangle :");
					double width = sc.nextDouble();
					System.out
							.println("Area of Rectangle is : " + AreaCalculator.calculateRectangleArea(length, width));
					break;
				case 4:
					System.out.print("Enter Radius of Circle:");
					double radius = sc.nextDouble();
					System.out.println("Area of Square is : " + AreaCalculator.calculateCircleArea(radius));
					break;
				default:
					break loop;
				}
			} catch (ArithmeticException e) {
				System.out.println("Arithmatic Exception");
			}

			System.out.println("Press Enter To Continue");
			sc.nextLine();
			sc.nextLine();
		}

		sc.close();
	}

}
