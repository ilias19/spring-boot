package fr.rs2i.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.rs2i.demo.models.Address;

@Repository
public interface AddressJpaRepository extends JpaRepository<Address, Long>{
	
	 Address findById(Long id);
	 Address findByName(String name);

}
