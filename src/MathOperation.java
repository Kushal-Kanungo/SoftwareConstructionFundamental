import java.security.InvalidParameterException;

/**
 * class : "MathOperation" Desc: implemented recursive functions to find HCF and
 * LCM of two numbers
 * 
 * @author Kushal
 * @since 19 OCT 2022 4:00 PM
 */
public class MathOperation {

	/**
	 * desc : We used eulid's algorithm to find HCF by dividing smaller value
	 * recursively
	 * 
	 * @param firstNum
	 * @param secondNum
	 * @return HCF of both number
	 */
	public static int calculateHCF(int firstNum, int secondNum) throws InvalidParameterException {
		if (firstNum < 0 || secondNum < 0)
			throw new InvalidParameterException("Numbers cannot be empty");

		if (secondNum > firstNum)
			return calculateHCF(secondNum, firstNum);
		if (secondNum == 0)
			return firstNum;
		else
			return calculateHCF(secondNum, firstNum % secondNum);
	}

	/**
	 * desc : we internally find HCF first and then use formula to find LCM of the
	 * numbers
	 * 
	 * @param firstNum  positive integer
	 * @param secondNum
	 * @return
	 */
	public static int calculateLCM(int firstNum, int secondNum) throws InvalidParameterException {
		int lcm = (firstNum / calculateHCF(firstNum, secondNum)) * secondNum;
		return lcm;
	}
}
