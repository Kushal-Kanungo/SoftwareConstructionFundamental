package com.polynomial;

/**
 * class : "PolyElement"
 * desc : This class includes coefficient and power and perform different actions
 * 
 * @author Kushal
 * @since 21 Oct 2022 10:00 AM
 *
 */
public final class PolyElement {

	private final int coefficient;
	private final int power;
	
	/**
	 * Constructor it will initialize the coefficient and power of that element
	 * 
	 * @param coefficient
	 * @param power
	 */
	public PolyElement(int coefficient, int power) {
		super();
		this.coefficient = coefficient;
		this.power = power;
	}
	
	/**
	 * desc : If powers are same then we add the coefficient and return new element
	 * 
	 * @param secondPolyElement
	 * @return
	 */
	public PolyElement addElement(PolyElement secondPolyElement) {
		if (power == secondPolyElement.getPower()) {
			return new PolyElement(coefficient + secondPolyElement.getCoefficient() , power);
		}
		return null;
	}
	
	/**
	 * desc : To evaluate the value we calculate using the given variable value 
	 * 
	 * @param varValue	
	 * @return calculated value
	 */
	public double calculateValue(double varValue) {
		return Math.pow(varValue, power)*coefficient;
	}
	
	/**
	 * desc : To Multiply two element we multiply coefficient and add powers and return new element
	 * 
	 * @param secondPolyElement
	 * @return
	 */
	public PolyElement multiply(PolyElement secondPolyElement) {
		return new PolyElement(coefficient*secondPolyElement.getCoefficient(), power+secondPolyElement.getPower());
	}

	/**
	 * Getter for coefficient
	 * 
	 * @return coefficient
	 */
	public int getCoefficient() {
		return coefficient;
	}

	/**
	 * Getter for power of element 
	 * 
	 * @return power
	 */
	public int getPower() {
		return power;
	}
}
