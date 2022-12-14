package com.graphic.shape;

import java.util.ArrayList;

import com.graphic.point.Point;
import com.graphic.screen.Screen;

/**
 * class : Rectangle desc : This class represent a rectangle which have its
 * dimensions
 * 
 * @author Kushal
 * @since 28 OCT 2022 12:00 AM
 *
 */
public class Rectangle implements Shape {
	private final double TWO = 2;
	private double length;
	private double width;
	private double[] origin;
	double end[] = new double[2];

	/**
	 * Constructor methods for initialize a rectangle object
	 * 
	 * @param radius
	 * @param pointer
	 */
	public Rectangle(ArrayList<Double> shapeArguments, Point pointer) {
		if (shapeArguments.size() != 2)
			throw new IllegalArgumentException("Enter Valid Number of Arguments");
		for (Double element : shapeArguments) {
			if (element <= 0)
				throw new IllegalArgumentException("Arguments cannot be empty");
		}
		this.length = shapeArguments.get(0);
		this.width = shapeArguments.get(1);
		this.origin = pointer.getPoint();
		end[0] = origin[0] + width;
		end[1] = origin[1] + length;
	}

	/**
	 * gives name of the shape
	 * 
	 * @return String
	 */
	public String getShapeName() {
		return "Rectangle";
	}

	/**
	 * This is an override method to find area of the shape.
	 * 
	 * @return area
	 */
	@Override
	public double getArea() {
		return Utility.round(length * width);
	}

	/**
	 * This is an override method to find perimeter of the shape.
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		return Utility.round(TWO*(length+ width));
	}

	/**
	 * Getter for origin coordinate
	 * 
	 */
	@Override
	public double[] getOrigin() {
		return origin;
	}

	/**
	 * This method is used to find a point is enclosed in the shape or not
	 * 
	 * @param point
	 */
	@Override
	public boolean isPointEnclosed(double[] point) {
		if (point[0] > end[0] || point[0] < origin[0] || point[1] > end[1] || point[1] < origin[1])
			return false;
		return true;
	}

	/**
	 * 
	 * Getter for extreme points of the shape
	 */
	@Override
	public double[] getExtremePointes() {
		return end;
	}

	/**
	 * This method returns some basic info of shape
	 * 
	 */
	@Override
	public String getShapeInfo() {

		return "RECTANGLE x:" + origin[0] + " y:" + origin[1];
	}
}
