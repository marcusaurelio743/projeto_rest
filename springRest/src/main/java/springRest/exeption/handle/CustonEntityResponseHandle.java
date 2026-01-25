package springRest.exeption.handle;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import springRest.exeption.MathOperationExeption;
import springRest.exeption.ResponseExeption;

@ControllerAdvice
@RestController
public class CustonEntityResponseHandle extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseExeption> handeAllExeptions(Exception ex,WebRequest web){
		ResponseExeption exeption = new ResponseExeption(
				new Date()
				, ex.getMessage()
				, web.getDescription(false));
		
		return ResponseEntity.internalServerError().body(exeption);
	}
	
	@ExceptionHandler(MathOperationExeption.class)
	public final ResponseEntity<ResponseExeption> MathOperationExeption(Exception ex,WebRequest web){
		ResponseExeption exeption = new ResponseExeption(
				new Date()
				, ex.getMessage()
				, web.getDescription(false));
		
		return ResponseEntity.badRequest().body(exeption);
	}
	
}
