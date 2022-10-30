package payRoll.salary;

import java.util.List;

import payRoll.Department.Department;
import payRoll.Department.HrDepartment;
import payRoll.Department.ITDepartment;
import payRoll.Employees.Employee;
import payRoll.Employees.FullTime;
import payRoll.Employees.Intern;
import payRoll.organisation.Metacube;
import payRoll.organisation.Organisation;

public class DriverTest {

	public static void printEmployees(List<Employee> employees) {
		for (Employee employee : employees) {
			System.out.println(employee.getName() + "\t" + employee.getPost());
		}
	}
	
	public static void main(String[] args) {
		Organisation metacube = new Metacube("Metacube");
		
		Employee emp1 = new FullTime("Tom", "Software Engineer", 10000);
		Employee emp2 = new FullTime("Cat", "System Designerss", 8000);
		Employee emp3 = new FullTime("Kushal", "Human Resource Manager", 8000);
		Employee emp4 = new Intern("Shubham", "Business Consultant", 6000);
		Employee emp5 = new Intern("Kunal", "Sales Manager Head", 9000);
		
		Department hr = new HrDepartment();
		
		Department it = new ITDepartment();
		
	
		
		
		metacube.addDepartment(hr);
		metacube.addDepartment(it);
		
		Employee emp9 = new FullTime("Kushal", "System Designerss", 8000);
		hr.join(emp9);
		
		
		System.out.println(hr.join(emp4));
		System.out.println(hr.join(emp3));
		System.out.println(hr.join(emp2));
		System.out.println(hr.join(emp1));
		System.out.println(it.join(emp1));
		System.out.println(hr.join(emp5));
//		System.out.println(hr.relieve(emp1));
		System.out.println(it.join(emp1));
		
		
		Payroll.printPayRoll(metacube);
	}
	
		
	
	
	
	
}
