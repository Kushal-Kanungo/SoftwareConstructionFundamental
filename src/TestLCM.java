import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestLCM {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(8, 2, 8), 
				Arguments.of(15, 3, 15),
				Arguments.of(20, 100, 100),
				Arguments.of(1, 100, 100), 
				Arguments.of(63, 21, 63), 
				Arguments.of(1, 1, 1),
				Arguments.of(6, 5, 30),
				Arguments.of(3, 4, 12), 
				Arguments.of(0, 12, 0));
	}

	@ParameterizedTest
	@MethodSource
	public void object(int firstNum, int secondNum, int expected) {
		int result = MathOperation.calculateLCM(firstNum, secondNum);
		assertEquals(expected, result);
	}

	public void negativetTestCase() {
		assertThrows(InvalidParameterException.class, () -> {
			MathOperation.calculateLCM(-5, -2);
		});
	}

}
