package com.graphic.screen;


import java.util.ArrayList;
import java.util.Arrays;

import com.graphic.point.Point;
import com.graphic.shape.Shape.ShapeType;
import com.graphic.shape.ShapeFactory;

public class Driver {
	
	

	public static void main(String[] args) {

		Screen screen = new Screen(1000, 1000);
		
		screen.addShape(ShapeFactory.createShape(ShapeType.CIRCLE, new Point(5, 6), new ArrayList<>(Arrays.asList(7d))));
		screen.addShape(ShapeFactory.createShape(ShapeType.POLYGON, new Point(5, 6), new ArrayList<>(Arrays.asList(7d,6d))));
		screen.addShape(ShapeFactory.createShape(ShapeType.SQUARE, new Point(7, 6), new ArrayList<>(Arrays.asList(8d))));
		screen.addShape(ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(8, 2), new ArrayList<>(Arrays.asList(9d,4d))));
		
		screen.listAllShapes(screen.sortShapes());
		
//		screen.listAllShapes();

	}
}
