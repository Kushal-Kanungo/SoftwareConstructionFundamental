package com.polynomial;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestAdd {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new double[] { 1, 2, 3 }, new double[] {1,2,3}, new double[] {2,4,6}),
				Arguments.of(new double[] { 1, 2, 3 }, new double[] {5,6,7,8}, new double[] {6,8,10,8}),
				Arguments.of(new double[] { 0, 0, 0 }, new double[] {-1, 0, -5}, new double[] {-1,0,-5}),
				Arguments.of(new double[] { -10, -49, -90 }, new double[] {-1, -1, 1}, new double[] {-11,-50,-89})
				);
	}

	@ParameterizedTest
	@MethodSource
	public void object(double[] firstArray, double[] secondArray, double[] expected) {
		Polynomial firstPolyEquation = new Polynomial(firstArray);
		Polynomial secondPolyEquation = new Polynomial(secondArray);
		double[] result = firstPolyEquation.addEquation(secondPolyEquation).getEquation();
		assertArrayEquals(expected, result);

	}

}
