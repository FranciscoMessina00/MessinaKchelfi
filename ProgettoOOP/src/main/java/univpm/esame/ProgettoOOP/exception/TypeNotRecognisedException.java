package univpm.esame.ProgettoOOP.exception;
/**
 * Type not recognised exception
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class TypeNotRecognisedException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * Type not recognised exception
	 */
	public TypeNotRecognisedException() {
		super();
	}
	/**
	 * Type not recognised exception
	 * @param msg Error message
	 */
	public TypeNotRecognisedException(String msg) {
		super(msg);
	}
}
