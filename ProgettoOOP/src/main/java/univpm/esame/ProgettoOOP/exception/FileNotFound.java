package univpm.esame.ProgettoOOP.exception;

public class FileNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FileNotFound() {
		super();
	}
	public FileNotFound(String msg){
		super(msg);
	}
}
