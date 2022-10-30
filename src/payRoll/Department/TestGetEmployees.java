package payRoll.Department;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import payRoll.Employees.Employee;
import payRoll.Employees.FullTime;
import payRoll.Employees.Intern;
import payRoll.Employees.PartTime;

class TestGetEmployees {

	@Test
	void testGetEmployee() {
		
		Employee emp1 = new FullTime("Kushal", "Developer", 10000);
		Employee emp2 = new FullTime("TOM", "Developer", 20000);
		Employee emp3 = new Intern("Andrew", "Tester", 5000);
		Employee emp4 = new FullTime("Suresh"," Manager" ,20000);
		Employee emp5 = new FullTime("Manish", "QA Tester", 7000);
		Employee emp6 = new PartTime("Ramesh", "Android DEV", 20000);
		Employee emp7 = new PartTime("Manish", "QA Tester", 7000);
		
		Department it = new ITDepartment();
		it.join(emp1);
		it.join(emp2);
		it.join(emp3);
		it.join(emp4);
		it.join(emp5);
		it.join(emp6);
		it.join(emp7);
		
		String result[] = new String[] {"Kushal", "TOM", "Andrew", "Suresh", "Manish", "Ramesh", "Manish"};
		
		assertArrayEquals(result, it.getEmployeesName());
		
	}

}
