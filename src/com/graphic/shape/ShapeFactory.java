package com.graphic.shape;

import java.util.ArrayList;

import com.graphic.point.Point;

/**
 * class : ShapeFactory
 * This class will act as a factory to create objects of common shapes.
 * 
 * @author Kushal
 *
 */
public class ShapeFactory {
    

	/**
	 * This function act as a factory to create object of common shapes and control the flow.
	 * 
	 * 
	 * @param shapeType
	 * @param pointer
	 * @param shapeArguments
	 * @return
	 */
    public static Shape createShape(Shape.ShapeType shapeType,Point pointer ,ArrayList<Double> shapeArguments){

        switch (shapeType) {
            case SQUARE:
                return new Square(shapeArguments, pointer);
            case CIRCLE:
            	return new Circle(shapeArguments, pointer);
            case RECTANGLE:
            	return new Rectangle(shapeArguments, pointer);
            case TRIANGLE:
            	return new Triangle(shapeArguments, pointer);
            case POLYGON:
            	return new Polygon(shapeArguments, pointer);
        
            default:
                break;
        }
        throw new IllegalArgumentException("Enter a valid shape");

    }

}
