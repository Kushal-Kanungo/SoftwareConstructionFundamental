package com.polynomial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestPolyMultiply {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new double[] { 1, 2, 3 }, new double[] {1,2,3}, new double[] {1,4,10,12,9}),
				Arguments.of(new double[] { 0,0,0 }, new double[] {1,2,3}, new double[] {0,0,0,0,0}),
				Arguments.of(new double[] { -5, -4, 2 }, new double[] {9, 6, -2}, new double[] {-45,-66,4,20,-4}),
				Arguments.of(new double[] { -1 }, new double[] {8,5,4,6,7,5,4}, new double[] {-8,-5,-4,-6,-7,-5,-4}),
				Arguments.of(new double[] { -1 }, new double[] {-1}, new double[] {1})
				);
	}

	@ParameterizedTest
	@MethodSource
	public void object(double[] firstArray, double[] secondArray, double[] expected) {
		Polynomial firstPolyEquation = new Polynomial(firstArray);
		Polynomial secondPolyEquation = new Polynomial(secondArray);
		double[] result = firstPolyEquation.multiplyEquation(secondPolyEquation).getEquation();
		Polynomial expectedPoly = new Polynomial(expected);
		assertArrayEquals(expectedPoly.getEquation(), result);

	}

}
