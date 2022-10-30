package payRoll.salary;

import java.util.List;

import payRoll.Department.Department;
import payRoll.Employees.Employee;
import payRoll.organisation.Organisation;

/**
 * class : "Payroll" desc : this class have function to print payment slip of a
 * single employee or full organisation.
 * 
 * @author Kushal
 * @since 27 OCT 2022 5:00 PM
 *
 */
public class Payroll {

	/**
	 * It takes an organisation and traverse each employee and print salary slip.
	 * 
	 * @param organisation
	 */
	public static void printPayRoll(Organisation organisation) {
		List<Employee> allEmployees = organisation.getAllEmployee();
		if (allEmployees.size() == 0) {
			System.out.println("No Employees In Organisation");
			return;
		}
		System.out
				.println("Name\tEmployee Post \t \tEmployeeType \tDepartment \tBase Salary \tBonus \t\tCompensation \tTotal Salary");
		System.out.println(
				"===================================================================================================================");
		for (Employee employee : allEmployees) {
			printPayRoll(employee);
		}
		System.out.println(
				"===================================================================================================================");
	}

	/**
	 * It takes an department and traverse each employee and print salary slip.
	 * 
	 * @param organisation
	 */
	public static void printPayRoll(Department department) {
		List<Employee> allEmployees = department.getEmployees();
		if (allEmployees.size() == 0) {
			System.out.println("No Employees In Organisation");
			return;
		}
		System.out
				.println("Name\tEmployee Post \t \tEmployeeType \tDepartment \tBase Salary \tBonus \t\tCompensation \tTotal Salary");
		System.out.println(
				"===============================================================================================================");
		for (Employee employee : allEmployees) {
			printPayRoll(employee);
		}
		System.out.println(
				"===============================================================================================================");
	}

	/**
	 * It takes an employee ID and print payslip of that employee.
	 * 
	 * @param employee
	 */
	public static void printPayRoll(Employee employee) {

		System.out.println(employee.getBasicInfo() + "\t"+ employee.getDepartment()  +"\t" + employee.getBasicSalary() + "\t\t" + employee.getBonus()
				+ "\t\t" + employee.getCompensation() + "\t\t" + employee.getIncome());
	}
}
