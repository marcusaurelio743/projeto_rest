package springRest.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springRest.exeption.MathOperationExeption;

@RestController
@RequestMapping("/math")
public class MathController {
	//exemplo de url localhost:8080/math/sum/2/4
	
	@RequestMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(
			@PathVariable("numberOne") String numberOne,
			@PathVariable("numberTwo") String numberTwo
	) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return converterToDouble(numberOne) + converterToDouble(numberTwo);
	}
	
	@RequestMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return converterToDouble(numberOne) - converterToDouble(numberTwo);
	}
	@RequestMapping("/multi/{numberOne}/{numberTwo}")
	public Double multi(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return converterToDouble(numberOne) * converterToDouble(numberTwo);
	}
	
	@RequestMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return converterToDouble(numberOne) / converterToDouble(numberTwo);
	}
	
	@RequestMapping("/media/{numberOne}/{numberTwo}")
	public Double media(@PathVariable String numberOne, @PathVariable String numberTwo) throws Exception{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return (converterToDouble(numberOne) + converterToDouble(numberTwo))/2;
	}
	
	@RequestMapping("/raiz/{number}")
	public Double raiz(@PathVariable String number) throws Exception{
		if(!isNumeric(number)) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		return Math.sqrt(converterToDouble(number));
	}
	

	private Double converterToDouble(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) {
			throw new MathOperationExeption("O valor Informado é invalido");
		}
		String number = strNumber.replace(",", ".");
		 number.matches("^[0-9]+(\\.[0-9]+)?$");
		return Double.valueOf(number);
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) {
			return false;
		}
		String number = strNumber.replace(",", ".");
		return ( number.matches("^[0-9]+(\\.[0-9]+)?$"));
	}

}
