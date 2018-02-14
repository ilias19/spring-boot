package fr.rs2i.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.rs2i.demo.models.Person;

@Repository
public interface PersonJpaRepository extends JpaRepository<Person, Long>{
	
	Person findById(Long id);
	Person findByName(String name);

}
