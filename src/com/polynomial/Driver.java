package com.polynomial;


public class Driver {

	public static void main(String[] args) {

		Polynomial equation1 = new Polynomial(new double[] {-1});
		Polynomial equation2 = new Polynomial(new double[] {8,5,4,6,7,5,4});
		System.out.println(equation1.multiplyEquation(equation2));
		
	}
}
