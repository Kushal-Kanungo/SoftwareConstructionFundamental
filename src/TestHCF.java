import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestHCF {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(5, 6, 1), 
				Arguments.of(2, 6, 2), 
				Arguments.of(20, 10, 10), 
				Arguments.of(7, 5, 1),
				Arguments.of(7, 0, 7), 
				Arguments.of(0, 0, 0));
	}

	@ParameterizedTest
	@MethodSource
	public void object(int firstNum, int secondNum, int ans) {
		int result = MathOperation.calculateHCF(firstNum, secondNum);
		assertEquals(ans, result);

	}

	public void negativetTestCase() {
		assertThrows(InvalidParameterException.class, () -> {
			MathOperation.calculateHCF(-3, -2);
		});
	}
}
