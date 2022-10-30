package payRoll.organisation;

import java.util.ArrayList;
import java.util.List;

import org.graalvm.compiler.phases.common.DeadCodeEliminationPhase;

import payRoll.Department.Department;
import payRoll.Employees.Employee;

/**
 * class : "Metacube"
 * desc : "This class is extended from organisation class this represent a particular company"
 * 
 * @author Kushal
 *
 */
public class Metacube extends Organisation {

	private static int currentID = 100;
	public final static String orgName = "Metacube";
	
	/**
	 * Constructor which initializes the department arraylist
	 * @param orgName
	 */
	public Metacube(String orgName) {
		this.departments = new ArrayList<Department>();
	}
	
	/**
	 * 
	 * This function will increase the employee id whenever a new employee joins.
	 */
	public static void newEmployeeAdded() {
		currentID++;
	}
	
	/**
	 * It returns the current ID of new employee
	 * @return
	 */
	public static int getCurrentID() {
		return currentID;
	}
	
	
	/**
	 * To add new department we add first check the organisation if it exists and if ot we adds it. 
	 * 
	 * @param newDepartment
	 */
	public boolean addDepartment(Department newDepartment) {
		for (Department department : departments) {
			if(department.getDepartmentName() == newDepartment.getDepartmentName())
				return false;
		}
		departments.add(newDepartment);
		return true;
	}
	
	
	public void check() {
		departments.get(0).get
	}
	
	/**
	 * This methods return all the employee in an organisation by traversing each department arraylist of employee.
	 * 
	 */
	public List<Employee> getAllEmployee(){
		List<Employee> allEmployees = new ArrayList<Employee>();
		for (Department department : departments) {
			for (Employee employee : department.getEmployees()) {
				allEmployees.add(employee);
			}
		}
//		for (Department department : departments) {
//			data.add(department.getDepartmentName(), department.getEmployees())
//		}
		return allEmployees;
	}
	
	
	
}
