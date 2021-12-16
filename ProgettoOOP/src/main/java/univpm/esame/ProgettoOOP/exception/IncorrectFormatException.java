package univpm.esame.ProgettoOOP.exception;

public class IncorrectFormatException extends Exception{
	private static final long serialVersionUID = 1L;
	public IncorrectFormatException() {
		super();
	}
	public IncorrectFormatException(String msg){
		super(msg);
	}
}
