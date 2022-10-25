package com.polynomial;

/**
 * class : "Polynomial"
 * desc : This class implements the calculations of single variable polynomial equations
 * 
 * @author Kushal
 * @since 21 Oct 2022 3:00 PM
 *
 */
public class Polynomial {

	private final double[] equation;
	private final int degree;

	/**
	 * Constructor for Polynomial class takes an array of double elements where index represents power 
	 * value represents coefficient
	 * @param equationArray
	 */
	public Polynomial(double[] equationArray) {
		this.equation = equationArray;
		this.degree = equation.length - 1;
	}

	/**
	 * Another constructor takes 2d array where first column represent coefficient and second power
	 * 
	 * @param equationValues
	 * @param degree
	 */
	public Polynomial(double[][] equationValues, int degree) {
		double[] tempEquation = new double[degree + 1];
		this.degree = degree;
		for (double[] coeff_power : equationValues) {
			tempEquation[(int) coeff_power[1]] += coeff_power[0];
		}
		this.equation = tempEquation;
	}

	/**
	 * To evaluate a equation we find power of value and multiply by coefficient
	 * 
	 * @param varValue
	 * @return
	 */
	public double evaluateEquation(double varValue) {
		double evaluatedValue = 0;
		for (int power = 0; power <= degree; power++) {
			evaluatedValue += Math.pow(varValue, power) * equation[power];
		}
		return evaluatedValue;
	}

	/**
	 * To add a equation to another we add coefficient of same power
	 * 
	 * @param secondEquation
	 * @return
	 */
	public Polynomial addEquation(Polynomial secondEquation) {
		int newDegree = Math.max(this.degree, secondEquation.getDegree());
		double newEquationArray[] = new double[newDegree+1];
		for (int power = 0; power <= newDegree; power++) {
			if (power <= this.degree)
				newEquationArray[power]+=equation[power];
			if (power <= secondEquation.getDegree())
				newEquationArray[power]+=secondEquation.getEquation()[power];
		}
		return new Polynomial(newEquationArray);
	}
	
	/**
	 * To multiply element we add power and multiply coefficient
	 * 
	 * @param secondEquation
	 * @return
	 */
	public Polynomial multiplyEquation(Polynomial secondEquation) {
		int newDegree = this.degree+secondEquation.getDegree() + 1;
		double[] secondEquationArray = secondEquation.getEquation();
		double[] newEquationArray =  new double[newDegree];
		for(int firstPower = 0; firstPower < this.equation.length; firstPower++ ) {
			for(int secondPower = 0; secondPower<secondEquationArray.length; secondPower++) {
				newEquationArray[firstPower+secondPower] += this.equation[firstPower]*secondEquationArray[secondPower];
			}
		}
		return new Polynomial(newEquationArray);
	}
	
	/**
	 * This function will represent the object as a string equation
	 * 
	 */
	public String toString() {
		String stringEquation = "";
		for (int power = 0; power < equation.length; power++) {
			double coefficient = equation[power];
			if (coefficient!=0)
				stringEquation+= coefficient+"x^"+power+" ";
		}
		return stringEquation;
	}
	
	/**
	 * Getter for equation array
	 * 
	 * @return
	 */
	public double[] getEquation() {
		return equation;
	}

	/**
	 * Getter from degree of the equation
	 * 
	 * @return
	 */
	public int getDegree() {
		return degree;
	}


}
