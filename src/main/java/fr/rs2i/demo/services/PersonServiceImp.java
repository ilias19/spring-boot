package fr.rs2i.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.rs2i.demo.models.Person;
import fr.rs2i.demo.repositories.PersonJpaRepository;

@Service
public class PersonServiceImp implements PersonService {
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	PersonJpaRepository repository;
	

	public PersonJpaRepository getRepository() {
		return repository;
	}


	public void setRepository(PersonJpaRepository repository) {
		this.repository = repository;
	}


	@Override
	public List<Person> getAllPersons() {
	    logger.debug("service  getAllPersons()" );
		return repository.findAll();
	}

}
