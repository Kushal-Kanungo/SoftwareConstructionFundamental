package payRoll.Department;

import java.util.ArrayList;

import payRoll.Employees.Employee;


/**
 * 
 * class:  ITDepartment Extended from Department  
 * @author Kushal
 * @since 27 OCT 2022 3:00 PM
 */
public class ITDepartment extends Department {

	final String DEPARTMENT = "IT Department";

	/**
	 * Constructor to initialize employee list
	 * 
	 */
	public ITDepartment() {
		this.employees = new ArrayList<Employee>();
	}

	/**
	 * This function will return the Department name.
	 * 
	 */
	@Override
	public String getDepartmentName() {
		return DEPARTMENT;
	}
}
