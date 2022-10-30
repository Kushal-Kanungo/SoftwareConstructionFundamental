package payRoll.Department;

import java.util.List;

import payRoll.Employees.Employee;

/**
 * class : "Department" desc : This is an abstract class. This class can be
 * extended to create new departments.
 * 
 * @author Kushal
 * @since 27 OCT 2022 2:30 PM
 *
 */
public abstract class Department {

	protected List<Employee> employees;

	public abstract String getDepartmentName();

	/**
	 * To add new employee we mark the active status as true
	 * 
	 * @param newEmployee
	 * @return
	 */
	public boolean join(Employee newEmployee) {

		if (newEmployee.getActive())
			return false;

		newEmployee.setActive(true);
		newEmployee.setDepartment(this.getDepartmentName());
		employees.add(newEmployee);
		return true;
	}

	/**
	 * To relieve the employee we remove from employee. And the active status as non active. 
	 * 
	 * @param newEmployee
	 * @return
	 */
	public boolean relieve(Employee newEmployee) {
		for (int idx = 0; idx < employees.size(); idx++) {
			if (newEmployee == employees.get(idx)) {
				employees.remove(idx);
				newEmployee.setActive(false);
				newEmployee.setDepartment("None");
				return true;
			}
		}
		return false;
	}
	
	public String[] getEmployeesName() {
		String[] names = new String[this.employees.size()];
		int idx=0;
		for (Employee employee : this.employees) {
			names[idx++] = employee.getName();
		}
		return names;
	}

	/**
	 * 
	 * Getter for employee list
	 * @return
	 */
	public List<Employee> getEmployees() {
		return employees;
	}

}
