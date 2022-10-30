package payRoll.Employees;

import payRoll.organisation.Metacube;

/**
 * class : "PartTime"
 * desc  : "This is a child class of Employee class it represents part time employee of an organisation." 
 * 
 * @author Kushal
 *
 */
public class PartTime extends Employee {
	
	final double BONUS = 10000;
	final String TYPE = "Part Time Employee";
	final double COMPENSATION = 1200;


	/**
	 * Constructor for the PartTime Class initializes all the values of an object 
	 * 
	 * @param name
	 * @param baseSalary
	 * @param compensation
	 */
	public PartTime(String name, String post ,double baseSalary) {
		if (baseSalary <= 0)
			throw new IllegalArgumentException("Salary Is Invalid");
		if (name.length()<=0 || post.length()<=0)
			throw new IllegalArgumentException("Enter Valid Input");
		this.id = Metacube.getCurrentID();
		Metacube.newEmployeeAdded();
		this.name = name;
		this.post = post;
		this.baseSalary = baseSalary;
	}

	/**
	 * Getter for basic salary
	 * 
	 * @return baseSalary
	 */
	public double getBasicSalary() {
		return this.baseSalary;
	}

	/**
	 * Getter for bonus
	 *
	 *	@return BONUS  
	 */
	public double getBonus() {
		return this.BONUS;
	}

	/**
	 * Getter for compensation
	 * 
	 * @return compensation
	 */
	public double getCompensation() {
		return this.COMPENSATION;
	}

	/**
	 * It gives the basic information of an employee
	 * 
	 */
	public String getBasicInfo() {
		return name + "\t"+ post + "\t" + TYPE;
	}

	
	/**
	 * It returns income of an employee by calculating all salary
	 * 
	 * @return income
	 */
	public double getIncome() {
		return this.baseSalary + BONUS + this.COMPENSATION;
	}
}
