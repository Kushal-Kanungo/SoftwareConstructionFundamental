package payRoll.Employees;


import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestGetSalary {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of("TOM","SDE 1",20000, 20000),
				Arguments.of("Kunal","SDE 2" ,18000, 18000),
				Arguments.of("Ram", "SDE 3" ,40000, 40000),
				Arguments.of("Shayam", "QA Tester" ,56000, 56000),
				Arguments.of("Rahul", "System Designer" ,67000, 67000)
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(String name, String post ,double salary, double expected) {
		
		Employee newEmployee = new FullTime(name,post ,salary);
		assertEquals(expected, newEmployee.getBasicSalary());
		
	}
	
	@Test
	public void invalidSalaryTest() {
		assertThrows(IllegalArgumentException.class, ()->{
			Employee newEmployee = new Intern("RAM", "Traniee", -200);
			newEmployee.getBasicInfo();
		});
	}

}
