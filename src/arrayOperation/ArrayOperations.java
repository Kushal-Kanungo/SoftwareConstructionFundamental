package arrayOperation;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

/**
 * class : ArrayOperations
 * 
 * @author Kushal
 * @since 18 Oct 2022 09:25 A.M.
 */
public class ArrayOperations {

	/**
	 * Desc= We check for each starting point from end of array if mirror exist
	 * 
	 * @param array
	 * @return largest mirror present in array
	 * @throws InvalidParameterException
	 */
	public static int largestMirror(int[] array) throws InvalidParameterException {
		if (array.length < 1) {
			throw new InvalidParameterException();
		}
		int maxMirrorLength = 0;
		int leftPointer = 0;
		int rightPointer;
		while (leftPointer < array.length) {
			rightPointer = array.length - 1;
			int tempLength = 0;
			int tempLeftPointer = leftPointer;
			while (rightPointer >= 0 && tempLeftPointer < array.length) {
				if (array[tempLeftPointer] == array[rightPointer]) {
					tempLength += 1;
					tempLeftPointer += 1;
					rightPointer -= 1;
				} else {
					if (tempLeftPointer == leftPointer) {
						rightPointer -= 1;
					}
					maxMirrorLength = Math.max(tempLength, maxMirrorLength);
					tempLength = 0;
					tempLeftPointer = leftPointer;
				}
			}
			leftPointer += 1;
			maxMirrorLength = Math.max(tempLength, maxMirrorLength);
		}
		return maxMirrorLength;
	}

	/**
	 * Desc = In a single iterate we keep incrementing clumps as we find
	 * 
	 * @param array
	 * @throws InvalidParameterException
	 * @return
	 */
	public static int countClumps(int[] array) throws InvalidParameterException {

		if (array.length < 1) 
			throw new InvalidParameterException("Array is Empty");
		int clumps = 0;
		int index = 1;
		int tempLength = 1;
		while (index < array.length) {
			if (array[index] == array[index - 1])
				tempLength += 1;
			else if (tempLength > 1) {
				clumps += 1;
				tempLength = 1;
			}
			index++;
		}
		if (tempLength > 1)
			clumps += 1;
		return clumps;
	}

	/**
	 * Desc = First We find sum of the array if Odd not Possible, else, we starting
	 * counting until sum become half of total sum and return that index
	 * 
	 * 
	 * @param array
	 * @return
	 * @throws InvalidParameterException
	 */
	public static int splitArray(int[] array) throws InvalidParameterException {
		if (array.length < 2)
			throw new InvalidParameterException("Array length shuld be greater than 2.");

		int totalSum = 0;
		for (int num : array) {
			if (num < 0)
				throw new InvalidParameterException("Elements ");
			totalSum += num;
		}

		if (totalSum % 2 == 1)
			return -1;

		int target = totalSum / 2;
		int computedSum = 0;
		for (int index = 0; index < array.length; index++) {
			computedSum += array[index];
			if (computedSum == target) {
				return index + 1;
			} else if (computedSum > target) {
				return -1;
			}
		}
		return -1;
	}

	/**
	 * Desc = First iterate in array and store index of X and Y. Then we swap those
	 * positions in array and if any condition break we throw a Assertion Error
	 * 
	 * 
	 * @param array
	 * @param X
	 * @param Y
	 * @return
	 * @throws InvalidParameterException
	 */
	public static int[] fixXY(int[] array, int X, int Y) throws InvalidParameterException {

		if (array.length < 1)
			throw new InvalidParameterException("Array Length Should be Greater Than 1");

		List<Integer> xPositions = new ArrayList<Integer>();
		List<Integer> yPositions = new ArrayList<Integer>();

		for (int index = 0; index < array.length; index++) {
			if ((array[index] == Y) && (index == 0 || array[index - 1] != X))
				yPositions.add(index);

			if (array[index] == X && index != array.length - 1 && array[index + 1] != X && (array[index + 1] != Y))
				xPositions.add(index + 1);
		}

		if (xPositions.size() != yPositions.size())
			throw new InvalidParameterException("Number of X and Y are not same");

		for (int idx = 0; idx < xPositions.size(); idx++) {
			int temp = array[xPositions.get(idx)];
			array[xPositions.get(idx)] = array[yPositions.get(idx)];
			array[yPositions.get(idx)] = temp;
		}
		return array;
	}
}
