package fr.rs2i.demo.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public  @Data class Person {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy = "person", cascade = CascadeType.ALL)
	List<Address> adresses;

}
