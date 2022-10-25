package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TestSplitArray {


	@Test
	void test1() {
		int[] parameter = {1, 1, 1, 2, 1};
		int result = ArrayOperations.splitArray(parameter);
		assertEquals(3, result);
	}
	
	@Test
	void test2() {
		int[] parameter = {2, 1, 1, 2, 1};
		int result = ArrayOperations.splitArray(parameter);
		assertEquals(-1, result);
	}
	
	@Test
	void test3() {
		int[] parameter = {10, 10};
		int result = ArrayOperations.splitArray(parameter);
		assertEquals(1, result);
	}

	@Test
	void test4() {
		int[] parameter = {0,0,0,0};
		int result = ArrayOperations.splitArray(parameter);
		assertEquals(1, result);
	}
	
	@Test
	void test5() {
		int[] parameter = new int[] {};
		assertThrows(InvalidParameterException.class, ()->{
			ArrayOperations.splitArray(parameter); 
		});
}
	@Test
	void test6() {
		int[] parameter = new int[] {-1,-1,2};
		assertThrows(InvalidParameterException.class, ()->{
			ArrayOperations.splitArray(parameter); 
		});
}
}
