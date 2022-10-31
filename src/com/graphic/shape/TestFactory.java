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
class TestFactory {

	public static Stream<Arguments> object() {
		return Stream.of(
				Arguments.of(ShapeType.CIRCLE, new Point(6,7), new ArrayList<>(Arrays.asList(7)), "Circle" ),
				Arguments.of(ShapeType.SQUARE, new Point(90,90), new ArrayList<>(Arrays.asList(4)), "Square" ),
				Arguments.of(ShapeType.RECTANGLE, new Point(70,40), new ArrayList<>(Arrays.asList(4,8)), "Rectangle" ),
				Arguments.of(ShapeType.TRIANGLE, new Point(34,96), new ArrayList<>(Arrays.asList(9,8)), "Triangle" ),
				Arguments.of(ShapeType.RECTANGLE, new Point(78,33), new ArrayList<>(Arrays.asList(4,5)), "Rectangle" ),
				Arguments.of(ShapeType.SQUARE, new Point(32,54), new ArrayList<>(Arrays.asList(10)), "Square" ),
				Arguments.of(ShapeType.CIRCLE, new Point(35,32), new ArrayList<>(Arrays.asList(45)), "Circle" )
				);
	}
	
	@ParameterizedTest
	@MethodSource
	public void object(ShapeType type, Point pointer, ArrayList<Double> list, String shapeName) {
		
		Shape shape = ShapeFactory.createShape(type, pointer, list);
		assertEquals(shapeName, shape.getShapeName());
		
	}
	
	@Test
	public void testInvalid() {
		assertThrows(IllegalArgumentException.class, ()->{
			Shape shape = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(5,6), new ArrayList<>(Arrays.asList(3d)));
			shape.getShapeName();
		});
	}

}
