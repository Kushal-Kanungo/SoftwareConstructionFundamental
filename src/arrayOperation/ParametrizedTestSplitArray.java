package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class ParametrizedTestSplitArray {

	public static Stream<Arguments> testSplitArray() {
		return Stream.of(
				Arguments.of(new int[] { 1, 1, 1, 1 }, 2), 
				Arguments.of(new int[] { 0, 0, 0, 0 }, 1),
				Arguments.of(new int[] { 1, 2, 8 }, -1), 
				Arguments.of(new int[] { 1, 4, 5, 2, 1, 7 }, 3),
				Arguments.of(new int[] { 1,1,-1,-1 }, -1));
	}

	@ParameterizedTest
	@MethodSource
	public void testSplitArray(int arr[], int excepted) {
		int result = ArrayOperations.splitArray(arr);
		assertEquals(excepted, result);

	}

}
