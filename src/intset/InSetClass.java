package intset;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * class : "InSetClass" desc : This is a immutable class which will store value
 * from 1 - 1001
 * 
 * @author Kushal
 * @since 20 OCT 2022 3:30 PM
 */
public final class InSetClass {
	private final int SET_SIZE = 1001;
	private final int[] set;
	private final int size;

	/**
	 * Constructor for InSetClass it takes an array of positive integers and
	 * initialize the set array.
	 * 
	 * @param setValues
	 */
	public InSetClass(List<Integer> setValues) throws InvalidParameterException {
		int [] tempSet = new int[SET_SIZE];
		int tempSize = 0;
		Arrays.fill(tempSet, 0);
		for (int number : setValues) {
			if (number <= 0 || number > 1000)
				throw new InvalidParameterException("Values should be between 1 - 1000");

			if (tempSet[number] == 0) {
				tempSet[number] = 1;
				tempSize++;
			}
		}
		this.size = tempSize;
		
		if(tempSize==0)
			throw new InvalidParameterException("Set Cannot Be Empty");
		
		this.set = tempSet;
		

	}

	/**
	 * desc : this method will check if the number is present in the array in O(1)
	 * constant time. As we are only looking at the index.
	 * 
	 * @param number
	 * @return boolean
	 */
	public boolean isMember(int number) {
		if (this.set[number] == 1)
			return true;
		return false;
	}

	/**
	 * desc : this will return the size of our created set
	 * 
	 * @return
	 */
	public int getSize() {
		return this.size;
	}

	/**
	 * desc : this method will find all the values present in our created set and
	 * return the array of them.
	 * 
	 * @return set values array
	 */
	public int[] getValues() {
		int[] values = new int[size];
		int valuesIdx = 0;
		for (int idx = 0; idx < SET_SIZE; idx++) {
			if (set[idx] == 1) {
				values[valuesIdx] = idx;
				valuesIdx++;
			}
		}
		return values;
	}

	/**
	 * desc : this method will check if the elements of subset are present in our
	 * set object by looking for 1 at those index.
	 * 
	 * @param subset
	 * @return
	 */
	public boolean isSubSet(InSetClass subset) {
		if (size < subset.getSize())
			return false;
		int[] subsetValues = subset.getValues();
		for (int value : subsetValues) {
			if (set[value] == 0)
				return false;
		}
		return true;
	}

	/**
	 * desc : this method will create a new set which will have only elements that
	 * are not present in our set object.
	 * 
	 * @return
	 */
	public InSetClass getComplement() {
		List<Integer> complementValues = new ArrayList<Integer>();
		for (int index = 1; index < SET_SIZE; index++) {
			if (this.set[index] == 1)
				continue;
			complementValues.add(index);
		}
		return new InSetClass(complementValues);

	}

	/**
	 * desc : We will find get the values of both set values and create new
	 * InSetClass object and return it.
	 * 
	 * @param secondSet
	 * @return
	 */
	public InSetClass unionWith(InSetClass secondSet) {
		List<Integer> unionSetValues = new ArrayList<Integer>();
		int[] firstSetValues = this.getValues();
		int[] secondSetValues = secondSet.getValues();
		for (int firstIdx = 0; firstIdx < firstSetValues.length; firstIdx++) {
			unionSetValues.add(firstSetValues[firstIdx]);
		}
		for (int secondIdx = 0; secondIdx < secondSetValues.length; secondIdx++) {
			unionSetValues.add(secondSetValues[secondIdx]);
		}
		return new InSetClass(unionSetValues);
	}

	/**
	 * It creates a new InSetClass object of element which are available in both set
	 * 
	 * @param secondSet
	 * @return
	 */
	public InSetClass intersectionWith(InSetClass secondSet) {
		List<Integer> intersectionValues = new ArrayList<Integer>();
		for (int idx = 1; idx < SET_SIZE; idx++) {
			if (this.isMember(idx) && secondSet.isMember(idx))
				intersectionValues.add(idx);
		}
		return new InSetClass(intersectionValues);
	}

	/**
	 * desc : It creates a new InSetClass object removing the second set values
	 * 
	 * @param secondSet
	 * @return
	 */
	public InSetClass differnceWith(InSetClass secondSet) {
		List<Integer> differenceValues = new ArrayList<Integer>();
		int[] firstSetValues = this.getValues();
		for (int setValue : firstSetValues) {
			if (secondSet.isMember(setValue) == false)
				differenceValues.add(setValue);
		}
		return new InSetClass(differenceValues);
	}

	/**
	 * desc : this method is used to print all the values present in set
	 * 
	 */
	public void printSet() {
		int[] setValues = this.getValues();
		for (int val : setValues) {
			System.out.print(val + "  ");
		}
	}
}
