package com.graphic.screen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.graphic.shape.Shape;

/**
 * class : Screen desc : This class represent a screen which have its
 * dimensions.
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
//	private HashMap<Integer, Object[]> allShapes;

	private List<Object[]> allshapes;

	/**
	 * Constructor for the screen to initialize the screen dimensions
	 * 
	 * @param XMAX
	 * @param YMAX
	 */
	public Screen(double XMAX, double YMAX) {
		this.XMAX = XMAX;
		this.YMAX = YMAX;
//		this.allShapes = new HashMap<Integer, Object[]>();
		this.allshapes = new ArrayList<Object[]>();
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

		Object[] shapeData = new Object[] { ID, newShape, System.currentTimeMillis() };
//		this.allShapes.put(ID, shapeData);
		allshapes.add(shapeData);
		return ID++;
	}

	/**
	 * This method will remove a shape from the screen
	 * 
	 * @param shapeID
	 * @return
	 */
	public boolean removeShape(int shapeID) {
		for (int idx = 0; idx < allshapes.size(); idx++) {
			Object[] data = allshapes.get(idx);
			if ((int) data[0] == shapeID) {
				allshapes.remove(shapeID);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method will print all the shapes that enclosed a point
	 * 
	 * @param point
	 */
	public void getShapesEnclosedPoint(double[] point) {
		for (Object[] shapeData : allshapes) {
			if (((Shape) shapeData[0]).isPointEnclosed(point))
				System.out.println(
						shapeData[0] + "  " + ((Shape) shapeData[1]).getShapeInfo() + "\t" +  shapeData[2]+"Area\t"+((Shape)shapeData[1]).getArea());
		}
	}

	/**
	 * This method will list all the shapes present on the screen
	 * 
	 */
	public void listAllShapes() {
		for (Object[] shapeData : allshapes) {
			System.out.println(
					shapeData[0] + "  " + ((Shape) shapeData[1]).getShapeInfo() + "\t" +  shapeData[2] + "Area\t"+((Shape)shapeData[1]).getArea());
		}
	}
	
	/**
	 * It prints all the sapes when arraylist is passed
	 * 
	 * @param listAllShapes
	 */
	public void listAllShapes(List<Object[]> listAllShapes) {
		for (Object[] shapeData : listAllShapes) {
			System.out.println(
					shapeData[0] + "  " + ((Shape) shapeData[1]).getShapeInfo() + "\t" +  shapeData[2] + "Area\t"+((Shape)shapeData[1]).getArea());
		}
	}

	/**
	 * It sorts the shapes in screen on basis of Area than perimeter, than time Stamp
	 * 
	 * @return
	 */
	public List<Object[]> sortShapes() {
		List<Object[]> sortedShapes = this.allshapes;
		Collections.sort(sortedShapes, new Comparator<Object[]>() {

			@Override
			public int compare(Object[] o1, Object[] o2) {
				if (((Shape) o1[1]).getArea() < ((Shape) o2[1]).getArea())
					return -1;
				else if (((Shape) o1[1]).getPerimeter() < ((Shape) o2[1]).getPerimeter())
					return -1;
				else if ((Long) o1[2] < (Long) o2[2])
					return -1;

				else
					return 1;

			}

		});
		return sortedShapes;

	}

}
