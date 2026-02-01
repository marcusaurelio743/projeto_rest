package springRest.services;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import springRest.model.Person;

@Service
public class PersonServices {
	
	private final AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		logger.info("find one person!!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Marcus");
		person.setLastName("Aurélio");
		person.setAddress("Novo gama GO");
		person.setGander("Pedregal");
		
		return person;
	}

}
