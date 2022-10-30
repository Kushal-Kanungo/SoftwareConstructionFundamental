package com.graphic.shape;

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
    public static Shape createShape(Shape.ShapeType shapeType,Point pointer ,double ... shapeArguments){

        switch (shapeType) {
            case SQUARE:
                return new Square(shapeArguments[0], pointer);
            case CIRCLE:
            	return new Circle(shapeArguments[0], pointer);
            case RECTANGLE:
            	return new Rectangle(shapeArguments[0], shapeArguments[1], pointer);
            case TRIANGLE:
            	return new Triangle(shapeArguments[0], shapeArguments[1], pointer);
        
            default:
                break;
        }
        throw new IllegalArgumentException("Enter a valid shape");

    }

}
