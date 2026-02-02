package springRest.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springRest.exeption.ResourceNotFoundException;
import springRest.model.Person;
import springRest.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository personRepository;
	
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	
	public Person findById(Long id) {
		logger.info("find one person!!");
		
		return personRepository.findById(id).
				orElseThrow(()->new ResourceNotFoundException("Objeto não encontrado!!"));
	}
	
	public List<Person> findAll(){
		return personRepository.findAll();
	}
	
	public Person create(Person person) {
		logger.info("Create Person!!!");
		return personRepository.save(person);
	}
	
	public Person update(Person person,Long id) {
		logger.info("Update Person!!!");
		Person obj = findById(id);
		
		obj.setAddress(person.getAddress());
		obj.setFirstName(person.getFirstName());
		obj.setLastName(person.getLastName());
		obj.setGander(person.getGander());
		
		return personRepository.save(obj);
	}
	public void deleteById(Long id) {
		logger.info("Delete Person!!!");
		personRepository.deleteById(id);
	}
	

	

}
