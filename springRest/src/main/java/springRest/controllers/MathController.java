package springRest.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
			throw new IllegalArgumentException();
		}
		return converterToDouble(numberOne) + converterToDouble(numberTwo);
	}

	private Double converterToDouble(String strNumber) {
		if(strNumber == null || strNumber.isEmpty()) {
			throw new IllegalArgumentException();
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
