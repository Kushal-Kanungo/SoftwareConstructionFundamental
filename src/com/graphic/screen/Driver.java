package com.graphic.screen;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.graphic.point.Point;
import com.graphic.shape.Shape.ShapeType;
import com.graphic.shape.Shape;
import com.graphic.shape.ShapeFactory;

public class Driver {

	public static void main(String[] args) {

		Screen screen = new Screen(100, 100);
		
		screen.addShape(ShapeFactory.createShape(ShapeType.CIRCLE, new Point(5, 6), new ArrayList<>(Arrays.asList(7d))));
		

		
		screen.listAllShapes();

	}
}
