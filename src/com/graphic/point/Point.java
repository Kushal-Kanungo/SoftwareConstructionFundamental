package com.graphic.point;

/**
 * class : "Point"
 * desc : this class represent a cursor on an screen.
 * 
 * @author Kushal
 * @since 28 OCT 2022 11:00 AM
 */
public class Point {
    private double xPoint;
    private double yPoint;
    
    /**
     * Constructor to initialize the coordinates
     * 
     * @param xPoint
     * @param yPoint
     */
    public Point(double xPoint, double yPoint) {
    	
    	if(xPoint < 0 || yPoint < 0)
    		throw new IllegalArgumentException("Pointer cannot be negative");
    	
    	   this.xPoint  = xPoint;
           this.yPoint = yPoint;
       }

    /**
     * Setter for coordinate
     * 
     * @param xPoint
     * @param yPoint
     */
    public void setPoint(double xPoint, double yPoint){
    	if(xPoint < 0 || yPoint < 0)
    		throw new IllegalArgumentException("Pointer cannot be negative");
        this.xPoint  = xPoint;
        this.yPoint = yPoint;
    }

    /**
     * Getter for coordinate
     * 
     * @return
     */
    public double[] getPoint(){
        return new double[] {this.xPoint, this.yPoint};
    }

}
