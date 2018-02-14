package fr.rs2i.demo.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.rs2i.demo.models.Address;
import fr.rs2i.demo.repositories.AddressJpaRepository;

@Service
public class AddressServiceImp implements AddressService {
	private static Logger logger = LogManager.getLogger();
	
	@Autowired
	public AddressJpaRepository addressRepository;

	public AddressJpaRepository getAddressRepository() {
		return addressRepository;
	}

	public void setAddressRepository(AddressJpaRepository addressRepository) {
		this.addressRepository = addressRepository;
	}

	@Override
	public List<Address> getAddresses() {
		logger.debug(" service getAddresses()");
		return addressRepository.findAll();
	}

}
