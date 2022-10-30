package com.graphic.screen;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

import com.graphic.shape.Shape;
import com.graphic.shape.Utility;

/**
 * class : Screen
 * desc : This class represent a screen which have its dimensions.
 * 
 * @author Kushal
 * @since 28 OCT 2022 1:00 AM
 *
 */
public class Screen {

	private int ID = 0;
	private double XMAX;
	private double YMAX;
	private double XORIGIN;
	private double YORIGIN;
	private HashMap<Integer, Object[]> allShapes;

	
	

	/**
	 * Constructor for the screen to initialize the screen dimensions
	 * 
	 * @param XMAX
	 * @param YMAX
	 */
	public Screen(double XMAX, double YMAX) {
		this.XMAX = XMAX;
		this.YMAX = YMAX;
		this.allShapes = new HashMap<Integer, Object[]>();
	}

	/**
	 * This function will add the shape in the list of shapes in the screen
	 * 
	 * @param newShape
	 * @return
	 */
	public int addShape(Shape newShape) {
		double[] extreme = newShape.getExtremePointes();
		double[] origin = newShape.getOrigin();
		if (extreme[0] >= XMAX || extreme[1] >= YMAX || origin[0] < XORIGIN || origin[1] < YORIGIN)
			throw new IllegalArgumentException("A part of this shape or whole shape is outside the screen");

		Object[] shapeData = new Object[] { newShape, Utility.getTimeStamp() };
		this.allShapes.put(ID, shapeData);
		return ID++;
	}

	/**
	 * This method will remove a shape from the screen
	 * 
	 * @param shapeID
	 * @return
	 */
	public boolean removeShape(int shapeID) {
		if (allShapes.get(shapeID) == null)
			return false;
		allShapes.remove(shapeID);
		return true;
	}

	/**
	 * This method will print all the shapes that enclosed a point
	 * 
	 * @param point
	 */
	public void getShapesEnclosedPoint(double[] point) {
		allShapes.forEach((id, shapeData) -> {
			if (((Shape) shapeData[0]).isPointEnclosed(point))
				System.out.println(id + "  " + ((Shape) shapeData[0]).getShapeInfo() + "\t" + (String) shapeData[1]);
		});
	}

	/**
	 * This method will list all the shapes present on the screen
	 * 
	 */
	public void listAllShapes() {
		allShapes.forEach((id, shapeData) -> {
			System.out.println(id + "  " + ((Shape) shapeData[0]).getShapeInfo() + "\t" + (String) shapeData[1]);
		});
	}

}
