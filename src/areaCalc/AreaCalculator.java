package areaCalc;

/**
 * 
 * @author Kushal
 * @since 17 Oct 2022 10:00 A.M.
 */
public class AreaCalculator {

	/**
	 * To find area of triangle by formula 0.5*base*height
	 * 
	 * @param height
	 * @param base
	 * @return
	 */
	public static double calculateTriangleArea(double height, double base) throws ArithmeticException {
		double triangleArea = 0.5 * base * height;
		return triangleArea;
	}

	/**
	 * To find area of Rectangle by formula length*breadth
	 * 
	 * @param length
	 * @param width
	 * @return
	 */
	public static double calculateRectangleArea(double length, double width) throws ArithmeticException {
		double rectangleArea = length * width;
		return rectangleArea;
	}

	/**
	 * To Find Area Of Square by formula side*side
	 * 
	 * @param sideLength
	 * @return
	 */
	public static double calculateSquareArea(double sideLength) throws ArithmeticException {
		double squareArea = sideLength * sideLength;
		return squareArea;
	}

	/**
	 * To Find Area Of A Circle by formula pi*radius*radius
	 * 
	 * @param radius
	 * @return
	 */
	public static double calculateCircleArea(double radius) throws ArithmeticException {
		double circleArea = 3.14 * radius * radius;
		return circleArea;
	}

}
