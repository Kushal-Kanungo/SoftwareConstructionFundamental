package payRoll.Department;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import payRoll.Employees.Employee;
import payRoll.Employees.FullTime;
import payRoll.Employees.Intern;
import payRoll.Employees.PartTime;
class TestJoin {

	public static Stream<Arguments> object() {
		Employee emp1 = new FullTime("Kushal", "Developer", 10000);
		Employee emp2 = new FullTime("TOM", "Developer", 20000);
		Employee emp3 = new Intern("Andrew", "Tester", 5000);
		Employee emp4 = new FullTime("Suresh"," Manager" ,20000);
		Employee emp5 = new FullTime("Manish", "QA Tester", 7000);
		Employee emp6 = new PartTime("Ramesh", "Android DEV", 20000);
		Employee emp7 = new PartTime("Manish", "QA Tester", 7000);
		
		
		return Stream.of(
				Arguments.of(emp1, true),
				Arguments.of(emp2, true),
				Arguments.of(emp2, false),
				Arguments.of(emp3, true),
				Arguments.of(emp4, true),
				Arguments.of(emp4, false),
				Arguments.of(emp5, true),
				Arguments.of(emp6, true),
				Arguments.of(emp7, true),
				Arguments.of(emp6, false)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(Employee emp ,boolean target) {
		Department it = new ITDepartment();
		assertEquals(target, it.join(emp));

		
	}

}
