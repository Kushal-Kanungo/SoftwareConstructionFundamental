package hexadecimal;

/**
 * InvalidNumberExecption
 * 
 * This Exception is used in HexCalc when a Negative value or Non Hexadecimal Value arises we can
 * throw this error along with custom message
 * 
 * @author Kushal
 * @since 15 Oct 2022
 */
public class InvalidNumberException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * We can provide custom error message in this exception.
	 * 
	 * @author Kushal
	 * @param msg
	 */
	public InvalidNumberException(String msg) {
		super(msg);
	}

}
