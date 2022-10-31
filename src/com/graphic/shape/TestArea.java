package com.graphic.shape;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



import com.graphic.point.Point;
import com.graphic.shape.Shape.ShapeType;

public class TestArea {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(ShapeType.CIRCLE, new Point(6,7), new ArrayList<>(Arrays.asList(7d)), 153.86d ),
				Arguments.of(ShapeType.SQUARE, new Point(90,90), new ArrayList<>(Arrays.asList(4d)), 16d ),
				Arguments.of(ShapeType.RECTANGLE, new Point(70,40), new ArrayList<>(Arrays.asList(4d,8d)), 32d ),
				Arguments.of(ShapeType.TRIANGLE, new Point(34,96), new ArrayList<>(Arrays.asList(8d,9d)), 36d )
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(ShapeType type, Point pointer, ArrayList<Double> list, double target) {
		
		Shape shape = ShapeFactory.createShape(type, pointer, list);
		assertEquals(target, shape.getArea());
	}
	
	@Test
	public void testNegative() {
		
		assertThrows(IllegalArgumentException.class, ()->{
			
			Shape shape = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(5,5),new ArrayList<Double>(Arrays.asList(-5d)));
		});
	}
	
}
