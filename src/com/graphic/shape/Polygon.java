package com.graphic.shape;

import java.util.ArrayList;

import com.graphic.point.Point;

/**
 * class : Rectangle desc : This class represent a rectangle which have its
 * dimensions
 * 
 * @author Kushal
 * @since 28 OCT 2022 12:00 AM
 *
 */
public class Polygon implements Shape {
	private double sides;
	private double length;
	double origin[] = new double[2];
	double end[] = new double[2];

	/**
	 * Constructor methods for initialize a rectangle object
	 * 
	 * @param radius
	 * @param pointer
	 */
	public Polygon(ArrayList<Double> shapeArguments, Point pointer) {
		if (shapeArguments.size() != 2)
			throw new IllegalArgumentException("Enter Valid Number of Arguments");
		for (Double element : shapeArguments) {
			if (element <= 0)
				throw new IllegalArgumentException("Arguments cannot be empty");
		}
		this.sides = shapeArguments.get(0);
		this.length = shapeArguments.get(1);
		
		this.origin = pointer.getPoint();
		end[0] = origin[0] + length;
		end[1] = origin[1] + length;
	}

	/**
	 * gives name of the shape
	 * 
	 * @return String
	 */
	public String getShapeName() {
		return "Polygon";
	}

	/**
	 * This is an override method to find area of the shape.
	 * 
	 * @return area
	 */
	@Override
	public double getArea() {
		double area =  (double) ((sides * (length * length)) / (4.0 * Math.tan((Math.PI / sides))));
		return Utility.round(area);
	}

	/**
	 * This is an override method to find perimeter of the shape.
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		
		return Utility.round(sides*length);
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
		
		return false;
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

		return "Polygon x:" + origin[0] + " y:" + origin[1];
	}
}
