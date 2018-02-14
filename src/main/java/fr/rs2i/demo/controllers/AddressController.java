package fr.rs2i.demo.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.rs2i.demo.models.Address;
import fr.rs2i.demo.services.AddressServiceImp;

@RestController
@RequestMapping("/address")
public class AddressController {
	
private static Logger logger = LogManager.getLogger();
	
	@Autowired
	private AddressServiceImp service;
	
	@CrossOrigin
	@GetMapping(value = "/get/all",
	           produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Address> getAdresses(){
		logger.debug("controller getAdresses()" );
		try{
			return service.getAddresses();
		}catch(Exception e){
			logger.debug(e.getMessage());
		}
	
		return null;
				
	}

}
