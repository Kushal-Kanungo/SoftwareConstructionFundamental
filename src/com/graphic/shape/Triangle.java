package com.graphic.shape;

import java.text.DecimalFormat;
import java.util.ArrayList;

import com.graphic.point.Point;

/**
 * class : Triangle desc : This class represent a triangle which have its
 * dimensions
 * 
 * @author Kushal
 * @since 28 OCT 2022 12:00 AM
 *
 */
public class Triangle implements Shape {

	private final double HALF = 0.5;
	private final double TWO = 2;
	DecimalFormat decfor = new DecimalFormat("0.00");
	private double base;
	private double height;
	private double[] origin;

	/**
	 * Constructor methods for initialize a triangle object
	 * 
	 * @param radius
	 * @param pointer
	 */
	public Triangle(ArrayList<Double> shapeArguments, Point pointer) {
		if (shapeArguments.size() != 2)
			throw new IllegalArgumentException("Enter Valid Number of Arguments");

		for (Double element : shapeArguments) {
			if (element <= 0)
				throw new IllegalArgumentException("Arguments cannot be empty");
		}

		this.base = shapeArguments.get(0);
		this.height = shapeArguments.get(1);
		this.origin = pointer.getPoint();
	}

	/**
	 * gives name of the shape
	 * 
	 * @return String
	 */
	public String getShapeName() {
		return "Triangle";
	}

	/**
	 * This is an override method to find area of the shape.
	 * 
	 * @return area
	 */
	@Override
	public double getArea() {
		DecimalFormat decfor = new DecimalFormat("0.00");
		return Double.parseDouble(decfor.format(HALF * base * height));
	}

	/**
	 * This is an override method to find perimeter of the shape.
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		double sides = Math.sqrt((base * HALF) * (base * HALF) + height * height);

		
		return Shape.round(TWO * sides + base);
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
		double x = point[0];
		double y = point[1];

		double x1 = origin[0];
		double y1 = origin[1];

		double x2 = origin[0] + base;
		double y2 = origin[1];

		double x3 = origin[0] + base * HALF;
		double y3 = origin[1] + height;

		double A = Utility.findTriangleArea(x1, y1, x2, y2, x3, y3);

		double A1 = Utility.findTriangleArea(x, y, x2, y2, x3, y3);

		double A2 = Utility.findTriangleArea(x1, y1, x, y, x3, y3);

		double A3 = Utility.findTriangleArea(x1, y1, x2, y2, x, y);

		return (A == A1 + A2 + A3);

	}

	/**
	 * 
	 * Getter for extreme points of the shape
	 */
	@Override
	public double[] getExtremePointes() {
		double end[] = new double[2];
		end[0] = origin[0] + base;
		end[1] = origin[1] + height;
		return end;
	}

	/**
	 * This method returns some basic info of shape
	 * 
	 */
	@Override
	public String getShapeInfo() {
		return "TRIANGLE x:" + origin[0] + " y:" + origin[1];
	}

}
