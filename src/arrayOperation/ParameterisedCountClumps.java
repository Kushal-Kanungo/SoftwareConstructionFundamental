package arrayOperation;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class ParameterisedCountClumps {

	public static Stream<Arguments> testCountClumps() {
		return Stream.of(
				Arguments.of(new int[] {1,1,2,2,3,4},2),
				Arguments.of(new int[] {-1,-1,-1,-1,-2,-3},1),
				Arguments.of(new int[] {1, 2, 1, 4},0),
				Arguments.of(new int[] {2,2,2,2,3,4,5,6,6},2)	
				);
	}

	@ParameterizedTest
	@MethodSource
	public void testCountClumps(int arr[], int excepted) {
		int result = ArrayOperations.countClumps(arr);
		assertEquals(excepted, result);
		
	}
}


