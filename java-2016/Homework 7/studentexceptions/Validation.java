/*
 * This class is an exception class and extends from Exception
 */
package studentexceptions;


public class Validation extends Exception{

	private static final long serialVersionUID = 1L;

	public Validation(String message) {
		super(message);
		
	}

}
