package payRoll.Employees;


/**
 * class : "Employee"
 * desc : "This is an abstract class for employee "
 * 
 * @author Kushal
 * @since 27 OCT 2022 11:00 AM
 */
public abstract class Employee {

	
	protected int id;
	protected String name;
	protected  String post;
	protected double baseSalary;
	protected double bonus;
	protected double compensation;
	protected boolean active;
	protected String department = "NONE";
	
	public abstract double getBasicSalary();
	public abstract double getBonus();
	public abstract double getCompensation();
	public abstract String getBasicInfo();

	/**
	 * Getter for ID
	 * @return
	 */
	public int getID() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	/**
	 * Getter for Total Income
	 * 
	 * @return
	 */
	public double getIncome() {
		return baseSalary+getBonus()+compensation;
	}
	
	/**
	 * It used to change active status of employee
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}
	
	/**
	 * Getter for active status
	 * 
	 * @return
	 */
	public boolean getActive() {
		return this.active;
	}
	
	/**
	 * It return the name of department
	 * 
	 * @return
	 */
	public String getDepartment() {
		return department;
	}
	
	
	
	public int getId() {
		return id;
	}
	public String getPost() {
		return post;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	/**
	 * It sets the department of an employee
	 * 
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * 
	 * 	This function will check equality between two employees
	 *	@param obj
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
	
	
}
