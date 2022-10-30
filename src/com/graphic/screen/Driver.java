package com.graphic.screen;


import com.graphic.point.Point;
import com.graphic.shape.Shape.ShapeType;
import com.graphic.shape.Shape;
import com.graphic.shape.ShapeFactory;

public class Driver {

	public static void main(String[] args) {

		Screen screen = new Screen(100, 100);
		
		screen.addShape(ShapeFactory.createShape(ShapeType.CIRCLE, new Point(5, 6), 7));
		screen.addShape(ShapeFactory.createShape(ShapeType.CIRCLE, new Point(8, 10), 7));
		screen.addShape(ShapeFactory.createShape(ShapeType.SQUARE, new Point(10, 20), 10));
		screen.addShape(ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(50, 20), 8, 9));
		screen.addShape(ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(40, 67), 4, 9));

		
		screen.listAllShapes();

	}
}
