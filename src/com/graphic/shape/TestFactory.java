package com.graphic.shape;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.graphic.screen.Screen;
import com.graphic.shape.Shape.ShapeType;


class TestFactory {
	
	public void test1() {
		

		Point ptr = new Point(3, 4);
		Shape shape = ShapeFactory.createShape(ShapeType.CIRCLE, ptr, 7d);
		assertEquals("Circle", shape.getShapeName());
	}

}
