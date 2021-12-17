package univpm.esame.ProgettoOOP.exception;

public class TypeNotRecognised extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TypeNotRecognised() {
		super();
	}
	
	public TypeNotRecognised(String msg) {
		super(msg);
	}
}
