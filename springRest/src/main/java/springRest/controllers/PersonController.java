package springRest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springRest.model.Person;
import springRest.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices services;
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Person findById(@PathVariable("id") Long id) {
		return services.findById(id);
		
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public List<Person> findALL() {
		return services.findAll();
		
	}
	@RequestMapping(
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Person created( @RequestBody Person person) {
		return services.create(person);
		
	}
	@RequestMapping(value = "/{id}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	
	public Person update(
			@PathVariable("id") Long id, @RequestBody Person person) {
		return services.update(person,id);
		
	}
	
	@RequestMapping(value = "/{id}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		services.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
}
