package hexadecimal;
/**
 * 
 * class HexCalc
 * This Class support various features conversion between decimal and hexadecimal
 * Addition, Subtraction, Multiplication and Division on HexaDecimal Values
 * And Comparison between two hexadecimal values.
 * 
 * 
 * @author Kushal
 * @since 15 Oct 2022
 */
public class HexCalc {

	/**
	 * Start of the end of hexadecimal value and for each character find decimal value and multiply
	 * by base and add to result 
	 * 
	 * 
	 * @author Kushal
	 * @param hexVal 
	 * @return
	 * @throws InvalidNumberException
	 */
	public int toDecimal(String hexVal) throws InvalidNumberException {
		String lookup = "0123456789ABCDEF";
		int decimalValue = 0;
		int base = 1;
		for (int i = hexVal.length() - 1; i >= 0; i--) {
			int index = lookup.indexOf(hexVal.charAt(i));
			 if ((index < 0) || (index >= lookup.length())) {    
		           throw new InvalidNumberException("HexaDecimal Value Is Invalid");    
		       }    
			decimalValue += index * base;
			base *= 16;
		}
		return decimalValue;
	}

	/**
	 * Find remainder of num by 16 and add corresponding char to result.
	 * And keep dividing the number by 16 until it becomes 0.
	 * 
	 * 
	 * @author Kushal
	 * @param num
	 * @return
	 * @throws InvalidNumberException
	 */
	public String toHexaDecimal(int num) throws InvalidNumberException {
		if (num < 0) {
			throw new InvalidNumberException("Number Is Negative Cannot Convert Right Now");

		}
		if (num==0) {
			return "0";
		}
		String hexValue = "";
		int rem;
		char[] lookup = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		while (num > 0) {
			rem = num % 16;
			hexValue = lookup[rem] + hexValue;
			num /= 16;
		}
		
		return hexValue;
	}
	

	/**
	 * Covert 2 Hexadecimal to decimal, add them, and again convert to Hexadecimal
	 * 
	 * @param hexValue1
	 * @param hexValue2
	 * @author Kushal
	 * @return
	 * @throws InvalidNumberException
	 */
	public String hexAdd(String hexValue1, String hexValue2) throws InvalidNumberException {
		int addition = toDecimal(hexValue1) + toDecimal(hexValue2);
		return toHexaDecimal(addition);
	}

	
	/**
	 * Convert hexadecimal to decimal first, then perform action, convert again decimal to hexadecimal,
	 * and return the computed value.
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 * @throws InvalidNumberException
	 */
	public String hexSubtract(String hexValue1, String hexValue2) throws InvalidNumberException {
		int subtracted = toDecimal(hexValue1) - toDecimal(hexValue2);
		if (subtracted < 0) {
			return "A Negative Value";
		}
		return toHexaDecimal(subtracted);
	}

	
	/**
	 * Convert hexadecimal to decimal first, then perform multiplication, convert again, 
	 * decimal to hexadecimal, and return the computed value.
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 * @throws InvalidNumberException
	 * 
	 */
	public String hexMultiply(String hexValue1, String hexValue2) throws InvalidNumberException {
		int product = toDecimal(hexValue1) * toDecimal(hexValue2);
		
		return toHexaDecimal(product);
	}

	/**
	 * 
	 * Convert hexadecimal to decimal first, then perform division, convert again decimal to hexadecimal,
	 * and return the computed value.
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 * @throws InvalidNumberException
	 */
	public String hexDivide(String hexValue1, String hexValue2) throws InvalidNumberException {
		int division = toDecimal(hexValue1) / toDecimal(hexValue2);
		return toHexaDecimal(division);
	}

	/**
	 * To check equality we check each character of values, if all are equal then true else false. 
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 */
	public boolean areEqual(String hexValue1, String hexValue2) {
		if (hexValue1.length() != hexValue2.length()) {
			return false;
		}
		for (int j = 0; j < hexValue1.length(); j++) {
			if (hexValue1.charAt(j) != hexValue2.charAt(j)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * To compare we first check the lengths and then check each character 
	 * For Greater bigger length value will be greater 
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 */
	public boolean isGreater(String hexValue1, String hexValue2) {
		if (hexValue1.length()>hexValue2.length()){
			return true;
		}
		else if (hexValue1.length()<hexValue2.length()){
			return false;
		}
		for(int i=0; i<hexValue1.length(); i++) {
			if (hexValue1.charAt(i)>hexValue2.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Compare length first smaller length will be smaller value
	 * If length is same, then check each char and smaller lexographically smaller string will be smaller
	 * 
	 * @author Kushal
	 * @param hexValue1
	 * @param hexValue2
	 * @return
	 */
	public boolean isSmaller(String hexValue1, String hexValue2) {
		if (hexValue1.length()>hexValue2.length()){
			return false;
		}
		else if (hexValue1.length()<hexValue2.length()){
			return true;
		}
		for(int i=0; i<hexValue1.length(); i++) {
			if (hexValue1.charAt(i)<hexValue2.charAt(i)) {
				return true;
			}
		}
		return false;
	}
}
