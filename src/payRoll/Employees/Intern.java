package payRoll.Employees;

import payRoll.organisation.Metacube;

/**
 * 
 * class: "Intern"
 * desc : "This class represent intern type employee"
 * @author Kushal
 *
 */
public class Intern extends Employee {

	final double BONUS = 5000;
	final String TYPE = "Internship";
	final double COMPENSATION = 800;
	
	/**
	 * Constructor to initialize all variables
	 * 
	 */
	public Intern(String name, String post ,double baseSalary) {
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
	 * 
	 * Getter for basic salary
	 * 
	 */
	public double getBasicSalary() {
		return this.baseSalary;
	}
	
	/**
	 * Getter for bonus
	 * 
	 */
	public double getBonus() {
		return this.BONUS;
	}
	
	/**
	 * Getter for compensation
	 */
	public double getCompensation() {
		return this.COMPENSATION;
	}
	
	/**
	 * 
	 * Getter for basic info of an employee
	 */
	public String getBasicInfo() {
		return name + "\t"+ post + "\t" + TYPE;
	}
	
	/**
	 * It returns the total income of an employee 
	 * 
	 */
	public double getIncome() {
		return  baseSalary+BONUS+ COMPENSATION;
	}
}
