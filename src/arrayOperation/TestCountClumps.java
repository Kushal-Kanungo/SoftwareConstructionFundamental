package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TestCountClumps {


	@Test
	void test1() {
		int[] parameter = {1, 2, 2, 3, 4, 4};
		int result = ArrayOperations.countClumps(parameter);
		assertEquals(2, result);
	}
	
	@Test
	void test2() {
		int[] parameter = {1, 1, 2, 1, 1};
		int result = ArrayOperations.countClumps(parameter);
		assertEquals(2, result);
	}
	@Test
	void test3() {
		int[] parameter = {1, 1, 1, 1, 1};
		int result = ArrayOperations.countClumps(parameter);
		assertEquals(1, result);
	}

	@Test
	void test4() {
		int[] parameter = {-1,-1,2,-5,-5};
		int result = ArrayOperations.countClumps(parameter);
		assertEquals(2, result);
	}
	
	@Test
	void test5() {
		int[] parameter = new int[] {};
		assertThrows(InvalidParameterException.class, ()->{
			ArrayOperations.countClumps(parameter); 
		});
		
}
}
