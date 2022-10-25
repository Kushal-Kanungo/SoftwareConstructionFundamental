package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TestLargetMirror {

	@Test
	void test1() {
		int[] parameter = {1, 4, 1, 5, 5, 4, 1};
		int result = ArrayOperations.largestMirror(parameter);
		assertEquals(3, result);
	}
	
	@Test
	void test2() {
		int[] parameter = {7, 1, 4, 9, 7, 4, 1};
		int result = ArrayOperations.largestMirror(parameter);
		assertEquals(2, result);
	}
	@Test
	void test3() {
		int[] parameter = {1, 2, 1, 4};
		int result = ArrayOperations.largestMirror(parameter);
		assertEquals(3, result);
	}

	@Test
	void test4() {
		int[] parameter = {1, 4, 5, 3, 5, 4, 1};
		int result = ArrayOperations.largestMirror(parameter);
		assertEquals(7, result);
	}
	
	@Test
	void test5() {
		int[] parameter = new int[] {};
		assertThrows(InvalidParameterException.class, ()->{
			ArrayOperations.largestMirror(parameter); 
		});
		
	}

	@Test
	void test6() {
		int[] parameter = {1, 4, 5, 3, 5, -4, -1};
		int result = ArrayOperations.largestMirror(parameter);
		assertEquals(3, result);
	}
}

