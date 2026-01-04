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
			
			@PathVariable String numberOne,
			@PathVariable String numberTwo
	) {
		return 1D;
	}

}
