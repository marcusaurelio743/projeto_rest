package springRest.services;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}

	private Person mockPerson(int i) {
		logger.info("find one person MOKS!!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Name: "+i);
		person.setLastName("Last: "+i);
		person.setAddress("Address: "+i);
		person.setGander("Gandre: "+i);
		return person;
	}

}
