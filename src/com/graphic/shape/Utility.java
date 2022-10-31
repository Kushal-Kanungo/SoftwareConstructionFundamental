package com.graphic.shape;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 
 * 
 * @author Kushal
 *
 */
public class Utility {

	public static double findTriangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
		return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
	}
	
	public static String getTimeStamp() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	/**
	 * Round off upto 2 points
	 * 
	 * @param value
	 * @return
	 */
	 public static double round(double value) {
    	 DecimalFormat decfor = new DecimalFormat("0.00");
    	 return Double.parseDouble(decfor.format(value));
    }
}
