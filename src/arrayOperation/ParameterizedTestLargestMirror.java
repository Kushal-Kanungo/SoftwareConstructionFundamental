package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParameterizedTestLargestMirror {

	public static Stream<Arguments> testLargestMirror() {
		return Stream.of(
				Arguments.of(new int[] {1, 4, 1, 5, 5, 4, 1},3),
				Arguments.of(new int[] {7, 1, 4, 9, 7, 4, 1},2),
				Arguments.of(new int[] {1, 2, 1, 4},3),
				Arguments.of(new int[] {1, 4, 5, 3, 5, -4, -1},3)	
				);
	}

	@ParameterizedTest
	@MethodSource
	public void testLargestMirror(int arr[], int excepted) {
		int result = ArrayOperations.largestMirror(arr);
		assertEquals(excepted, result);
		
	}
}
