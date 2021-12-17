package univpm.esame.ProgettoOOP.exception;
/**
 * Filter exception
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class FilterException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Filter exception
	 */
	public FilterException() {
		super();
	}
	/**
	 * Filter exception
	 * @param msg error message
	 */
	public FilterException(String msg) {
		super(msg);
	}
}
