package springRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springRest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
