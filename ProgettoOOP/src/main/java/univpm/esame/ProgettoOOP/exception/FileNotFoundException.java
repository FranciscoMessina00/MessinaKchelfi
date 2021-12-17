package univpm.esame.ProgettoOOP.exception;
/**
 * File not found exception
 * @author Francisco Messina
 * @author Amine Kchelfi
 */
public class FileNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	/**
	 * File not found
	 */
	public FileNotFoundException() {
		super();
	}
	/**
	 * File not found
	 * @param msg error message
	 */
	public FileNotFoundException(String msg){
		super(msg);
	}
}
