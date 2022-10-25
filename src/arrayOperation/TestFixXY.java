package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class TestFixXY {
	

	@Test
	void test1() {
		int[] parameter = { 5, 4, 9, 4, 9, 5 };
		int[] excpected = {9, 4, 5, 4, 5, 9};
		int X = 4;
		int Y = 5;
		int[] result = ArrayOperations.fixXY(parameter,X,Y);
		assertArrayEquals(excpected, result);
	}
	
	@Test
	void test2() {
		int[] parameter = {1, 4, 1, 5};
		int[] excpected = {1, 4, 5, 1};
		int X = 4;
		int Y = 5;
		int[] result = ArrayOperations.fixXY(parameter,X,Y);
		assertArrayEquals(excpected, result);
	}
	
	@Test
	void test3() {
		int[] parameter = { 1, 4, 1, 5, 5, 4, 1};
		int[] excpected = {1, 4, 5, 1, 1, 4, 5};
		int X = 4;
		int Y = 5;
		int[] result = ArrayOperations.fixXY(parameter,X,Y);
		assertArrayEquals(excpected, result);
	}
	
	@Test
	void test4(){
		int[] parameter = { 1, 4, 1, 5, 5, 5, 1};
		int X = 4;
		int Y = 5;
		assertThrows(InvalidParameterException.class, ()->{
			ArrayOperations.fixXY(parameter, X, Y);
		});
	}
}
