package com.graphic.shape;

import java.util.ArrayList;

import com.graphic.point.Point;

/**
 * class : Square desc : This class represent a square which have its dimensions
 * 
 * @author Kushal
 * @since 28 OCT 2022 12:00 AM
 *
 */
public class Square implements Shape {
	private final double FOUR = 4;
	private double side;
	private double[] origin;
	double end[] = new double[2];

	/**
	 * Constructor methods for initialize a square object
	 * 
	 * @param radius
	 * @param pointer
	 */
	public Square(ArrayList<Double> shapeArguments, Point pointer) {
		if (shapeArguments.size() != 1)
			throw new IllegalArgumentException("Enter Valid Number of Arguments");

		for (Double element : shapeArguments) {
			if (element <= 0)
				throw new IllegalArgumentException("Arguments cannot be empty");
		}

		this.side = shapeArguments.get(0);
		this.origin = pointer.getPoint();
		end[0] = origin[0] + side;
		end[1] = origin[1] + side;
	}

	/**
	 * gives name of the shape
	 * 
	 * @return
	 */
	public String getShapeName() {
		return "Square";
	}

	/**
	 * This is an override method to find area of the shape.
	 * 
	 * @return area
	 */
	@Override
	public double getArea() {
		return side * side;
	}

	/**
	 * This is an override method to find perimeter of the shape.
	 * 
	 * @return perimeter
	 */
	@Override
	public double getPerimeter() {
		return FOUR * side;
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
	 * This method is used to find a point is enclosed in the shape or not
	 * 
	 * @param point
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

		return "SQUARE x:" + origin[0] + " y:" + origin[1];
	}
}
