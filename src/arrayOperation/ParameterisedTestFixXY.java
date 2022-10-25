package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParameterisedTestFixXY {


	public static Stream<Arguments> testCountClumps() {
		return Stream.of(
				Arguments.of(new int[] { 5, 4, 9, 4, 9, 5 }, new int[] { 9, 4, 5, 4, 5, 9 }, 4, 5),
				Arguments.of(new int[] { 1, 4, 1, 5 }, new int[] { 1, 4, 5, 1 }, 4, 5),
				Arguments.of(new int[] { 1, 4, 1, 5, 5, 4, 1 }, new int[] { 1, 4, 5, 1, 1, 4, 5 }, 4, 5),
				Arguments.of(new int[] { 1, 4, 5, 4, 5 }, new int[] { 1, 4, 5, 4, 5 }, 4, 5));
	}

	@ParameterizedTest
	@MethodSource
	public void testCountClumps(int arr[], int[] excpected, int X, int Y) {
		int[] result = ArrayOperations.fixXY(arr,X,Y);
		assertArrayEquals(excpected, result);

	}

}
