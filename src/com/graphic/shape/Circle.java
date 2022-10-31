package com.graphic.shape;

import java.util.ArrayList;

import com.graphic.point.Point;

/**
 * class : Circle
 * desc : This class represent a circle which have its dimensions
 * 
 * @author Kushal
 * @since 28 OCT 2022 12:00 AM
 *
 */
public class Circle implements Shape{
    private final double PI = 3.14; 
    private final double TWO = 2;
    private double radius;
    private double[] origin;
    double end[] = new double[2];
   


    /**
     * Constructor methods for initialize a circle object
     * 
     * @param radius
     * @param pointer
     */
    public Circle(ArrayList<Double> shapeArguments, Point pointer) {
    	if (shapeArguments.size()!=1)
          throw new IllegalArgumentException("Enter Valid Number of Arguments");
    	for (Double element : shapeArguments) {
			if(element<=0)
				throw new IllegalArgumentException("Arguments cannot be empty");
		}
        this.radius = shapeArguments.get(0);
        this.origin = pointer.getPoint();
        end[0] = origin[0]+radius;
        end[1] = origin[1]+radius;
    }

    /**
     * gives name of the shape
     * 
     * @return String
     */
    public String getShapeName() {
		return "Circle";
	}

    /**
     * This is an override method to find area of the shape.
     * 
     * @return area
     */
    @Override
    public double getArea() {
        return PI*radius*radius;
    }

    /**
     * This is an override method to find perimeter of the shape.
     * 
     * @return perimeter
     */
    @Override
    public double getPerimeter() {
        return TWO*PI*radius;
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
        if (point[0] < origin[0]-radius || point[0] > origin[0]+radius || point[0] < origin[1]-radius || point[1] > origin[1]+radius)
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
		
		return "CIRCLE x:"+origin[0]+" y:"+origin[1];
	}
    
    


}
