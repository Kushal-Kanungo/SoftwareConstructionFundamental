package com.polynomial;

import java.util.ArrayList;

/**
 * class : "PolyEquation"
 * desc : This class keeps list of list of objects of PolyElement and perform different actions
 * 
 * @author Kushal
 * @since 21 Oct 2022 01:00 PM
 *
 */
public class PolyEquation {

	private PolyElement[] equation;
	private int degree;

	/**
	 * desc : constructor for PolyEquation class takes degree and 2D Array and initialize variables
	 * 
	 * @param highestDegree
	 * @param coefficientAndPowers
	 */
	public PolyEquation(int highestDegree, ArrayList<ArrayList<Integer>> coefficientAndPowers) {
		equation = new PolyElement[highestDegree];
		degree = highestDegree;
		for (ArrayList<Integer> element : coefficientAndPowers) {
			PolyElement newElement = new PolyElement(element.get(0), element.get(1));
			if (equation[element.get(1)] == null)
				equation[element.get(1)] = newElement;
			else
				equation[element.get(1)] = newElement.addElement(equation[element.get(1)]);
		}
	}

	/**
	 * desc : It just prints the the polynomial in equation string
	 * 
	 */
	public void printEquation() {
		for (PolyElement polyElement : equation) {
			if (polyElement != null)
				System.out.print(polyElement.getCoefficient() + "x^" + polyElement.getPower() + " ");
		}
	}

	/**
	 * desc : to evaluate the value we use PolyElement method and call it for every obj in list
	 * 
	 * @param variableValue
	 * @return
	 */
	public double evaluateEquation(double variableValue) {
		double evaluatedValue = 0;
		for (PolyElement polyElement : equation) {
			if (polyElement != null)
				evaluatedValue += polyElement.calculateValue(variableValue);
		}
		return evaluatedValue;
	}

	/**
	 * desc : To add equation we used PolyElement add method for every obj in list
	 * 
	 * @param secondEquation
	 * @return
	 */
	public PolyEquation addEquation(PolyEquation secondEquation) {
		ArrayList<ArrayList<Integer>> newEquationValues = new ArrayList<ArrayList<Integer>>();
		for (PolyElement firstPolyElement : equation) {
			for (PolyElement secondPolyElement : secondEquation.getEquation()) {
				if (firstPolyElement != null && secondPolyElement != null
						&& firstPolyElement.getPower() == secondPolyElement.getPower()) {
					PolyElement added = firstPolyElement.addElement(secondPolyElement);
					ArrayList<Integer> polyElementValues = new ArrayList<Integer>();

					polyElementValues.add(added.getCoefficient());
					polyElementValues.add(added.getPower());

					newEquationValues.add(polyElementValues);
				}
			}
		}
		int newDegree = Math.max(degree, secondEquation.getDegree());
		return new PolyEquation(newDegree, newEquationValues);
	}

	/**
	 * desc : To multiply equation we used PolyElement multiply method for every obj in list
	 * 
	 * @param secondEquation
	 * @return
	 */
	public PolyEquation multiplyEquation(PolyEquation secondEquation) {
		ArrayList<ArrayList<Integer>> newEquationValues = new ArrayList<ArrayList<Integer>>();
		for (PolyElement firstPolyElement : equation) {
			for (PolyElement secondPolyElement : secondEquation.getEquation()) {
				if (firstPolyElement != null && secondPolyElement != null) {
					PolyElement added = firstPolyElement.multiply(secondPolyElement);
					ArrayList<Integer> polyElementValues = new ArrayList<Integer>();

					polyElementValues.add(added.getCoefficient());
					polyElementValues.add(added.getPower());

					newEquationValues.add(polyElementValues);
				}
			}
		}
		int newDegree = degree + secondEquation.getDegree();
		return new PolyEquation(newDegree, newEquationValues);
	}

	/**
	 * Getter function for equation 
	 * 
	 * @return
	 */
	public PolyElement[] getEquation() {
		return equation;
	}

	/**
	 * Getter function for degree 
	 *  
	 * @return
	 */
	public int getDegree() {
		return degree;
	}
	
	

}
