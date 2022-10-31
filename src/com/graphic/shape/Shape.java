package com.graphic.shape;

import java.text.DecimalFormat;

/**
 * interface :Shape
 * 
 * This interface is defining some common methods for the common shape.
 * @author Kushal
 *
 */
public interface Shape {
    
    public  double getArea();
    public  double getPerimeter();
    public  double[] getOrigin();
    public String getShapeInfo();
    public String getShapeName();
    public boolean isPointEnclosed(double[] point); 

    public static double round(double value) {
    	 DecimalFormat decfor = new DecimalFormat("0.00");
    	 return Double.parseDouble(decfor.format(value));
    }
   

    /**
     * This enum will define some common shapes
     * @author Kushal
     *
     */
    enum ShapeType {
        SQUARE,
        RECTANGLE,
        CIRCLE,
        TRIANGLE
    }



	double[] getExtremePointes();


}
