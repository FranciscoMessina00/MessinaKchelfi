package univpm.esame.ProgettoOOP.exception;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionClass {
    @ExceptionHandler (value = IllegalBodyException.class)
	public ResponseEntity<String> handlerIllegalBody(IllegalBodyException e){
		return new ResponseEntity<String>(e.getMessage("Error!"));
	}

	@ExceptionHandler (value = IllegalParameterException.class)
	public ResponseEntity<String> handlerIllegalParamter(IllegalParameterException e){
		return new ResponseEntity<String>(e.getMessage("Error!"));
	}
}
