package com.polynomial;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestEvaluate {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(new double[] { 1, 2, 3, 4 }, 1, 10.0),
				Arguments.of(new double[] { 20, 56, 23, -84 }, 0, 20.0),
				Arguments.of(new double[] { -23, -56, 78 }, 3, 511.0),
				Arguments.of(new double[] { -2, 0, 5, 0, -1 }, 8, -3778.0),
				Arguments.of(new double[] { 0, 0, 0 }, 0, 0.0)
				);
	}

	@ParameterizedTest
	@MethodSource
	public void object(double[] equationArray, double varValue, double expected) {
		Polynomial polyEquation = new Polynomial(equationArray);
		double result = polyEquation.evaluateEquation(varValue);
		assertEquals(expected, result);

	}

}
