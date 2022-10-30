package payRoll.Department;

import java.util.ArrayList;

import payRoll.Employees.Employee;


/**
 * 
 * class:  AdminDepartment Extended from Department  
 * @author Kushal
 * @since 27 OCT 2022 3:00 PM
 */
public class AdminDepartment extends Department {

	final String DEPARTMENT = "AD Department";

	/**
	 * Constructor to initialize employee list
	 * 
	 */
	public AdminDepartment() {
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
