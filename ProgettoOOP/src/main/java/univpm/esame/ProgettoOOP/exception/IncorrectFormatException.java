package univpm.esame.ProgettoOOP.exception;
/**
 * Incorrect format exception
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class IncorrectFormatException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Incorrect format exception
	 */
	public IncorrectFormatException() {
		super();
	}
	/**
	 * Incorrect format exception
	 * @param msg Error message
	 */
	public IncorrectFormatException(String msg){
		super(msg);
	}
}
