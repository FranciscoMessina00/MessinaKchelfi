package univpm.esame.ProgettoOOP.exception;

public class TypeNotRecognisedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TypeNotRecognisedException() {
		super();
	}
	
	public TypeNotRecognisedException(String msg) {
		super(msg);
	}
}
