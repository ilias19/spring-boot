package fr.rs2i.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.rs2i.demo.models.Address;
import fr.rs2i.demo.models.Person;
import fr.rs2i.demo.repositories.AddressJpaRepository;
import fr.rs2i.demo.repositories.PersonJpaRepository;

@Component
public class Init {
	
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private PersonJpaRepository personRepository;
	
	@Autowired
	private AddressJpaRepository addressRepository;
	
	@PostConstruct
	public void init(){
		
		try{
			
			Person person1 = Person.builder().name("Schnitzell").build();
			Address address1 = Address.builder().name("villette").person(person1).build();
			Address address2 = Address.builder().name("villette").person(person1).build();
			List<Address> addresses = new ArrayList<Address>();
			addresses.add(address1);
			addresses.add(address2);
			//addressRepository.save(address1);
			person1.setAdresses(addresses);
			personRepository.save(person1);
			//logger.debug("init saving recipes in db");
		}catch(Exception e){
			logger.debug(e.getMessage());
		}
		
		
		
			
		//recipeRepository.save(Arrays.asList(recipe1,recipe2));
	}

}
