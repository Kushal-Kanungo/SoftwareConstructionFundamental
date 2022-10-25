package com.searchAlgos;

import java.security.InvalidParameterException;

/**
 * class : "Searching Algorithm"
 * desc : This class have static methods to search in array
 * @author Kushal Kanungo
 * @since 19 Oct 2022 11:15 AM
 *
 */
public class SearchingAlgorithm {
	
	/**
	 * desc : It searches an array by iterating it and find the target value and return the index 
	 * 
	 * @param array 
	 * @param target
	 * @return index of target
	 * @throws InvalidParameterException
	 */
	public static int LinearSearch(int[] array, int target, int idx) throws InvalidParameterException {
		if (array.length < 1)
			throw new InvalidParameterException("Array cannot be empty");
		if (idx >= array.length)
			return -1;
		if (array[idx]==target)
			return idx;
		return LinearSearch(array, target, idx+1);
	}
	
	/**
	 * Overloading the binary functions so that so that we do not need to pass low and high
	 * 
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int binarySearch(int[] arr, int target) {
		return binarySearch(arr, target, 0, arr.length-1);
	}
	
	/**
	 * Implemented recursive searching the first occurrence of the matrix in O(log(n))
	 * 
	 * @param arr
	 * @param target
	 * @param low
	 * @param high
	 * @return
	 * @throws InvalidParameterException
	 */
	private static int binarySearch(int[] arr, int target, int low, int high) throws InvalidParameterException {
		if (arr.length < 1)
			throw new InvalidParameterException("Array Cannot Be Empty");
		
		if(low > high)
			return -1;
		int mid = (high+low)/2;
		if ((mid==0 || arr[mid-1]!=target)&&(arr[mid]==target))
			return mid;
		if (arr[mid] < target)
			return binarySearch(arr, target, mid+1, high);
		return binarySearch(arr, target, low, mid-1);
	}
}
