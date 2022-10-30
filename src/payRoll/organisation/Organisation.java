package payRoll.organisation;

import java.util.List;

import payRoll.Department.Department;
import payRoll.Employees.Employee;

/**
 * class : "Organisation"
 * desc : This is an abstract class represents an organisation 
 * 
 * @author Kushal
 * @since 27 OCT 2022 4:30 
 *
 */
public abstract class Organisation {

	protected String orgName;
	protected List<Department> departments;
	
	/**
	 * 
	 * @param newDepartment
	 * @return
	 */
	public abstract boolean addDepartment(Department newDepartment);
	
	/**
	 * 
	 * @return
	 */
	public abstract List<Employee> getAllEmployee();
	
	/**
	 * 
	 */
	
}
